package me.coley.recaf.util.analyze;

import com.google.common.collect.Iterables;
import me.coley.analysis.SimAnalyzer;
import me.coley.analysis.SimInterpreter;
import me.coley.analysis.value.AbstractValue;
import me.coley.analysis.value.PrimitiveValue;
import me.coley.analysis.value.simulated.AbstractSimulatedValue;
import me.coley.recaf.parse.bytecode.MethodAnalyzer;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.*;
import org.objectweb.asm.tree.analysis.AnalyzerException;
import org.objectweb.asm.tree.analysis.Frame;
import software.coley.cafedude.tree.insn.VarInsn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class NumberSimulator {
    private final MethodNode methodNode;
    private final SimAnalyzer analyzer;
    private final Frame<AbstractValue>[] frames;

    public NumberSimulator(MethodNode methodNode, String ownerName) {
        this.methodNode = methodNode;
        this.analyzer = new MethodAnalyzer(new SimInterpreter());
        try {
            this.frames = analyzer.analyze(ownerName, methodNode);
        } catch (AnalyzerException e) {
            throw new RuntimeException(e);
        }
    }

    public void optimizeConstants() {
        InsnList insnList = methodNode.instructions;
        List<AbstractInsnNode> copiedInsnList = Arrays.stream(methodNode.instructions.toArray()).collect(Collectors.toList());
        for (int i = 0; i < copiedInsnList.size(); i++) {
            AbstractInsnNode insn = copiedInsnList.get(i);
            Frame<AbstractValue> frameValues = frames[i];
            if (frameValues == null || frameValues.getStackSize() == 0) continue;
            if (frameValues.getStack(frameValues.getStackSize() - 1) instanceof PrimitiveValue topValue) {
                if (insn instanceof VarInsnNode varInsn) {
                    LocalVariableNode localVar = methodNode.localVariables.get(varInsn.var);
                    switch (Type.getType(localVar.desc).getSort()) {
                        case Type.INT: {

                        }
                    }
                }
            }
        }
    }
}
