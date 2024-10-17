package me.coley.recaf.util;

import me.coley.recaf.Recaf;
import org.apache.commons.lang3.StringEscapeUtils;
import org.objectweb.asm.*;
import org.objectweb.asm.util.ASMifier;

import java.util.*;

public class GenesisASMifier extends ASMifier {
    /** A pseudo access flag used to distinguish class access flags. */
    private static final int ACCESS_CLASS = 0x40000;

    /** A pseudo access flag used to distinguish field access flags. */
    private static final int ACCESS_FIELD = 0x80000;

    /** A pseudo access flag used to distinguish inner class flags. */
    private static final int ACCESS_INNER = 0x100000;

    /** A pseudo access flag used to distinguish module requires / exports flags. */
    private static final int ACCESS_MODULE = 0x200000;

    private static final List<String> FRAME_TYPES =
            List.of("Opcodes.TOP",
                    "Opcodes.INTEGER",
                    "Opcodes.FLOAT",
                    "Opcodes.DOUBLE",
                    "Opcodes.LONG",
                    "Opcodes.NULL",
                    "Opcodes.UNINITIALIZED_THIS"
            );

    public static final String imports = """
import net.spartanb312.genesis.extensions.*
import net.spartanb312.genesis.extensions.insn.*
import org.objectweb.asm.*
""";

    private int indentLevel;
    private String indentString;
    private boolean isVisitingClass = false;
    private int methodIndex = 0;
    private int fieldIndex = 0;

    public GenesisASMifier(int api, String visitorVariableName, int annotationVisitorId, int indentLevel) {
        super(api, visitorVariableName, annotationVisitorId);
        this.indentString = "\t".repeat(indentLevel);
        this.indentLevel = indentLevel;
    }

    public GenesisASMifier() {
        this(/* latest api = */ Opcodes.ASM9, "classWriter", 0, 0);
    }

    private static final String COMMA = "\", \"";

    private static String getDSLClassVersion(int version) {
        if (version == Opcodes.V1_1) return "Java1";
        return "Java" + (version - Opcodes.V1_2 + 2);
    }

    @Override
    public void visit(
            int version,
            int access,
            String name,
            String signature,
            String superName,
            String[] interfaces
    ) {
        stringBuilder.setLength(0);
        stringBuilder.append(indentString).append("val ").append(this.name).append(" = clazz(\n");
        stringBuilder.append(indentString).append("\taccess = ");
        appendAccessFlags(access);
        stringBuilder.append(", \n").append(indentString).append("\tname = ");
        appendConstant(name);
        stringBuilder.append(", \n").append(indentString).append("\tsuperName = ");
        appendConstant(superName);
        stringBuilder.append(", \n").append(indentString).append("\tinterfaces = ");
        appendConstant(Arrays.asList(interfaces));
        stringBuilder.append(", \n").append(indentString).append("\tsignature = ");
        appendConstant(signature);
        stringBuilder.append(", \n").append(indentString).append("\tversion = ");
        stringBuilder.append(getDSLClassVersion(version));
        if ((version & Opcodes.V_PREVIEW) == Opcodes.V_PREVIEW)
            stringBuilder.append(" + Preview");
        stringBuilder.append("\n").append(indentString).append(") { \n");
        text.add(stringBuilder.toString());
        this.isVisitingClass = true;
        indentLevel++;
        indentString = "\t".repeat(indentLevel);
//        ASMifier asmifier = createASMifier("instructionsVisitor", 0, indentLevel);
//        text.add(asmifier.getText());
//        text.add(indentString + "}\n");
    }

    @Override
    public void visitSource(String file, String debug) {
//        super.visitSource(file, debug);
    }

    @Override
    public ASMifier visitField(
            int access,
            String name,
            String descriptor,
            String signature,
            Object value
    ) {
        stringBuilder.setLength(0);
        String visitorName = this.name;
        if (isVisitingClass) visitorName = "field" + fieldIndex;
        stringBuilder.append(indentString).append("val ").append(visitorName).append(" = field(access = ");
        appendAccessFlags(access);
        stringBuilder.append(", name = ");
        appendConstant(name);
        stringBuilder.append(", desc = ");
        appendConstant(descriptor);
        stringBuilder.append(", signature = ");
        appendConstant(signature);
        stringBuilder.append(", value = ");
        appendConstant(value);
        stringBuilder.append(") { \n");
        text.add(stringBuilder.toString());
        GenesisASMifier asmifier = createASMifier("fieldVisitor", 0, indentLevel + 1);
        asmifier.isVisitingClass = isVisitingClass;
        asmifier.fieldIndex = fieldIndex++;
        text.add(asmifier.getText());
        text.add(indentString + "}\n");
        if (isVisitingClass) {
            text.add(indentString + "+" + visitorName + "\n");
        }
        return asmifier;
    }

    @Override
    public ASMifier visitMethod(
            final int access,
            final String name,
            final String descriptor,
            final String signature,
            final String[] exceptions
    ) {
        stringBuilder.setLength(0);
        String visitorName = this.name;
        if (!name.equals("<clinit>")) {
            if (isVisitingClass) visitorName = "method" + methodIndex;
            stringBuilder.append(indentString).append("val ").append(visitorName).append(" = method(access = ");
            appendAccessFlags(access);
            stringBuilder.append(", name = ");
            appendConstant(name);
            stringBuilder.append(", desc = ");
            appendConstant(descriptor);
            stringBuilder.append(", signature = ");
            appendConstant(signature);
            stringBuilder.append(", exceptions = ");
            if (exceptions != null && exceptions.length > 0) {
                stringBuilder.append("arrayOf(");
                for (int i = 0; i < exceptions.length; ++i) {
                    stringBuilder.append(i == 0 ? "" : ", ");
                    appendConstant(exceptions[i]);
                }
                stringBuilder.append(")");
            } else {
                stringBuilder.append("null");
            }
            stringBuilder.append(") { \n");
        } else {
            stringBuilder.append(indentString).append("clinit { \n");
        }
        text.add(stringBuilder.toString());
        GenesisASMifier asmifier = createASMifier("instructionsVisitor", 0, indentLevel + 1);
        asmifier.isVisitingClass = isVisitingClass;
        asmifier.methodIndex = methodIndex++;
        text.add(asmifier.getText());
        text.add(indentString + "}\n");
        if (isVisitingClass && !name.equals("<clinit>")) {
            text.add(indentString + "+" + visitorName + "\n");
        }
        return asmifier;
    }

    @Override
    public void visitNestMember(String nestMember) {
    }

    @Override
    public void visitNestHost(String nestHost) {
    }

    @Override
    public void visitInnerClass(String name, String outerName, String innerName, int access) {
    }

    @Override
    public void visitOuterClass(String owner, String name, String descriptor) {
    }

    protected GenesisASMifier createASMifier(
            final String visitorVariableName, final int annotationVisitorId, int indentLevel
    ) {
        return new GenesisASMifier(api, visitorVariableName, annotationVisitorId, indentLevel);
    }

    @Override
    protected GenesisASMifier createASMifier(
            final String visitorVariableName, final int annotationVisitorId
    ) {
        return new GenesisASMifier(api, visitorVariableName, annotationVisitorId, 0);
    }

    private void appendString(final String string) {
        stringBuilder.append('\"');
        stringBuilder.append(StringEscapeUtils.escapeJava(string).replace("$", "\\$"));
        stringBuilder.append('\"');
    }

    @Override
    protected void appendConstant(Object value) {
        if (value == null) {
            stringBuilder.append("null");
        } else if (value instanceof String) {
            appendString((String) value);
        } else if (value instanceof Type) {
            stringBuilder.append("Type.getType(");
            appendConstant(((Type) value).getDescriptor());
            stringBuilder.append(")");
        } else if (value instanceof Handle handle) {
            stringBuilder.append("Handle(");
            stringBuilder.append("Opcodes.").append(HANDLE_TAG[handle.getTag()]).append(", ");
            appendConstant(handle.getOwner());
            stringBuilder.append(", ");
            appendConstant(handle.getName());
            stringBuilder.append(", ");
            appendConstant(handle.getDesc());
            stringBuilder.append(", ");
            appendConstant(handle.isInterface());
            stringBuilder.append(')');
        } else if (value instanceof ConstantDynamic constantDynamic) {
            stringBuilder.append("ConstantDynamic(");
            appendConstant(constantDynamic.getName());
            stringBuilder.append(", ");
            appendConstant(constantDynamic.getDescriptor());
            stringBuilder.append(", ");
            appendConstant(constantDynamic.getBootstrapMethod());
            stringBuilder.append(", ");
            int bootstrapMethodArgumentCount = constantDynamic.getBootstrapMethodArgumentCount();
            for (int i = 0; i < bootstrapMethodArgumentCount; ++i) {
                appendConstant(constantDynamic.getBootstrapMethodArgument(i));
                if (i != bootstrapMethodArgumentCount - 1) {
                    stringBuilder.append(", ");
                }
            }
            stringBuilder.append(")");
        } else if (value instanceof Byte) {
            stringBuilder.append(value).append("toByte()");
        } else if (value instanceof Boolean) {
            stringBuilder.append((Boolean) value ? "true" : "false");
        } else if (value instanceof Short) {
            stringBuilder.append(value).append(".toShort()");
        } else if (value instanceof Character) {
            stringBuilder
                    .append((int) (Character) value)
                    .append(".toChar()");
        } else if (value instanceof Integer) {
            stringBuilder.append(((Integer) value).intValue()).append(".toInt()");
        } else if (value instanceof Float) {
            stringBuilder.append(((Float) value).floatValue()).append("f");
        } else if (value instanceof Long) {
            stringBuilder.append(value).append("L");
        } else if (value instanceof Double) {
            stringBuilder.append(value).append(".toDouble()");
        } else if (value instanceof byte[] byteArray) {
            stringBuilder.append("byteArrayOf(");
            for (int i = 0; i < byteArray.length; i++) {
                stringBuilder.append(i == 0 ? "" : ", ").append(byteArray[i]);
            }
            stringBuilder.append(')');
        } else if (value instanceof boolean[] booleanArray) {
            stringBuilder.append("booleanArrayOf(");
            for (int i = 0; i < booleanArray.length; i++) {
                stringBuilder.append(i == 0 ? "" : ", ").append(booleanArray[i]);
            }
            stringBuilder.append(')');
        } else if (value instanceof short[] shortArray) {
            stringBuilder.append("shortArrayOf(");
            for (int i = 0; i < shortArray.length; i++) {
                stringBuilder.append(i == 0 ? "" : ", ").append(shortArray[i]).append(".toShort()");
            }
            stringBuilder.append(')');
        } else if (value instanceof char[] charArray) {
            stringBuilder.append("charArrayOf(");
            for (int i = 0; i < charArray.length; i++) {
                stringBuilder.append(i == 0 ? "" : ", ").append((int) charArray[i]).append(".toChar()");
            }
            stringBuilder.append(')');
        } else if (value instanceof int[] intArray) {
            stringBuilder.append("intArrayOf(");
            for (int i = 0; i < intArray.length; i++) {
                stringBuilder.append(i == 0 ? "" : ", ").append(intArray[i]);
            }
            stringBuilder.append(')');
        } else if (value instanceof long[] longArray) {
            stringBuilder.append("longArrayOf(");
            for (int i = 0; i < longArray.length; i++) {
                stringBuilder.append(i == 0 ? "" : ", ").append(longArray[i]).append('L');
            }
            stringBuilder.append(')');
        } else if (value instanceof float[] floatArray) {
            stringBuilder.append("floatArrayOf(");
            for (int i = 0; i < floatArray.length; i++) {
                stringBuilder.append(i == 0 ? "" : ", ").append(floatArray[i]).append('f');
            }
            stringBuilder.append(')');
        } else if (value instanceof double[] doubleArray) {
            stringBuilder.append("doubleArrayOf(");
            for (int i = 0; i < doubleArray.length; i++) {
                stringBuilder.append(i == 0 ? "" : ", ").append(doubleArray[i]).append('d');
            }
            stringBuilder.append(')');
        } else if (value instanceof List<?> list) {
            stringBuilder.append("listOf(");
            for (int i = 0; i < list.size(); i++) {
                stringBuilder.append(i == 0 ? "" : ", ");
                appendConstant(list.get(i));
            }
            stringBuilder.append(')');
        }
    }

    /**
     * Calls {@link #declareLabel} for each label in the given stack map frame types.
     *
     * @param numTypes the number of stack map frame types in 'frameTypes'.
     * @param frameTypes an array of stack map frame types, in the format described in {@link
     *     MethodVisitor#visitFrame}.
     */
    private void declareFrameTypes(final int numTypes, final Object[] frameTypes) {
        for (int i = 0; i < numTypes; ++i) {
            if (frameTypes[i] instanceof Label) {
                declareLabel((Label) frameTypes[i]);
            }
        }
    }

    /**
     * Appends the given stack map frame types to {@link #stringBuilder}.
     *
     * @param numTypes the number of stack map frame types in 'frameTypes'.
     * @param frameTypes an array of stack map frame types, in the format described in {@link
     *     MethodVisitor#visitFrame}.
     */
    private void appendFrameTypes(final int numTypes, final Object[] frameTypes) {
        for (int i = 0; i < numTypes; ++i) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            if (frameTypes[i] instanceof String) {
                appendConstant(frameTypes[i]);
            } else if (frameTypes[i] instanceof Integer) {
                stringBuilder.append(FRAME_TYPES.get(((Integer) frameTypes[i]).intValue()));
            } else {
                appendLabel((Label) frameTypes[i]);
            }
        }
    }

    @Override
    public ASMifier visitFieldAnnotation(String descriptor, boolean visible) {
        stringBuilder.setLength(0);
        if (visible) {
            stringBuilder.append(indentString).append("+annotation(descriptor = ");
        } else {
            stringBuilder.append(indentString).append("+invisibleAnnotation(descriptor = ");
        }
        appendConstant(descriptor);
        stringBuilder.append(") {\n");
        text.add(stringBuilder.toString());
        GenesisASMifier asmifier = new GenesisASMifier(api, name, 0, indentLevel + 1);
        text.add(asmifier.getText());
        text.add(indentString + "}\n");
        return asmifier;
    }

    @Override
    public ASMifier visitAnnotation(String descriptor, boolean visible) {
        stringBuilder.setLength(0);
        if (visible) {
            stringBuilder.append(indentString).append("+annotation(descriptor = ");
        } else {
            stringBuilder.append(indentString).append("+invisibleAnnotation(descriptor = ");
        }
        appendConstant(descriptor);
        stringBuilder.append(") {\n");
        text.add(stringBuilder.toString());
        GenesisASMifier asmifier = new GenesisASMifier(api, name, 0, indentLevel + 1);
        text.add(asmifier.getText());
        text.add(indentString + "}\n");
        return asmifier;
    }

    @Override
    public ASMifier visitAnnotation(String name, String descriptor) {
        stringBuilder.setLength(0);
        stringBuilder.append(indentString).append("ANNOTATION(name = ");
        appendConstant(name);
        stringBuilder.append(indentString).append(", annotation(descriptor = ");
        appendConstant(descriptor);
        stringBuilder.append(") {\n");
        text.add(stringBuilder.toString());
        GenesisASMifier asmifier = new GenesisASMifier(api, name, 0, indentLevel + 1);
        text.add(asmifier.getText());
        text.add(indentString + "})\n");
        return asmifier;
    }

    @Override
    public void visitEnum(String name, String descriptor, String value) {
        stringBuilder.setLength(0);
        stringBuilder.append(indentString).append("ENUM(");
        appendConstant(name);
        stringBuilder.append(", ");
        appendConstant(descriptor);
        stringBuilder.append(", ");
        appendConstant(value);
        stringBuilder.append(")\n");
        text.add(stringBuilder.toString());
    }

    @Override
    public ASMifier visitArray(String name) {
        stringBuilder.setLength(0);
        stringBuilder.append(indentString).append("ARRAY(name = ");
        appendConstant(name);
        stringBuilder.append(") {\n");
        text.add(stringBuilder.toString());
        GenesisASMifier asmifier = new GenesisASMifier(api, name, 0, indentLevel + 1);
        text.add(asmifier.getText());
        text.add(indentString + "})\n");
        return asmifier;
    }

    @Override
    public ASMifier visitAnnotationDefault() {
        stringBuilder.setLength(0);
        stringBuilder.append(indentString).append("ANNOTATIONDEFAULT");
        stringBuilder.append(" {\n");
        text.add(stringBuilder.toString());
        GenesisASMifier asmifier = new GenesisASMifier(api, name, 0, indentLevel + 1);
        text.add(asmifier.getText());
        text.add(indentString + "}\n");
        return asmifier;
    }

    @Override
    public void visit(String name, Object value) {
        stringBuilder.setLength(0);
        stringBuilder.append(indentString).append("VALUE(");
        appendConstant(name);
        stringBuilder.append(", ");
        appendConstant(value);
        stringBuilder.append(")\n");
        text.add(stringBuilder.toString());
    }

    @Override
    public void visitAnnotationEnd() {
//        super.visitAnnotationEnd();
    }

    @Override
    public void visitFieldEnd() {
        stringBuilder.setLength(0);
        indentLevel -= 1;
        indentString = "\t".repeat(indentLevel);
//        stringBuilder.append(indentString).append("}\n");
//        if (isVisitingClass) {
//            stringBuilder.append(indentString).append("+field").append(fieldIndex).append("\n");
//        }
        text.add(stringBuilder.toString());
    }

    @Override
    public void visitFrame(
            final int type,
            final int numLocal,
            final Object[] local,
            final int numStack,
            final Object[] stack
    ) {
        if (Recaf.getController().config().enhancement().gruntDSLIgnoreFrames) return;
        stringBuilder.setLength(0);
        switch (type) {
            case Opcodes.F_NEW:
            case Opcodes.F_FULL:
                declareFrameTypes(numLocal, local);
                declareFrameTypes(numStack, stack);
                if (type == Opcodes.F_NEW) {
                    stringBuilder.append(indentString).append("FRAME(Opcodes.F_NEW, ");
                } else {
                    stringBuilder.append(indentString).append("FRAME(Opcodes.F_FULL, ");
                }
                stringBuilder.append(numLocal).append(", arrayOf(");
                appendFrameTypes(numLocal, local);
                stringBuilder.append("), ").append(numStack).append(", arrayOf(");
                appendFrameTypes(numStack, stack);
                stringBuilder.append(')');
                break;
            case Opcodes.F_APPEND:
                declareFrameTypes(numLocal, local);
                stringBuilder.append(indentString)
                        .append("FRAME(Opcodes.F_APPEND, ")
                        .append(numLocal)
                        .append(", arrayOf(");
                appendFrameTypes(numLocal, local);
                stringBuilder.append("), 0, null");
                break;
            case Opcodes.F_CHOP:
                stringBuilder.append(indentString)
                        .append("FRAME(Opcodes.F_CHOP, ")
                        .append(numLocal)
                        .append(", null, 0, null");
                break;
            case Opcodes.F_SAME:
                stringBuilder.append(indentString).append("FRAME(Opcodes.F_SAME, 0, null, 0, null");
                break;
            case Opcodes.F_SAME1:
                declareFrameTypes(1, stack);
                stringBuilder.append(indentString)
                        .append("FRAME(Opcodes.F_SAME1, 0, null, 1, arrayOf(");
                appendFrameTypes(1, stack);
                stringBuilder.append(')');
                break;
            default:
                throw new IllegalArgumentException();
        }
        stringBuilder.append(")\n");
        text.add(stringBuilder.toString());
    }

    @Override
    public void visitVarInsn(int opcode, int varIndex) {
        stringBuilder.setLength(0);
        stringBuilder.append(indentString).append(OPCODES[opcode]).append("(").append(varIndex).append(")\n");
        text.add(stringBuilder.toString());
    }

    @Override
    public void visitTypeInsn(int opcode, String type) {
        stringBuilder.setLength(0);
        stringBuilder.append(indentString).append(OPCODES[opcode]).append("(");
        appendString(type);
        stringBuilder.append(")\n");
        text.add(stringBuilder.toString());
    }

    @Override
    public void visitFieldInsn(int opcode, String owner, String name, String descriptor) {
        stringBuilder.setLength(0);
        stringBuilder.append(indentString).append(OPCODES[opcode]).append("(");
        appendConstant(owner);
        stringBuilder.append(", ");
        appendConstant(name);
        stringBuilder.append(", ");
        appendConstant(descriptor);
        stringBuilder.append(")\n");
        text.add(stringBuilder.toString());
    }

    @Override
    public void visitParameter(String parameterName, int access) {

    }

    @Override
    public void visitMethodInsn(int opcode, String owner, String name, String descriptor, boolean isInterface) {
        stringBuilder.setLength(0);
        stringBuilder
                .append(indentString)
                .append(OPCODES[opcode])
                .append("(");
        appendConstant(owner);
        stringBuilder.append(", ");
        appendConstant(name);
        stringBuilder.append(", ");
        appendConstant(descriptor);
        stringBuilder.append(", ");
        stringBuilder.append(isInterface ? "true" : "false");
        stringBuilder.append(")\n");
        text.add(stringBuilder.toString());
    }

    @Override
    public void visitInvokeDynamicInsn(
            final String name,
            final String descriptor,
            final Handle bootstrapMethodHandle,
            final Object... bootstrapMethodArguments
    ) {
        stringBuilder.setLength(0);
        stringBuilder.append(indentString).append("INVOKEDYNAMIC(");
        appendConstant(name);
        stringBuilder.append(", ");
        appendConstant(descriptor);
        stringBuilder.append(", ");
        appendConstant(bootstrapMethodHandle);
        stringBuilder.append(", ");
        for (int i = 0; i < bootstrapMethodArguments.length; ++i) {
            appendConstant(bootstrapMethodArguments[i]);
            if (i != bootstrapMethodArguments.length - 1) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append(")\n");
        text.add(stringBuilder.toString());
    }

    @Override
    public void visitJumpInsn(final int opcode, final Label label) {
        stringBuilder.setLength(0);
        declareLabel(label);
        stringBuilder.append(indentString).append(OPCODES[opcode]).append("(");
        appendLabel(label);
        stringBuilder.append(")\n");
        text.add(stringBuilder.toString());
    }

    @Override
    public void visitLabel(final Label label) {
        stringBuilder.setLength(0);
        declareLabel(label);
        stringBuilder.append(indentString).append("LABEL(");
        appendLabel(label);
        stringBuilder.append(")\n");
        text.add(stringBuilder.toString());
    }

    @Override
    public void visitLdcInsn(final Object value) {
        stringBuilder.setLength(0);
        stringBuilder.append(indentString).append("LDC(");
        appendConstant(value);
        stringBuilder.append(")\n");
        text.add(stringBuilder.toString());
    }

    @Override
    public void visitIincInsn(final int varIndex, final int increment) {
        stringBuilder.setLength(0);
        stringBuilder.append(indentString)
                .append("IINC(")
                .append(varIndex)
                .append(", ")
                .append(increment)
                .append(")\n");
        text.add(stringBuilder.toString());
    }

    @Override
    public void visitIntInsn(int opcode, int operand) {
        stringBuilder.setLength(0);
        stringBuilder.append(indentString)
                .append(OPCODES[opcode])
                .append("(");
        appendConstant(operand);
        stringBuilder.append(")\n");
        text.add(stringBuilder.toString());
    }

    @Override
    public void visitTableSwitchInsn(
            final int min,
            final int max,
            final Label dflt,
            final Label... labels
    ) {
        stringBuilder.setLength(0);
        for (Label label : labels) {
            declareLabel(label);
        }
        declareLabel(dflt);

        stringBuilder.append(indentString)
                .append("+TableSwitchInsnNode(")
                .append(min)
                .append(", ")
                .append(max)
                .append(", ");
        appendLabel(dflt);
        stringBuilder.append(", ");
        for (int i = 0; i < labels.length; ++i) {
            stringBuilder.append(i == 0 ? " " : ", ");
            appendLabel(labels[i]);
        }
        stringBuilder.append(")");
        text.add(stringBuilder.toString());
    }

    @Override
    public void visitLookupSwitchInsn(final Label dflt, final int[] keys, final Label[] labels) {
        stringBuilder.setLength(0);
        for (Label label : labels) {
            declareLabel(label);
        }
        declareLabel(dflt);

        stringBuilder.append(indentString).append("LOOKUPSWITCH(");
        appendLabel(dflt);
        stringBuilder.append(".node, intArrayOf(");
        for (int i = 0; i < keys.length; ++i) {
            stringBuilder.append(i == 0 ? "" : ", ").append(keys[i]);
        }
        stringBuilder.append("), arrayOf(");
        for (int i = 0; i < labels.length; ++i) {
            stringBuilder.append(i == 0 ? "" : ", ");
            appendLabel(labels[i]);
            stringBuilder.append(".node");
        }
        stringBuilder.append("))\n");
        text.add(stringBuilder.toString());
    }

    @Override
    public void visitMultiANewArrayInsn(final String descriptor, final int numDimensions) {
        stringBuilder.setLength(0);
        stringBuilder.append(indentString).append("ANEWARRAY(");
        appendConstant(descriptor);
        stringBuilder.append(", ").append(numDimensions).append(")\n");
        text.add(stringBuilder.toString());
    }

    @Override
    public void visitTryCatchBlock(
            final Label start,
            final Label end,
            final Label handler,
            final String type
    ) {
        stringBuilder.setLength(0);
        declareLabel(start);
        declareLabel(end);
        declareLabel(handler);
        stringBuilder.append(indentString).append("TRYCATCH(");
        appendLabel(start);
        stringBuilder.append(", ");
        appendLabel(end);
        stringBuilder.append(", ");
        appendLabel(handler);
        stringBuilder.append(", ");
        if (type != null) appendConstant(type);
        else appendConstant("java/lang/Throwable");
        stringBuilder.append(")\n");
        text.add(stringBuilder.toString());
    }

    @Override
    public void visitLocalVariable(
            final String name,
            final String descriptor,
            final String signature,
            final Label start,
            final Label end,
            final int index
    ) {
        if (Recaf.getController().config().enhancement().gruntDSLIgnoreLocalVariable) return;
        stringBuilder.setLength(0);
        stringBuilder.append(indentString).append("LOCALVAR(");
        appendConstant(name);
        stringBuilder.append(", ");
        appendConstant(descriptor);
        stringBuilder.append(", ");
        appendConstant(signature);
        stringBuilder.append(", ");
        appendLabel(start);
        stringBuilder.append(", ");
        appendLabel(end);
        stringBuilder.append(", ").append(index).append(")\n");
        text.add(stringBuilder.toString());
    }

    @Override
    protected void declareLabel(final Label label) {
        if (labelNames == null) {
            labelNames = new HashMap<>();
        }
        String labelName = labelNames.get(label);
        if (labelName == null) {
            labelName = "label" + labelNames.size();
            labelNames.put(label, labelName);
//            StringBuilder sb = new StringBuilder();
//            sb.append("\t".repeat(indentLevel - 1)).append("val ").append(labelName).append(" = Label()\n");
//            text.add(0, sb.toString());
        }
    }

    @Override
    protected void appendLabel(final Label label) {
        stringBuilder.append("L[\"");
        stringBuilder.append(labelNames.get(label));
        stringBuilder.append("\"]");
    }

    @Override
    public void visitLineNumber(final int line, final Label start) {
        if (Recaf.getController().config().enhancement().gruntDSLIgnoreLines) return;
        stringBuilder.setLength(0);
        stringBuilder.append(indentString).append("LINE(").append(line).append(", ");
        appendLabel(start);
        stringBuilder.append(")\n");
        text.add(stringBuilder.toString());
    }

    @Override
    public void visitInsn(int opcode) {
        stringBuilder.setLength(0);
        stringBuilder.append(indentString).append(OPCODES[opcode]).append("\n");
        text.add(stringBuilder.toString());
    }

    @Override
    public void visitMaxs(int maxStack, int maxLocals) {
        if (Recaf.getController().config().enhancement().gruntDSLIgnoreMaxs) return;
        stringBuilder.setLength(0);
        stringBuilder.append(indentString).append("MAXS(").append(maxStack).append(", ").append(maxLocals).append(")\n");
        text.add(stringBuilder.toString());
    }

    @Override
    public void visitCode() {
        stringBuilder.setLength(0);
        stringBuilder.append(indentString).append("INSTRUCTIONS {\n");
        indentLevel += 1;
        indentString = "\t".repeat(indentLevel);
        text.add(stringBuilder.toString());
    }

    @Override
    public void visitMethodEnd() {
        stringBuilder.setLength(0);
        indentLevel -= 1;
        indentString = "\t".repeat(indentLevel);
        stringBuilder.append(indentString).append("}\n");
//        if (isVisitingClass) {
//            stringBuilder.append(indentString).append("+method").append(methodIndex).append("\n");
//        }
        text.add(stringBuilder.toString());
    }

    @Override
    public void visitClassEnd() {
        stringBuilder.setLength(0);
        if (indentLevel > 0) {
            indentLevel -= 1;
            indentString = "\t".repeat(indentLevel);
        }
        stringBuilder.append(indentString).append("}\n");
        text.add(stringBuilder.toString());
    }

    private void appendAccessFlags(final int accessFlags) {
        boolean isEmpty = true;
        if ((accessFlags & Opcodes.ACC_PUBLIC) != 0) {
            stringBuilder.append("PUBLIC");
            isEmpty = false;
        }
        if ((accessFlags & Opcodes.ACC_PRIVATE) != 0) {
            stringBuilder.append("PRIVATE");
            isEmpty = false;
        }
        if ((accessFlags & Opcodes.ACC_PROTECTED) != 0) {
            stringBuilder.append("PROTECTED");
            isEmpty = false;
        }
        if ((accessFlags & Opcodes.ACC_FINAL) != 0) {
            if (!isEmpty) {
                stringBuilder.append(" + ");
            }
            stringBuilder.append("FINAL");
            isEmpty = false;
        }
        if ((accessFlags & Opcodes.ACC_STATIC) != 0) {
            if (!isEmpty) {
                stringBuilder.append(" + ");
            }
            stringBuilder.append("STATIC");
            isEmpty = false;
        }
        if ((accessFlags & (Opcodes.ACC_SYNCHRONIZED | Opcodes.ACC_SUPER | Opcodes.ACC_TRANSITIVE))
                != 0) {
            if (!isEmpty) {
                stringBuilder.append(" + ");
            }
            if ((accessFlags & ACCESS_CLASS) == 0) {
                if ((accessFlags & ACCESS_MODULE) == 0) {
                    stringBuilder.append("SYNCHRONIZED");
                } else {
                    stringBuilder.append("TRANSITIVE");
                }
            } else {
                stringBuilder.append("SUPER");
            }
            isEmpty = false;
        }
        if ((accessFlags & (Opcodes.ACC_VOLATILE | Opcodes.ACC_BRIDGE | Opcodes.ACC_STATIC_PHASE))
                != 0) {
            if (!isEmpty) {
                stringBuilder.append(" + ");
            }
            if ((accessFlags & ACCESS_FIELD) == 0) {
                if ((accessFlags & ACCESS_MODULE) == 0) {
                    stringBuilder.append("BRIDGE");
                } else {
                    stringBuilder.append("STATIC_PHASE");
                }
            } else {
                stringBuilder.append("VOLATILE");
            }
            isEmpty = false;
        }
        if ((accessFlags & Opcodes.ACC_VARARGS) != 0
                && (accessFlags & (ACCESS_CLASS | ACCESS_FIELD)) == 0) {
            if (!isEmpty) {
                stringBuilder.append(" + ");
            }
            stringBuilder.append("VARARGS");
            isEmpty = false;
        }
        if ((accessFlags & Opcodes.ACC_TRANSIENT) != 0 && (accessFlags & ACCESS_FIELD) != 0) {
            if (!isEmpty) {
                stringBuilder.append(" + ");
            }
            stringBuilder.append("TRANSIENT");
            isEmpty = false;
        }
        if ((accessFlags & Opcodes.ACC_NATIVE) != 0
                && (accessFlags & (ACCESS_CLASS | ACCESS_FIELD)) == 0) {
            if (!isEmpty) {
                stringBuilder.append(" + ");
            }
            stringBuilder.append("NATIVE");
            isEmpty = false;
        }
        if ((accessFlags & Opcodes.ACC_ENUM) != 0
                && (accessFlags & (ACCESS_CLASS | ACCESS_FIELD | ACCESS_INNER)) != 0) {
            if (!isEmpty) {
                stringBuilder.append(" + ");
            }
            stringBuilder.append("ENUM");
            isEmpty = false;
        }
        if ((accessFlags & Opcodes.ACC_ANNOTATION) != 0
                && (accessFlags & (ACCESS_CLASS | ACCESS_INNER)) != 0) {
            if (!isEmpty) {
                stringBuilder.append(" + ");
            }
            stringBuilder.append("ANNOTATION");
            isEmpty = false;
        }
        if ((accessFlags & Opcodes.ACC_ABSTRACT) != 0) {
            if (!isEmpty) {
                stringBuilder.append(" + ");
            }
            stringBuilder.append("ABSTRACT");
            isEmpty = false;
        }
        if ((accessFlags & Opcodes.ACC_INTERFACE) != 0) {
            if (!isEmpty) {
                stringBuilder.append(" + ");
            }
            stringBuilder.append("INTERFACE");
            isEmpty = false;
        }
        if ((accessFlags & Opcodes.ACC_STRICT) != 0) {
            if (!isEmpty) {
                stringBuilder.append(" + ");
            }
            stringBuilder.append("STRICT");
            isEmpty = false;
        }
        if ((accessFlags & Opcodes.ACC_SYNTHETIC) != 0) {
            if (!isEmpty) {
                stringBuilder.append(" + ");
            }
            stringBuilder.append("SYNTHETIC");
            isEmpty = false;
        }
        if ((accessFlags & Opcodes.ACC_DEPRECATED) != 0) {
            if (!isEmpty) {
                stringBuilder.append(" + ");
            }
            stringBuilder.append("DEPRECATED");
            isEmpty = false;
        }
        if ((accessFlags & Opcodes.ACC_RECORD) != 0) {
            if (!isEmpty) {
                stringBuilder.append(" + ");
            }
            stringBuilder.append("RECORD");
            isEmpty = false;
        }
        if ((accessFlags & (Opcodes.ACC_MANDATED | Opcodes.ACC_MODULE)) != 0) {
            if (!isEmpty) {
                stringBuilder.append(" + ");
            }
            stringBuilder.append("MODULE");
            isEmpty = false;
        }
        if (isEmpty) {
            stringBuilder.append('0');
        }
    }
}
