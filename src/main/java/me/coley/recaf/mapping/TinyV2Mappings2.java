package me.coley.recaf.mapping;

import com.google.common.base.Preconditions;
import me.coley.recaf.util.Log;
import me.coley.recaf.workspace.Workspace;
import net.fabricmc.mappingio.MappedElementKind;
import net.fabricmc.mappingio.MappingReader;
import net.fabricmc.mappingio.MappingVisitor;
import org.jetbrains.annotations.Nullable;
import org.objectweb.asm.Type;

import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Path;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

// TODO: Make it global
public class TinyV2Mappings2 extends FileMappings {
    public HashMap<String, MappingEntry> classMappings = null;
    public HashMap<String, MappingEntry> fieldMappings = null;
    public HashMap<String, MappingEntry> methodMappings = null;
    public List<String> namespaces = null;

    /**
     * Constructs mappings from a given file.
     *
     * @param path      A path to a file containing Tiny-V2 styled mappings.
     * @param workspace Workspace to pull names from when using hierarchy lookups.
     * @throws IOException Thrown if the file could not be read.
     */
    public TinyV2Mappings2(Path path, Workspace workspace) throws IOException {
        super(path, workspace, false);
        read(path.toFile());
    }

    @Override
    protected Map<String, String> parse(String text) {
        try {
            TinyMappingVisitor visitor = new TinyMappingVisitor();
            MappingReader.read(new StringReader((text)), visitor);
            Log.info("Found {} elements", visitor.mappingElements.size());
            classMappings = visitor.classMappings;
            methodMappings = visitor.methodMappings;
            fieldMappings = visitor.fieldMappings;
            namespaces = Arrays.asList(visitor.namespaces);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return Collections.emptyMap();
    }

    @Nullable
    public String getMissingNamespace() {
        List<String> fullNamespaces = Arrays.asList("official", "intermediary", "named");
        AtomicReference<String> missing = new AtomicReference<>();
        fullNamespaces.forEach(namespace -> {
            if (!namespaces.contains(namespace)) {
                Preconditions.checkState(missing.get() == null);
                missing.set(namespace);
            }
        });
        return missing.get();
    }

    /**
     * Don't modify this unless you know what you are doing.
     */
    // stage 0 -> class
    // stage 1 -> members
    public Mappings getMappings(TinyV2Mappings.TinyV2SubType direction, int stage) {
        String from;
        String to;
        switch (direction) {
            case OBF_TO_CLEAN:
                from = "official";
                to = "named";
                break;
            case OBF_TO_INTERMEDIATE:
                from = "official";
                to = "intermediary";
                break;
            case INTERMEDIATE_TO_CLEAN:
                from = "intermediary";
                to = "named";
                break;
            case INTERMEDIATE_TO_OBF:
                from = "intermediary";
                to = "official";
                break;
            case CLEAN_TO_INTERMEDIATE:
                from = "named";
                to = "intermediary";
                break;
            case CLEAN_TO_OBF:
                from = "named";
                to = "official";
                break;
            default: throw new IllegalStateException();
        }
        String missingNamespace = getMissingNamespace();
        if (Objects.equals(from, missingNamespace) || Objects.equals(to, missingNamespace)) {
            Log.error("Missing namespace {} in tinyv2 mappings.", missingNamespace);
            return new Mappings(workspace) {
                @Override
                public Map<String, String> getMappings() {
                    return Collections.emptyMap();
                }
            };
        }

        int fromIndex = namespaces.indexOf(from);
        int toIndex = namespaces.indexOf(to);
        Map<String, String> mappings = new LinkedHashMap<>();
        if (stage == 0) {
            classMappings.values().forEach(entry -> mappings.put(entry.names[fromIndex], entry.names[toIndex]));
        } else {
            classMappings.values().forEach(entry -> mappings.put(entry.names[fromIndex], entry.names[toIndex]));
//        methodMappings.values().forEach(entry -> mappings.put(entry.names[fromIndex], stripMethodName(entry.names[toIndex])));
//        fieldMappings.values().forEach(entry -> mappings.put(entry.names[fromIndex], stripFieldName(entry.names[toIndex])));
            methodMappings.values().forEach(entry -> {
                final String originalQualifier = entry.names[fromIndex];
                String newOwner = mappings.get(stripOwnerName(originalQualifier));
                Type returnType = Type.getReturnType(stripMethodDesc(originalQualifier));
                Type[] argTypes = Type.getArgumentTypes(stripMethodDesc(originalQualifier));
                if (returnType.getSort() == Type.OBJECT) {
                    MappingEntry entry0 = classMappings.get(returnType.getInternalName());
                    String newReturnInternalType = entry0 != null ? entry0.names[toIndex] : null;
                    returnType = newReturnInternalType != null ? Type.getObjectType(newReturnInternalType) : returnType;
                } else if (returnType.getSort() == Type.ARRAY) {
                    Type elementType = returnType.getElementType();
                    if (elementType.getSort() == Type.ARRAY) {
                        String newElementType = classMappings.get(elementType.getInternalName()).names[toIndex];
                        returnType = Type.getType(returnType.getInternalName().replace(
                                elementType.getInternalName(), newElementType == null ? elementType.getInternalName() : "L" + newElementType
                        ));
                    }
                }
                for (int i = 0; i < argTypes.length; i++) {
                    final Type argType = argTypes[i];
                    if (argType.getSort() != Type.OBJECT && argType.getSort() != Type.ARRAY) continue;
                    if (argType.getSort() == Type.ARRAY) {
                        Type elementType = argType.getElementType();
                        if (elementType.getSort() == Type.ARRAY) {
                            String newElementType = classMappings.get(elementType.getInternalName()).names[toIndex];
                            argTypes[i] = Type.getType(argType.getInternalName().replace(
                                    elementType.getInternalName(), newElementType == null ? elementType.getInternalName() : "L" + newElementType
                            ));
                        }
                    } else {
                        MappingEntry entry0 = classMappings.get(argType.getInternalName());
                        String newArgInternalType = entry0 != null ? entry0.names[toIndex] : null;
                        argTypes[i] = newArgInternalType != null ? Type.getObjectType(newArgInternalType) : returnType;
                    }
                }

                Type newMethodType;
                if (argTypes.length == 0 ) newMethodType = Type.getMethodType(returnType);
                else newMethodType = Type.getMethodType(returnType, argTypes);
                mappings.put(replaceDesc(replaceOwner(entry.names[fromIndex], newOwner), newMethodType.getDescriptor()), stripMethodName(entry.names[toIndex]));
                mappings.put(replaceDesc(entry.names[fromIndex], newMethodType.getDescriptor()), stripMethodName(entry.names[toIndex]));
            });
            fieldMappings.values().forEach(entry -> {
                String newOwner = mappings.get(stripOwnerName(entry.names[fromIndex]));
                mappings.put(replaceOwner(entry.names[fromIndex], newOwner), stripFieldName(entry.names[toIndex]));
                mappings.put(entry.names[fromIndex], stripFieldName(entry.names[toIndex]));
            });
        }

        return new Mappings(workspace) {
            {
                this.setMappings(Collections.unmodifiableMap(mappings));
            }
        };
    }

    private static String stripFieldName(String qualifier) {
        return qualifier.substring(qualifier.lastIndexOf('.') + 1);
    }

    private static String stripMethodName(String qualifier) {
        return qualifier.substring(qualifier.lastIndexOf('.') + 1, qualifier.indexOf("("));
    }

    private static String stripMethodDesc(String qualifier) {
        return qualifier.substring(qualifier.lastIndexOf('('));
    }

    private static String stripOwnerName(String qualifier) {
        return qualifier.substring(0, qualifier.lastIndexOf('.'));
    }

    private static String replaceOwner(String qualifier, String newOwner) {
        return newOwner + qualifier.substring(qualifier.lastIndexOf('.'));
    }

    private static String replaceDesc(String qualifier, String newDesc) {
        return qualifier.substring(0, qualifier.indexOf("(")) + newDesc;
    }

    static class TinyMappingVisitor implements MappingVisitor {
        private String currentClassName = null;
        private String currentMethodQualifier = null;
        private String currentMethodDesc = null;
        private Type currentMethodType = null;
        private String currentFieldQualifier = null;
        public List<String> mappingElements = new ArrayList<>();
        public String[] namespaces = null;
        public HashMap<String, MappingEntry> classMappings = new HashMap<>();
        public HashMap<String, MappingEntry> fieldMappings = new HashMap<>();
        public HashMap<String, MappingEntry> methodMappings = new HashMap<>();

        @Override
        public void visitNamespaces(String src, List<String> targets) throws IOException {
            Log.info("Visiting namespaces: {}, {}", src, targets);
            if (targets.size() == 1) {
                Log.info("Detected single mapping between {} and {}", src, targets.get(0));
                namespaces = new String[]{src, targets.get(0)};
            } else {
                namespaces = new String[]{src, targets.get(0), targets.get(1)};
            }
        }

        @Override
        public boolean visitClass(String name) throws IOException {
            currentClassName = name;
            return true;
        }

        @Override
        public boolean visitField(String name, @Nullable String desc) throws IOException {
            currentFieldQualifier = currentClassName + "." + name;
            return true;
        }

        @Override
        public boolean visitMethod(String name, @Nullable String desc) throws IOException {
            currentMethodQualifier = currentClassName + "." + name;
            currentMethodDesc = desc;
            currentMethodType = Type.getMethodType(desc);
            return true;
        }

        @Override
        public boolean visitMethodArg(int argPosition, int lvIndex, @Nullable String srcName) throws IOException {
            return false;
        }

        @Override
        public boolean visitMethodVar(int i, int i1, int i2, int i3, @Nullable String s) throws IOException {
            return false;
        }

        @Override
        public void visitDstName(MappedElementKind mappedElementKind, int namespace, String name) throws IOException {
            switch (mappedElementKind) {
                case CLASS:
                    mappingElements.add(namespaces[0] + " -> " + namespaces[namespace + 1] + " " +
                                    currentClassName + " -> " + name);
                    classMappings.computeIfAbsent(currentClassName, source -> {
                        MappingEntry entry = new MappingEntry();
                        entry.names[0] = source;
                        entry.names[namespace + 1] = name;
                        return entry;
                    }).names[namespace + 1] = name;
                    break;
                case FIELD:
                    String mappedFieldQualifier = classMappings.get(currentClassName).names[namespace + 1] + "." + name;
                    mappingElements.add(namespaces[0] + " -> " + namespaces[namespace + 1] + " " +
                            currentFieldQualifier + " -> " + mappedFieldQualifier);
                    fieldMappings.computeIfAbsent(currentFieldQualifier, source -> {
                        MappingEntry entry = new MappingEntry();
                        entry.names[0] = source;
                        entry.names[namespace + 1] = name;
                        return entry;
                    }).names[namespace + 1] = mappedFieldQualifier;
                    break;
                case METHOD:
                    String mappedMethodQualifier = classMappings.get(currentClassName).names[namespace + 1] + "." + name + currentMethodDesc;
                    mappingElements.add(namespaces[0] + " -> " + namespaces[namespace + 1] + " " +
                            currentMethodQualifier + currentMethodDesc + " -> " + mappedMethodQualifier);
                    methodMappings.computeIfAbsent(currentMethodQualifier + currentMethodDesc, source -> {
                        MappingEntry entry = new MappingEntry();
                        entry.names[0] = source;
                        entry.names[namespace + 1] = name;
                        return entry;
                    }).names[namespace + 1] = mappedMethodQualifier;
                    break;
                case METHOD_ARG:
                case METHOD_VAR:
                    break;
            }
        }

        @Override
        public void visitComment(MappedElementKind mappedElementKind, String s) throws IOException {}
    }

    public static class MappingEntry {
        public String[] names = {null, null, null};

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            MappingEntry that = (MappingEntry) o;
            return Objects.deepEquals(names, that.names);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(names);
        }
    }
}
