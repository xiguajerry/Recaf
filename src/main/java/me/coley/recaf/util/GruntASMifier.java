package me.coley.recaf.util;

import org.objectweb.asm.*;
import org.objectweb.asm.tree.MethodNode;
import org.objectweb.asm.util.ASMifier;
import org.objectweb.asm.util.TraceMethodVisitor;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import static org.objectweb.asm.Opcodes.GETSTATIC;

public class GruntASMifier extends ASMifier {
    /** A pseudo access flag used to distinguish class access flags. */
    private static final int ACCESS_CLASS = 0x40000;

    /** A pseudo access flag used to distinguish field access flags. */
    private static final int ACCESS_FIELD = 0x80000;

    /** A pseudo access flag used to distinguish inner class flags. */
    private static final int ACCESS_INNER = 0x100000;

    /** A pseudo access flag used to distinguish module requires / exports flags. */
    private static final int ACCESS_MODULE = 0x200000;

    private static final List<String> FRAME_TYPES =
            Collections.unmodifiableList(
                    Arrays.asList(
                            "Opcodes.TOP",
                            "Opcodes.INTEGER",
                            "Opcodes.FLOAT",
                            "Opcodes.DOUBLE",
                            "Opcodes.LONG",
                            "Opcodes.NULL",
                            "Opcodes.UNINITIALIZED_THIS"));

    public GruntASMifier(int api, String visitorVariableName, int annotationVisitorId) {
        super(api, visitorVariableName, annotationVisitorId);
    }

    public GruntASMifier() {
        this(/* latest api = */ Opcodes.ASM9, "classWriter", 0);
    }

    private static final String COMMA = "\", \"";

    @Override
    public ASMifier visitMethod(
            final int access,
            final String name,
            final String descriptor,
            final String signature,
            final String[] exceptions) {
        stringBuilder.setLength(0);
        stringBuilder.append("val method = method(modifier = ");
        appendAccessFlags(access);
        stringBuilder.append(", name = ");
        appendConstant(name);
        stringBuilder.append(", desc = ");
        appendConstant(descriptor);
        stringBuilder.append(", signature = ");
        appendConstant(signature);
        stringBuilder.append(", ");
        if (exceptions != null && exceptions.length > 0) {
            stringBuilder.append("arrayOf(");
            for (int i = 0; i < exceptions.length; ++i) {
                stringBuilder.append(i == 0 ? " " : ", ");
                appendConstant(exceptions[i]);
            }
            stringBuilder.append(")");
        } else {
            stringBuilder.append("null");
        }
        stringBuilder.append(") { \n");
        text.add(stringBuilder.toString());
        ASMifier asmifier = createASMifier("methodVisitor", 0);
//        methodNode.accept(new TraceMethodVisitor(null, asmifier));
        text.add(asmifier.getText());
        text.add("}\n");
        return asmifier;
    }

    @Override
    protected GruntASMifier createASMifier(
            final String visitorVariableName, final int annotationVisitorId) {
        return new GruntASMifier(api, visitorVariableName, annotationVisitorId);
    }

    @Override
    protected void appendConstant(Object value) {
        if (value == null) {
            stringBuilder.append("null");
        } else if (value instanceof String) {
            appendString(stringBuilder, (String) value);
        } else if (value instanceof Type) {
            stringBuilder.append("Type.getType(\"");
            stringBuilder.append(((Type) value).getDescriptor());
            stringBuilder.append("\")");
        } else if (value instanceof Handle) {
            stringBuilder.append("Handle(");
            Handle handle = (Handle) value;
            stringBuilder.append("Opcodes.").append(HANDLE_TAG[handle.getTag()]).append(", \"");
            stringBuilder.append(handle.getOwner()).append(COMMA);
            stringBuilder.append(handle.getName()).append(COMMA);
            stringBuilder.append(handle.getDesc()).append("\", ");
            stringBuilder.append(handle.isInterface()).append(')');
        } else if (value instanceof ConstantDynamic) {
            stringBuilder.append("ConstantDynamic(\"");
            ConstantDynamic constantDynamic = (ConstantDynamic) value;
            stringBuilder.append(constantDynamic.getName()).append(COMMA);
            stringBuilder.append(constantDynamic.getDescriptor()).append("\", ");
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
            stringBuilder.append("new Byte((byte)").append(value).append(')');
        } else if (value instanceof Boolean) {
            stringBuilder.append(((Boolean) value).booleanValue() ? "true" : "false");
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
        } else if (value instanceof byte[]) {
            byte[] byteArray = (byte[]) value;
            stringBuilder.append("byteArrayOf(");
            for (int i = 0; i < byteArray.length; i++) {
                stringBuilder.append(i == 0 ? "" : ",").append(byteArray[i]);
            }
            stringBuilder.append(')');
        } else if (value instanceof boolean[]) {
            boolean[] booleanArray = (boolean[]) value;
            stringBuilder.append("booleanArrayOf(");
            for (int i = 0; i < booleanArray.length; i++) {
                stringBuilder.append(i == 0 ? "" : ",").append(booleanArray[i]);
            }
            stringBuilder.append(')');
        } else if (value instanceof short[]) {
            short[] shortArray = (short[]) value;
            stringBuilder.append("shortArrayOf(");
            for (int i = 0; i < shortArray.length; i++) {
                stringBuilder.append(i == 0 ? "" : ",").append(shortArray[i]).append(".toShort()");
            }
            stringBuilder.append(')');
        } else if (value instanceof char[]) {
            char[] charArray = (char[]) value;
            stringBuilder.append("charArrayOf(");
            for (int i = 0; i < charArray.length; i++) {
                stringBuilder.append(i == 0 ? "" : ",").append((int) charArray[i]).append(".toChar()");
            }
            stringBuilder.append(')');
        } else if (value instanceof int[]) {
            int[] intArray = (int[]) value;
            stringBuilder.append("intArrayOf(");
            for (int i = 0; i < intArray.length; i++) {
                stringBuilder.append(i == 0 ? "" : ",").append(intArray[i]);
            }
            stringBuilder.append(')');
        } else if (value instanceof long[]) {
            long[] longArray = (long[]) value;
            stringBuilder.append("longArrayOf(");
            for (int i = 0; i < longArray.length; i++) {
                stringBuilder.append(i == 0 ? "" : ",").append(longArray[i]).append('L');
            }
            stringBuilder.append(')');
        } else if (value instanceof float[]) {
            float[] floatArray = (float[]) value;
            stringBuilder.append("floatArrayOf(");
            for (int i = 0; i < floatArray.length; i++) {
                stringBuilder.append(i == 0 ? "" : ",").append(floatArray[i]).append('f');
            }
            stringBuilder.append(')');
        } else if (value instanceof double[]) {
            double[] doubleArray = (double[]) value;
            stringBuilder.append("doubleArrayOf(");
            for (int i = 0; i < doubleArray.length; i++) {
                stringBuilder.append(i == 0 ? "" : ",").append(doubleArray[i]).append('d');
            }
            stringBuilder.append(')');
        }
    }

    /**
     * Calls {@link #declareLabel} for each label in the given stack map frame types.
     *
     * @param numTypes the number of stack map frame types in 'frameTypes'.
     * @param frameTypes an array of stack map frame types, in the format described in {@link
     *     org.objectweb.asm.MethodVisitor#visitFrame}.
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
     *     org.objectweb.asm.MethodVisitor#visitFrame}.
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
    public void visitFrame(
            final int type,
            final int numLocal,
            final Object[] local,
            final int numStack,
            final Object[] stack) {
        stringBuilder.setLength(0);
        switch (type) {
            case Opcodes.F_NEW:
            case Opcodes.F_FULL:
                declareFrameTypes(numLocal, local);
                declareFrameTypes(numStack, stack);
                if (type == Opcodes.F_NEW) {
                    stringBuilder.append("\t\tFRAME(Opcodes.F_NEW, ");
                } else {
                    stringBuilder.append("\t\tFRAME(Opcodes.F_FULL, ");
                }
                stringBuilder.append(numLocal).append(", arrayOf(");
                appendFrameTypes(numLocal, local);
                stringBuilder.append("), ").append(numStack).append(", arrayOf(");
                appendFrameTypes(numStack, stack);
                stringBuilder.append(')');
                break;
            case Opcodes.F_APPEND:
                declareFrameTypes(numLocal, local);
                stringBuilder
                        .append("\t\tFRAME(Opcodes.F_APPEND, ")
                        .append(numLocal)
                        .append(", arrayOf(");
                appendFrameTypes(numLocal, local);
                stringBuilder.append("), 0, null");
                break;
            case Opcodes.F_CHOP:
                stringBuilder
                        .append("\t\tFRAME(Opcodes.F_CHOP, ")
                        .append(numLocal)
                        .append(", null, 0, null");
                break;
            case Opcodes.F_SAME:
                stringBuilder.append("\t\tFRAME(Opcodes.F_SAME, 0, null, 0, null");
                break;
            case Opcodes.F_SAME1:
                declareFrameTypes(1, stack);
                stringBuilder
                        .append("\t\tFRAME(Opcodes.F_SAME1, 0, null, 1, arrayOf(");
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
        stringBuilder.append("\t\t").append(OPCODES[opcode]).append("(").append(varIndex).append(")\n");
        text.add(stringBuilder.toString());
    }

    @Override
    public void visitTypeInsn(int opcode, String type) {
        stringBuilder.setLength(0);
        stringBuilder.append("\t\t").append(OPCODES[opcode]).append("(");
        appendString(stringBuilder, type);
        stringBuilder.append(")\n");
        text.add(stringBuilder.toString());
    }

    @Override
    public void visitFieldInsn(int opcode, String owner, String name, String descriptor) {
        stringBuilder.setLength(0);
        stringBuilder.append("\t\t").append(OPCODES[opcode]).append("(");
        appendConstant(owner);
        stringBuilder.append(", ");
        appendConstant(name);
        stringBuilder.append(", ");
        appendConstant(descriptor);
        stringBuilder.append(")\n");
        text.add(stringBuilder.toString());
    }

    @Override
    public void visitMethodInsn(int opcode, String owner, String name, String descriptor, boolean isInterface) {
        stringBuilder.setLength(0);
        stringBuilder
                .append("\t\t")
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
            final Object... bootstrapMethodArguments) {
        stringBuilder.setLength(0);
        stringBuilder.append("\t\t").append("INVOKEDYNAMIC(");
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
        stringBuilder.append("\t\t").append(OPCODES[opcode]).append("(");
        appendLabel(label);
        stringBuilder.append(")\n");
        text.add(stringBuilder.toString());
    }

    @Override
    public void visitLabel(final Label label) {
        stringBuilder.setLength(0);
        declareLabel(label);
        stringBuilder.append("\t\tLABEL(");
        appendLabel(label);
        stringBuilder.append(")\n");
        text.add(stringBuilder.toString());
    }

    @Override
    public void visitLdcInsn(final Object value) {
        stringBuilder.setLength(0);
        stringBuilder.append("\t\t").append("LDC(");
        appendConstant(value);
        stringBuilder.append(")\n");
        text.add(stringBuilder.toString());
    }

    @Override
    public void visitIincInsn(final int varIndex, final int increment) {
        stringBuilder.setLength(0);
        stringBuilder
                .append("\t\tIINC(")
                .append(varIndex)
                .append(", ")
                .append(increment)
                .append(")\n");
        text.add(stringBuilder.toString());
    }

    @Override
    public void visitTableSwitchInsn(
            final int min, final int max, final Label dflt, final Label... labels) {
        stringBuilder.setLength(0);
        for (Label label : labels) {
            declareLabel(label);
        }
        declareLabel(dflt);

        stringBuilder
                .append("\t\t+TableSwitchInsnNode(")
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

        stringBuilder.append("\t\t+LookupSwitchInsnNode(");
        appendLabel(dflt);
        stringBuilder.append(", intArrayOf(");
        for (int i = 0; i < keys.length; ++i) {
            stringBuilder.append(i == 0 ? " " : ", ").append(keys[i]);
        }
        stringBuilder.append("), arrayof(");
        for (int i = 0; i < labels.length; ++i) {
            stringBuilder.append(i == 0 ? " " : ", ");
            appendLabel(labels[i]);
        }
        stringBuilder.append("))");
        text.add(stringBuilder.toString());
    }

    @Override
    public void visitMultiANewArrayInsn(final String descriptor, final int numDimensions) {
        stringBuilder.setLength(0);
        stringBuilder.append("\t\t+MultiANewArrayInsnNode(");
        appendConstant(descriptor);
        stringBuilder.append(", ").append(numDimensions).append(")\n");
        text.add(stringBuilder.toString());
    }

    @Override
    public void visitTryCatchBlock(
            final Label start, final Label end, final Label handler, final String type) {
        stringBuilder.setLength(0);
        declareLabel(start);
        declareLabel(end);
        declareLabel(handler);
        stringBuilder.append(name).append("\t\tthis@method.methodNode.visitTryCatchBlock(");
        appendLabel(start);
        stringBuilder.append(", ");
        appendLabel(end);
        stringBuilder.append(", ");
        appendLabel(handler);
        stringBuilder.append(", ");
        appendConstant(type);
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
            final int index) {
        stringBuilder.setLength(0);
        stringBuilder.append("\t\tthis@method.methodNode.visitLocalVariable(");
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

    protected void declareLabel(final Label label) {
        if (labelNames == null) {
            labelNames = new HashMap<>();
        }
        String labelName = labelNames.get(label);
        if (labelName == null) {
            labelName = "label" + labelNames.size();
            labelNames.put(label, labelName);
            StringBuilder sb = new StringBuilder();
            sb.append("\tval ").append(labelName).append(" = Label()\n");
            text.add(0, sb.toString());
        }
    }

    @Override
    public void visitLineNumber(final int line, final Label start) {
        stringBuilder.setLength(0);
        stringBuilder.append("\t\tLINE(").append(line).append(", ");
        appendLabel(start);
        stringBuilder.append(")\n");
        text.add(stringBuilder.toString());
    }

    @Override
    public void visitInsn(int opcode) {
        stringBuilder.setLength(0);
        stringBuilder.append("\t\t").append(OPCODES[opcode]).append("\n");
        text.add(stringBuilder.toString());
    }

    @Override
    public void visitMaxs(int maxStack, int maxLocals) {
        stringBuilder.setLength(0);
        stringBuilder.append("\tMaxs(").append(maxStack).append(", ").append(maxLocals).append(")\n");
        text.add(stringBuilder.toString());
    }

    @Override
    public void visitCode() {
        stringBuilder.setLength(0);
        stringBuilder.append("\tInsnList {\n");
        text.add(stringBuilder.toString());
    }

    @Override
    public void visitMethodEnd() {
        stringBuilder.setLength(0);
        stringBuilder.append("\t}\n");
        text.add(stringBuilder.toString());
    }

    private void appendAccessFlags(final int accessFlags) {
        boolean isEmpty = true;
        if ((accessFlags & Opcodes.ACC_PUBLIC) != 0) {
            stringBuilder.append("ACC_PUBLIC");
            isEmpty = false;
        }
        if ((accessFlags & Opcodes.ACC_PRIVATE) != 0) {
            stringBuilder.append("ACC_PRIVATE");
            isEmpty = false;
        }
        if ((accessFlags & Opcodes.ACC_PROTECTED) != 0) {
            stringBuilder.append("ACC_PROTECTED");
            isEmpty = false;
        }
        if ((accessFlags & Opcodes.ACC_FINAL) != 0) {
            if (!isEmpty) {
                stringBuilder.append(" or ");
            }
            stringBuilder.append("ACC_FINAL");
            isEmpty = false;
        }
        if ((accessFlags & Opcodes.ACC_STATIC) != 0) {
            if (!isEmpty) {
                stringBuilder.append(" or ");
            }
            stringBuilder.append("ACC_STATIC");
            isEmpty = false;
        }
        if ((accessFlags & (Opcodes.ACC_SYNCHRONIZED | Opcodes.ACC_SUPER | Opcodes.ACC_TRANSITIVE))
                != 0) {
            if (!isEmpty) {
                stringBuilder.append(" or ");
            }
            if ((accessFlags & ACCESS_CLASS) == 0) {
                if ((accessFlags & ACCESS_MODULE) == 0) {
                    stringBuilder.append("ACC_SYNCHRONIZED");
                } else {
                    stringBuilder.append("ACC_TRANSITIVE");
                }
            } else {
                stringBuilder.append("ACC_SUPER");
            }
            isEmpty = false;
        }
        if ((accessFlags & (Opcodes.ACC_VOLATILE | Opcodes.ACC_BRIDGE | Opcodes.ACC_STATIC_PHASE))
                != 0) {
            if (!isEmpty) {
                stringBuilder.append(" or ");
            }
            if ((accessFlags & ACCESS_FIELD) == 0) {
                if ((accessFlags & ACCESS_MODULE) == 0) {
                    stringBuilder.append("ACC_BRIDGE");
                } else {
                    stringBuilder.append("ACC_STATIC_PHASE");
                }
            } else {
                stringBuilder.append("ACC_VOLATILE");
            }
            isEmpty = false;
        }
        if ((accessFlags & Opcodes.ACC_VARARGS) != 0
                && (accessFlags & (ACCESS_CLASS | ACCESS_FIELD)) == 0) {
            if (!isEmpty) {
                stringBuilder.append(" or ");
            }
            stringBuilder.append("ACC_VARARGS");
            isEmpty = false;
        }
        if ((accessFlags & Opcodes.ACC_TRANSIENT) != 0 && (accessFlags & ACCESS_FIELD) != 0) {
            if (!isEmpty) {
                stringBuilder.append(" or ");
            }
            stringBuilder.append("ACC_TRANSIENT");
            isEmpty = false;
        }
        if ((accessFlags & Opcodes.ACC_NATIVE) != 0
                && (accessFlags & (ACCESS_CLASS | ACCESS_FIELD)) == 0) {
            if (!isEmpty) {
                stringBuilder.append(" or ");
            }
            stringBuilder.append("ACC_NATIVE");
            isEmpty = false;
        }
        if ((accessFlags & Opcodes.ACC_ENUM) != 0
                && (accessFlags & (ACCESS_CLASS | ACCESS_FIELD | ACCESS_INNER)) != 0) {
            if (!isEmpty) {
                stringBuilder.append(" or ");
            }
            stringBuilder.append("ACC_ENUM");
            isEmpty = false;
        }
        if ((accessFlags & Opcodes.ACC_ANNOTATION) != 0
                && (accessFlags & (ACCESS_CLASS | ACCESS_INNER)) != 0) {
            if (!isEmpty) {
                stringBuilder.append(" or ");
            }
            stringBuilder.append("ACC_ANNOTATION");
            isEmpty = false;
        }
        if ((accessFlags & Opcodes.ACC_ABSTRACT) != 0) {
            if (!isEmpty) {
                stringBuilder.append(" or ");
            }
            stringBuilder.append("ACC_ABSTRACT");
            isEmpty = false;
        }
        if ((accessFlags & Opcodes.ACC_INTERFACE) != 0) {
            if (!isEmpty) {
                stringBuilder.append(" or ");
            }
            stringBuilder.append("ACC_INTERFACE");
            isEmpty = false;
        }
        if ((accessFlags & Opcodes.ACC_STRICT) != 0) {
            if (!isEmpty) {
                stringBuilder.append(" or ");
            }
            stringBuilder.append("ACC_STRICT");
            isEmpty = false;
        }
        if ((accessFlags & Opcodes.ACC_SYNTHETIC) != 0) {
            if (!isEmpty) {
                stringBuilder.append(" or ");
            }
            stringBuilder.append("ACC_SYNTHETIC");
            isEmpty = false;
        }
        if ((accessFlags & Opcodes.ACC_DEPRECATED) != 0) {
            if (!isEmpty) {
                stringBuilder.append(" or ");
            }
            stringBuilder.append("ACC_DEPRECATED");
            isEmpty = false;
        }
        if ((accessFlags & Opcodes.ACC_RECORD) != 0) {
            if (!isEmpty) {
                stringBuilder.append(" or ");
            }
            stringBuilder.append("ACC_RECORD");
            isEmpty = false;
        }
        if ((accessFlags & (Opcodes.ACC_MANDATED | Opcodes.ACC_MODULE)) != 0) {
            if (!isEmpty) {
                stringBuilder.append(" or ");
            }
            stringBuilder.append("ACC_MODULE");
            isEmpty = false;
        }
        if (isEmpty) {
            stringBuilder.append('0');
        }
    }
}
