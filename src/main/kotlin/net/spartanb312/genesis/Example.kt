package net.spartanb312.genesis

import net.spartanb312.genesis.extensions.*
import net.spartanb312.genesis.extensions.insn.*
import org.objectweb.asm.Label
import org.objectweb.asm.tree.ClassNode

fun main() {
    val myClass = clazz(
        PUBLIC + FINAL,
        "Main",
    ) {
        +clinit {
            INSTRUCTIONS {
                GETSTATIC("java/lang/System", "out", "Ljava/io/PrintStream;")
                LDC("Hello world!")
                INVOKEVIRTUAL("java/io/PrintStream", "println", "(Ljava/lang/String;)V")
                RETURN
            }

            +instructions {

            }

            +instructions {

            }

            MAXS(2, 0)
        }
        CLINIT(2, 0) {
            GETSTATIC("java/lang/System", "out", "Ljava/io/PrintStream;")
            LDC("Hello world!")
            INVOKEVIRTUAL("java/io/PrintStream", "println", "(Ljava/lang/String;)V")
            RETURN
        }
    }
    ClassNode().modify {
        +field(PRIVATE + STATIC, "isPassed", "Z", null, false)
        +field(PRIVATE + STATIC, "watermark", "I", null, "protected by MingHui Shield™")
        +method(
            PRIVATE + STATIC,
            "check",
            "(Ljava/lang/String;)Z"
        ) {
            INSTRUCTIONS {
                val label1 = Label()
                INT(114514)
                INT(1919810)
                IXOR
                INT(69420)
                IF_ICMPEQ(label1)
                ICONST_0
                IRETURN
                LABEL(label1)
                ICONST_1
                IRETURN
            }
        }
    }

    val `dev_luminous_mod_Mod` = clazz(
        access = PUBLIC + SYNCHRONIZED,
        name = "dev/luminous/mod/Mod",
        superName = "java/lang/Object",
        interfaces = listOf("dev/luminous/api/utils/Wrapper"),
        signature = null,
        version = Java17
    ) {
        val field0 = field(access = PRIVATE + FINAL, name = "name", desc = "Ljava/lang/String;", signature = null, value = null) {
        }
        +field0
        val method0 = method(access = PUBLIC, name = "<init>", desc = "(Ljava/lang/String;)V", signature = null, exceptions = null) {
            val label3 = Label()
            val label2 = Label()
            val label1 = Label()
            val label0 = Label()
            INSTRUCTIONS {
                LABEL(label0)
                ALOAD(0)
                INVOKESPECIAL("java/lang/Object", "<init>", "()V", false)
                LABEL(label1)
                ALOAD(0)
                ALOAD(1)
                PUTFIELD("dev/luminous/mod/Mod", "name", "Ljava/lang/String;")
                LABEL(label2)
                RETURN
                LABEL(label3)
                LOCALVAR("this", "Ldev/luminous/mod/Mod;", null, label0, label3, 0)
                LOCALVAR("name", "Ljava/lang/String;", null, label0, label3, 1)
                MAXS(2, 2)
            }
        }
        +method0
        val method1 = method(access = PUBLIC, name = "getName", desc = "()Ljava/lang/String;", signature = null, exceptions = null) {
            val label1 = Label()
            val label0 = Label()
            INSTRUCTIONS {
                LABEL(label0)
                ALOAD(0)
                GETFIELD("dev/luminous/mod/Mod", "name", "Ljava/lang/String;")
                ARETURN
                LABEL(label1)
                LOCALVAR("this", "Ldev/luminous/mod/Mod;", null, label0, label1, 0)
                MAXS(1, 1)
            }
        }
        +method1
    }

}