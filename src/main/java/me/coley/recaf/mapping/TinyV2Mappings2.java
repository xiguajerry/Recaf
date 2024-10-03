package me.coley.recaf.mapping;

import com.google.common.base.Preconditions;
import me.coley.recaf.util.Log;
import me.coley.recaf.workspace.Workspace;
import net.fabricmc.mappingio.MappedElementKind;
import net.fabricmc.mappingio.MappingReader;
import net.fabricmc.mappingio.MappingVisitor;
import org.jetbrains.annotations.Nullable;

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

    public Mappings getMappings(TinyV2Mappings.TinyV2SubType direction) {
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
        Map<String, String> mappings = new HashMap<>();
        classMappings.values().forEach(entry -> mappings.put(entry.names[fromIndex], entry.names[toIndex]));
        methodMappings.values().forEach(entry -> mappings.put(entry.names[fromIndex], entry.names[toIndex]));
        fieldMappings.values().forEach(entry -> mappings.put(entry.names[fromIndex], entry.names[toIndex]));

        return new Mappings(workspace) {
            {
                this.setMappings(mappings);
            }
        };
    }

    static class TinyMappingVisitor implements MappingVisitor {
        private String currentClassName = null;
        private String currentMethodQualifier = null;
        private String currentMethodDesc = null;
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
            return true;
        }

        @Override
        public boolean visitMethodArg(int i, int i1, @Nullable String s) throws IOException {
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
