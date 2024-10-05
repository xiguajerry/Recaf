package net.spartanb312.genesis.extensions.insn

import net.spartanb312.genesis.InsnListBuilder
import net.spartanb312.genesis.extensions.node
import org.objectweb.asm.Label
import org.objectweb.asm.tree.LabelNode
import org.objectweb.asm.tree.LookupSwitchInsnNode
import org.objectweb.asm.tree.TableSwitchInsnNode

/**
 * Table switch insn node
 */
@JvmName("TABLESWITCH_LABEL")
fun InsnListBuilder.TABLESWITCH(min: Int, max: Int, def: Label, vararg labels: Label) =
    +TableSwitchInsnNode(min, max, def.node, *labels.map { it.node }.toTypedArray())

fun InsnListBuilder.TABLESWITCH(min: Int, max: Int, def: LabelNode, vararg labels: LabelNode) =
    +TableSwitchInsnNode(min, max, def, *labels)

/**
 * Lookup switch insn node
 */
@JvmName("LOOKUPSWITCH_LABEL")
fun InsnListBuilder.LOOKUPSWITCH(def: Label, keys: IntArray, labels: Array<Label>) =
    +LookupSwitchInsnNode(def.node, keys, labels.map { it.node }.toTypedArray())

fun InsnListBuilder.LOOKUPSWITCH(def: LabelNode, keys: IntArray, labels: Array<LabelNode>) =
    +LookupSwitchInsnNode(def, keys, labels)

@JvmName("LOOKUPSWITCH_LABEL")
fun InsnListBuilder.LOOKUPSWITCH(def: Label, vararg branches: Pair<Int, Label>) {
    val keys = IntArray(branches.size) { branches[it].first }
    val labels = Array(branches.size) { branches[it].second }
    +LookupSwitchInsnNode(def.node, keys, labels.map { it.node }.toTypedArray())
}

fun InsnListBuilder.LOOKUPSWITCH(def: Label, vararg branches: Pair<Int, LabelNode>) {
    val keys = IntArray(branches.size) { branches[it].first }
    val labels = Array(branches.size) { branches[it].second }
    +LookupSwitchInsnNode(def.node, keys, labels)
}