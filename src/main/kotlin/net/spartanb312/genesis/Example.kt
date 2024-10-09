package net.spartanb312.genesis

import net.spartanb312.genesis.extensions.*
import net.spartanb312.genesis.extensions.insn.*
import org.objectweb.asm.*

val `me_hextech_Nullpoint` = clazz(
    access = PUBLIC + FINAL + SYNCHRONIZED,
    name = "me/hextech/Nullpoint",
    superName = "java/lang/Object",
    interfaces = listOf("net/fabricmc/api/ModInitializer"),
    signature = null,
    version = Java17
) {
    val field0 = field(access = PUBLIC + STATIC, name = "thread", desc = "Ljava/lang/Thread;", signature = null, value = null) {
    }
    +field0
    val field1 = field(access = PUBLIC + FINAL + STATIC, name = "LOG_NAME", desc = "Ljava/lang/String;", signature = null, value = "HexTech") {
    }
    +field1
    val field2 = field(access = PUBLIC + FINAL + STATIC, name = "CHAT_NAME", desc = "Ljava/lang/String;", signature = null, value = "\u029C\u1D07\u04FC >") {
    }
    +field2
    val field3 = field(access = PUBLIC + FINAL + STATIC, name = "VERSION", desc = "Ljava/lang/String;", signature = null, value = "5") {
    }
    +field3
    val field4 = field(access = PUBLIC + STATIC, name = "PREFIX", desc = "Ljava/lang/String;", signature = null, value = null) {
    }
    +field4
    val field5 = field(access = PUBLIC + FINAL + STATIC, name = "EVENT_BUS", desc = "Lme/hextech/api/events/eventbus/EventBus;", signature = null, value = null) {
    }
    +field5
    val field6 = field(access = PUBLIC + STATIC, name = "hwid1", desc = "Ljava/lang/String;", signature = null, value = null) {
    }
    +field6
    val field7 = field(access = PUBLIC + STATIC, name = "hwid2", desc = "Ljava/lang/String;", signature = null, value = null) {
    }
    +field7
    val field8 = field(access = PUBLIC + STATIC, name = "token1", desc = "Ljava/lang/String;", signature = null, value = null) {
    }
    +field8
    val field9 = field(access = PUBLIC + STATIC, name = "token2", desc = "Ljava/lang/String;", signature = null, value = null) {
    }
    +field9
    val field10 = field(access = PUBLIC + STATIC, name = "name", desc = "Ljava/lang/String;", signature = null, value = null) {
    }
    +field10
    val field11 = field(access = PUBLIC + STATIC, name = "token3", desc = "Ljava/lang/String;", signature = null, value = null) {
    }
    +field11
    val field12 = field(access = PUBLIC + STATIC, name = "MODULE", desc = "Lme/hextech/api/managers/ModuleManager;", signature = null, value = null) {
    }
    +field12
    val field13 = field(access = PUBLIC + STATIC, name = "COMMAND", desc = "Lme/hextech/api/managers/CommandManager;", signature = null, value = null) {
    }
    +field13
    val field14 = field(access = PUBLIC + STATIC, name = "ALT", desc = "Lme/hextech/api/managers/AltManager;", signature = null, value = null) {
    }
    +field14
    val field15 = field(access = PUBLIC + STATIC, name = "GUI", desc = "Lme/hextech/api/managers/GuiManager;", signature = null, value = null) {
    }
    +field15
    val field16 = field(access = PUBLIC + STATIC, name = "CONFIG", desc = "Lme/hextech/api/managers/ConfigManager;", signature = null, value = null) {
    }
    +field16
    val field17 = field(access = PUBLIC + STATIC, name = "ROTATE", desc = "Lme/hextech/api/managers/RotateManager;", signature = null, value = null) {
    }
    +field17
    val field18 = field(access = PUBLIC + STATIC, name = "BREAK", desc = "Lme/hextech/api/managers/MineManager;", signature = null, value = null) {
    }
    +field18
    val field19 = field(access = PUBLIC + STATIC, name = "POP", desc = "Lme/hextech/api/managers/PopManager;", signature = null, value = null) {
    }
    +field19
    val field20 = field(access = PUBLIC + STATIC, name = "SPEED", desc = "Lme/hextech/api/managers/SpeedManager;", signature = null, value = null) {
    }
    +field20
    val field21 = field(access = PUBLIC + STATIC, name = "FRIEND", desc = "Lme/hextech/api/managers/FriendManager;", signature = null, value = null) {
    }
    +field21
    val field22 = field(access = PUBLIC + STATIC, name = "TIMER", desc = "Lme/hextech/api/managers/TimerManager;", signature = null, value = null) {
    }
    +field22
    val field23 = field(access = PUBLIC + STATIC, name = "SHADER", desc = "Lme/hextech/api/managers/ShaderManager;", signature = null, value = null) {
    }
    +field23
    val field24 = field(access = PUBLIC + STATIC, name = "FPS", desc = "Lme/hextech/api/managers/FPSManager;", signature = null, value = null) {
    }
    +field24
    val field25 = field(access = PUBLIC + STATIC, name = "SERVER", desc = "Lme/hextech/api/managers/ServerManager;", signature = null, value = null) {
    }
    +field25
    val field26 = field(access = PUBLIC + STATIC, name = "THREAD", desc = "Lme/hextech/api/managers/ThreadManager;", signature = null, value = null) {
    }
    +field26
    val method0 = method(access = PUBLIC, name = "<init>", desc = "()V", signature = null, exceptions = null) {
        val label1 = Label()
        val label0 = Label()
        INSTRUCTIONS {
            LABEL(label0)
            ALOAD(0)
            INVOKESPECIAL("java/lang/Object", "<init>", "()V", false)
            RETURN
            LABEL(label1)
        }
    }
    +method0
    val method1 = method(access = PUBLIC, name = "a", desc = "()V", signature = null, exceptions = null) {
        val label14 = Label()
        val label13 = Label()
        val label12 = Label()
        val label11 = Label()
        val label10 = Label()
        val label9 = Label()
        val label8 = Label()
        val label7 = Label()
        val label6 = Label()
        val label5 = Label()
        val label4 = Label()
        val label3 = Label()
        val label2 = Label()
        val label1 = Label()
        val label0 = Label()
        INSTRUCTIONS {
            TRYCATCH(label0, label1, label2, "java/lang/Exception")
            TRYCATCH(label3, label4, label5, "java/lang/Throwable")
            LABEL(label0)
            GETSTATIC("me/hextech/Nullpoint", "name", "Ljava/lang/String;")
            GETSTATIC("me/hextech/Nullpoint", "name", "Ljava/lang/String;")
            INVOKEVIRTUAL("java/lang/String", "length", "()I", false)
            ICONST_1
            ISUB
            INVOKEVIRTUAL("java/lang/String", "substring", "(I)Ljava/lang/String;", false)
            INVOKESTATIC("java/lang/Integer", "parseInt", "(Ljava/lang/String;)I", false)
            ISTORE(1)
            LABEL(label6)
            GETSTATIC("me/hextech/Nullpoint", "name", "Ljava/lang/String;")
            ICONST_0
            GETSTATIC("me/hextech/Nullpoint", "name", "Ljava/lang/String;")
            INVOKEVIRTUAL("java/lang/String", "length", "()I", false)
            ICONST_1
            ISUB
            INVOKEVIRTUAL("java/lang/String", "substring", "(II)Ljava/lang/String;", false)
            ASTORE(2)
            LABEL(label7)
            ICONST_4
            ANEWARRAY("java/lang/String")
            DUP
            ICONST_0
            LDC("GUEST")
            AASTORE
            DUP
            ICONST_1
            LDC("USER")
            AASTORE
            DUP
            ICONST_2
            LDC("ADMIN")
            AASTORE
            DUP
            ICONST_3
            LDC("ROOT")
            AASTORE
            ASTORE(3)
            LABEL(label8)
            ALOAD(2)
            ALOAD(3)
            ILOAD(1)
            AALOAD
            INVOKEDYNAMIC("makeConcatWithConstants", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", Handle(Opcodes.H_INVOKESTATIC, "java/lang/invoke/StringConcatFactory", "makeConcatWithConstants", "(Ljava/lang/invoke/MethodHandles\$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;", false), "\u0001\u0001zjmisgay")
            LDC("zjmisgayzjmisgayzjmisgayzjmisgayzjmisgayzjmisgay")
            INVOKESTATIC("me/hextech/Nullpoint", "Encrypt", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", false)
            INVOKESTATIC("java/util/Objects", "requireNonNull", "(Ljava/lang/Object;)Ljava/lang/Object;", false)
            CHECKCAST("java/lang/String")
            GETSTATIC("me/hextech/Nullpoint", "token1", "Ljava/lang/String;")
            INVOKEVIRTUAL("java/lang/String", "equals", "(Ljava/lang/Object;)Z", false)
            LDC("")
            INVOKESTATIC("org/apache/http/util/Asserts", "check", "(ZLjava/lang/String;)V", false)
            LABEL(label1)
            GOTO(label9)
            LABEL(label2)
            FRAME(Opcodes.F_SAME1, 0, null, 1, arrayOf("java/lang/Exception"))
            ASTORE(1)
            LABEL(label3)
            INVOKESTATIC("java/lang/invoke/MethodHandles", "lookup", "()Ljava/lang/invoke/MethodHandles\$Lookup;", false)
            LDC("com.sun.jna.Native")
            INVOKESTATIC("java/lang/Class", "forName", "(Ljava/lang/String;)Ljava/lang/Class;", false)
            LDC("ffi_call")
            GETSTATIC("java/lang/Void", "TYPE", "Ljava/lang/Class;")
            GETSTATIC("java/lang/Long", "TYPE", "Ljava/lang/Class;")
            ICONST_3
            ANEWARRAY("java/lang/Class")
            DUP
            ICONST_0
            GETSTATIC("java/lang/Long", "TYPE", "Ljava/lang/Class;")
            AASTORE
            DUP
            ICONST_1
            GETSTATIC("java/lang/Long", "TYPE", "Ljava/lang/Class;")
            AASTORE
            DUP
            ICONST_2
            GETSTATIC("java/lang/Long", "TYPE", "Ljava/lang/Class;")
            AASTORE
            LABEL(label10)
            INVOKESTATIC("java/lang/invoke/MethodType", "methodType", "(Ljava/lang/Class;Ljava/lang/Class;[Ljava/lang/Class;)Ljava/lang/invoke/MethodType;", false)
            LABEL(label11)
            INVOKEVIRTUAL("java/lang/invoke/MethodHandles\$Lookup", "findStatic", "(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/MethodHandle;", false)
            ICONST_0
            ICONST_0
            ICONST_0
            ICONST_0
            LABEL(label12)
            INVOKEVIRTUAL("java/lang/invoke/MethodHandle", "invoke", "(IIII)V", false)
            LABEL(label4)
            GOTO(label9)
            LABEL(label5)
            FRAME(Opcodes.F_FULL, 2, arrayOf("me/hextech/Nullpoint", "java/lang/Exception"), 1, arrayOf("java/lang/Throwable"))
            ASTORE(2)
            LABEL(label13)
            NEW("java/lang/RuntimeException")
            DUP
            ALOAD(2)
            INVOKESPECIAL("java/lang/RuntimeException", "<init>", "(Ljava/lang/Throwable;)V", false)
            ATHROW
            LABEL(label9)
            FRAME(Opcodes.F_CHOP, 1, null, 0, null)
            RETURN
            LABEL(label14)
        }
    }
    +method1
    val method2 = method(access = PUBLIC, name = "onInitialize", desc = "()V", signature = null, exceptions = null) {
        val label7 = Label()
        val label6 = Label()
        val label5 = Label()
        val label4 = Label()
        val label3 = Label()
        val label2 = Label()
        val label1 = Label()
        val label0 = Label()
        INSTRUCTIONS {
            TRYCATCH(label0, label1, label2, "java/lang/Throwable")
            LABEL(label0)
            INVOKESTATIC("me/hextech/Nullpoint", "load", "()V", false)
            LABEL(label1)
            GOTO(label3)
            LABEL(label2)
            FRAME(Opcodes.F_SAME1, 0, null, 1, arrayOf("java/lang/Throwable"))
            ASTORE(1)
            LABEL(label4)
            NEW("java/lang/RuntimeException")
            DUP
            ALOAD(1)
            INVOKESPECIAL("java/lang/RuntimeException", "<init>", "(Ljava/lang/Throwable;)V", false)
            ATHROW
            LABEL(label3)
            FRAME(Opcodes.F_SAME, 0, null, 0, null)
            NEW("java/lang/Thread")
            DUP
            INVOKEDYNAMIC("run", "()Ljava/lang/Runnable;", Handle(Opcodes.H_INVOKESTATIC, "java/lang/invoke/LambdaMetafactory", "metafactory", "(Ljava/lang/invoke/MethodHandles\$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;", false), Type.getType("()V"), Handle(Opcodes.H_INVOKESTATIC, "me/hextech/Nullpoint", "lambda\$onInitialize\$0", "()V", false), Type.getType("()V"))
            INVOKESPECIAL("java/lang/Thread", "<init>", "(Ljava/lang/Runnable;)V", false)
            PUTSTATIC("me/hextech/Nullpoint", "thread", "Ljava/lang/Thread;")
            LABEL(label5)
            GETSTATIC("me/hextech/Nullpoint", "thread", "Ljava/lang/Thread;")
            INVOKEVIRTUAL("java/lang/Thread", "start", "()V", false)
            LABEL(label6)
            RETURN
            LABEL(label7)
        }
    }
    +method2
    val method3 = method(access = PUBLIC + STATIC, name = "update", desc = "()V", signature = null, exceptions = null) {
        val label6 = Label()
        val label5 = Label()
        val label4 = Label()
        val label3 = Label()
        val label2 = Label()
        val label1 = Label()
        val label0 = Label()
        INSTRUCTIONS {
            LABEL(label0)
            GETSTATIC("me/hextech/Nullpoint", "thread", "Ljava/lang/Thread;")
            IFNULL(label1)
            GETSTATIC("me/hextech/Nullpoint", "thread", "Ljava/lang/Thread;")
            INVOKEVIRTUAL("java/lang/Thread", "isAlive", "()Z", false)
            IFEQ(label1)
            GETSTATIC("me/hextech/Nullpoint", "thread", "Ljava/lang/Thread;")
            INVOKEVIRTUAL("java/lang/Thread", "isInterrupted", "()Z", false)
            IFEQ(label2)
            LABEL(label1)
            FRAME(Opcodes.F_SAME, 0, null, 0, null)
            NEW("java/lang/Thread")
            DUP
            INVOKEDYNAMIC("run", "()Ljava/lang/Runnable;", Handle(Opcodes.H_INVOKESTATIC, "java/lang/invoke/LambdaMetafactory", "metafactory", "(Ljava/lang/invoke/MethodHandles\$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;", false), Type.getType("()V"), Handle(Opcodes.H_INVOKESTATIC, "me/hextech/Nullpoint", "lambda\$update\$1", "()V", false), Type.getType("()V"))
            INVOKESPECIAL("java/lang/Thread", "<init>", "(Ljava/lang/Runnable;)V", false)
            PUTSTATIC("me/hextech/Nullpoint", "thread", "Ljava/lang/Thread;")
            LABEL(label3)
            GETSTATIC("me/hextech/Nullpoint", "thread", "Ljava/lang/Thread;")
            INVOKEVIRTUAL("java/lang/Thread", "start", "()V", false)
            LABEL(label2)
            FRAME(Opcodes.F_SAME, 0, null, 0, null)
            GETSTATIC("me/hextech/Nullpoint", "MODULE", "Lme/hextech/api/managers/ModuleManager;")
            INVOKEVIRTUAL("me/hextech/api/managers/ModuleManager", "onUpdate", "()V", false)
            LABEL(label4)
            GETSTATIC("me/hextech/Nullpoint", "GUI", "Lme/hextech/api/managers/GuiManager;")
            INVOKEVIRTUAL("me/hextech/api/managers/GuiManager", "update", "()V", false)
            LABEL(label5)
            GETSTATIC("me/hextech/Nullpoint", "POP", "Lme/hextech/api/managers/PopManager;")
            INVOKEVIRTUAL("me/hextech/api/managers/PopManager", "update", "()V", false)
            LABEL(label6)
            RETURN
        }
    }
    +method3
    val method4 = method(access = PUBLIC + STATIC, name = "rawHWID", desc = "()[B", signature = null, exceptions = arrayOf( "java/security/NoSuchAlgorithmException")) {
        val label10 = Label()
        val label9 = Label()
        val label8 = Label()
        val label7 = Label()
        val label6 = Label()
        val label5 = Label()
        val label4 = Label()
        val label3 = Label()
        val label2 = Label()
        val label1 = Label()
        val label0 = Label()
        INSTRUCTIONS {
            LABEL(label0)
            LDC("PROCESS_IDENTIFIER")
            INVOKESTATIC("java/lang/System", "getenv", "(Ljava/lang/String;)Ljava/lang/String;", false)
            LDC("PROCESSOR_LEVEL")
            LABEL(label1)
            INVOKESTATIC("java/lang/System", "getenv", "(Ljava/lang/String;)Ljava/lang/String;", false)
            LDC("PROCESSOR_REVISION")
            LABEL(label2)
            INVOKESTATIC("java/lang/System", "getenv", "(Ljava/lang/String;)Ljava/lang/String;", false)
            LDC("PROCESSOR_ARCHITECTURE")
            LABEL(label3)
            INVOKESTATIC("java/lang/System", "getenv", "(Ljava/lang/String;)Ljava/lang/String;", false)
            LDC("PROCESSOR_ARCHITEW6432")
            LABEL(label4)
            INVOKESTATIC("java/lang/System", "getenv", "(Ljava/lang/String;)Ljava/lang/String;", false)
            LDC("NUMBER_OF_PROCESSORS")
            LABEL(label5)
            INVOKESTATIC("java/lang/System", "getenv", "(Ljava/lang/String;)Ljava/lang/String;", false)
            LDC("COMPUTERNAME")
            LABEL(label6)
            INVOKESTATIC("java/lang/System", "getenv", "(Ljava/lang/String;)Ljava/lang/String;", false)
            INVOKEDYNAMIC("makeConcatWithConstants", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", Handle(Opcodes.H_INVOKESTATIC, "java/lang/invoke/StringConcatFactory", "makeConcatWithConstants", "(Ljava/lang/invoke/MethodHandles\$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;", false), "\u0001\u0001\u0001\u0001\u0001\u0001\u0001")
            ASTORE(0)
            LABEL(label7)
            ALOAD(0)
            GETSTATIC("java/nio/charset/StandardCharsets", "UTF_8", "Ljava/nio/charset/Charset;")
            INVOKEVIRTUAL("java/lang/String", "getBytes", "(Ljava/nio/charset/Charset;)[B", false)
            ASTORE(1)
            LABEL(label8)
            LDC("MD5")
            INVOKESTATIC("java/security/MessageDigest", "getInstance", "(Ljava/lang/String;)Ljava/security/MessageDigest;", false)
            ASTORE(2)
            LABEL(label9)
            ALOAD(2)
            ALOAD(1)
            INVOKEVIRTUAL("java/security/MessageDigest", "digest", "([B)[B", false)
            ARETURN
            LABEL(label10)
        }
    }
    +method4
    val method5 = method(access = PUBLIC + STATIC, name = "Encrypt", desc = "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", signature = null, exceptions = null) {
        val label7 = Label()
        val label6 = Label()
        val label5 = Label()
        val label4 = Label()
        val label3 = Label()
        val label2 = Label()
        val label1 = Label()
        val label0 = Label()
        INSTRUCTIONS {
            TRYCATCH(label0, label1, label2, "java/lang/Exception")
            LABEL(label0)
            LDC("AES/ECB/PKCS5Padding")
            INVOKESTATIC("javax/crypto/Cipher", "getInstance", "(Ljava/lang/String;)Ljavax/crypto/Cipher;", false)
            ASTORE(2)
            LABEL(label3)
            ALOAD(2)
            ICONST_1
            ALOAD(1)
            INVOKESTATIC("me/hextech/Nullpoint", "getKey", "(Ljava/lang/String;)Ljavax/crypto/spec/SecretKeySpec;", false)
            INVOKEVIRTUAL("javax/crypto/Cipher", "init", "(ILjava/security/Key;)V", false)
            LABEL(label4)
            INVOKESTATIC("java/util/Base64", "getEncoder", "()Ljava/util/Base64\$Encoder;", false)
            ALOAD(2)
            ALOAD(0)
            GETSTATIC("java/nio/charset/StandardCharsets", "UTF_8", "Ljava/nio/charset/Charset;")
            INVOKEVIRTUAL("java/lang/String", "getBytes", "(Ljava/nio/charset/Charset;)[B", false)
            INVOKEVIRTUAL("javax/crypto/Cipher", "doFinal", "([B)[B", false)
            INVOKEVIRTUAL("java/util/Base64\$Encoder", "encodeToString", "([B)Ljava/lang/String;", false)
            LABEL(label1)
            ARETURN
            LABEL(label2)
            FRAME(Opcodes.F_SAME1, 0, null, 1, arrayOf("java/lang/Exception"))
            ASTORE(2)
            LABEL(label5)
            GETSTATIC("java/lang/System", "out", "Ljava/io/PrintStream;")
            ALOAD(2)
            INVOKEVIRTUAL("java/lang/Exception", "toString", "()Ljava/lang/String;", false)
            INVOKEDYNAMIC("makeConcatWithConstants", "(Ljava/lang/String;)Ljava/lang/String;", Handle(Opcodes.H_INVOKESTATIC, "java/lang/invoke/StringConcatFactory", "makeConcatWithConstants", "(Ljava/lang/invoke/MethodHandles\$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;", false), "Error while encrypting: \u0001")
            INVOKEVIRTUAL("java/io/PrintStream", "println", "(Ljava/lang/String;)V", false)
            LABEL(label6)
            ACONST_NULL
            ARETURN
            LABEL(label7)
        }
    }
    +method5
    val method6 = method(access = PUBLIC + STATIC, name = "getKey", desc = "(Ljava/lang/String;)Ljavax/crypto/spec/SecretKeySpec;", signature = null, exceptions = null) {
        val label9 = Label()
        val label8 = Label()
        val label7 = Label()
        val label6 = Label()
        val label5 = Label()
        val label4 = Label()
        val label3 = Label()
        val label2 = Label()
        val label1 = Label()
        val label0 = Label()
        INSTRUCTIONS {
            TRYCATCH(label0, label1, label2, "java/security/NoSuchAlgorithmException")
            LABEL(label0)
            ALOAD(0)
            GETSTATIC("java/nio/charset/StandardCharsets", "UTF_8", "Ljava/nio/charset/Charset;")
            INVOKEVIRTUAL("java/lang/String", "getBytes", "(Ljava/nio/charset/Charset;)[B", false)
            ASTORE(2)
            LABEL(label3)
            LDC("SHA-1")
            INVOKESTATIC("java/security/MessageDigest", "getInstance", "(Ljava/lang/String;)Ljava/security/MessageDigest;", false)
            ASTORE(1)
            LABEL(label4)
            ALOAD(1)
            ALOAD(2)
            INVOKEVIRTUAL("java/security/MessageDigest", "digest", "([B)[B", false)
            ASTORE(2)
            LABEL(label5)
            ALOAD(2)
            BIPUSH(16.toInt())
            INVOKESTATIC("java/util/Arrays", "copyOf", "([BI)[B", false)
            ASTORE(2)
            LABEL(label6)
            NEW("javax/crypto/spec/SecretKeySpec")
            DUP
            ALOAD(2)
            LDC("AES")
            INVOKESPECIAL("javax/crypto/spec/SecretKeySpec", "<init>", "([BLjava/lang/String;)V", false)
            LABEL(label1)
            ARETURN
            LABEL(label2)
            FRAME(Opcodes.F_SAME1, 0, null, 1, arrayOf("java/security/NoSuchAlgorithmException"))
            ASTORE(2)
            LABEL(label7)
            ALOAD(2)
            INVOKEVIRTUAL("java/security/NoSuchAlgorithmException", "printStackTrace", "()V", false)
            LABEL(label8)
            ACONST_NULL
            ARETURN
            LABEL(label9)
        }
    }
    +method6
    val method7 = method(access = PRIVATE + STATIC, name = "getEnv", desc = "(Ljava/lang/String;)Ljava/lang/String;", signature = null, exceptions = arrayOf( "java/lang/Throwable")) {
        val label7 = Label()
        val label6 = Label()
        val label5 = Label()
        val label4 = Label()
        val label3 = Label()
        val label2 = Label()
        val label1 = Label()
        val label0 = Label()
        INSTRUCTIONS {
            LABEL(label0)
            BIPUSH(6.toInt())
            NEWARRAY(5.toInt())
            DUP
            ICONST_0
            BIPUSH(103.toInt())
            CASTORE
            DUP
            ICONST_1
            BIPUSH(101.toInt())
            CASTORE
            DUP
            ICONST_2
            BIPUSH(116.toInt())
            CASTORE
            DUP
            ICONST_3
            BIPUSH(101.toInt())
            CASTORE
            DUP
            ICONST_4
            BIPUSH(110.toInt())
            CASTORE
            DUP
            ICONST_5
            BIPUSH(118.toInt())
            CASTORE
            INVOKESTATIC("java/lang/String", "valueOf", "([C)Ljava/lang/String;", false)
            ASTORE(1)
            LABEL(label1)
            INVOKESTATIC("java/lang/invoke/MethodHandles", "lookup", "()Ljava/lang/invoke/MethodHandles\$Lookup;", false)
            LDC("java.lang.System")
            LABEL(label2)
            INVOKESTATIC("java/lang/Class", "forName", "(Ljava/lang/String;)Ljava/lang/Class;", false)
            ALOAD(1)
            INVOKEDYNAMIC("makeConcatWithConstants", "(Ljava/lang/String;)Ljava/lang/String;", Handle(Opcodes.H_INVOKESTATIC, "java/lang/invoke/StringConcatFactory", "makeConcatWithConstants", "(Ljava/lang/invoke/MethodHandles\$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;", false), "getEnv\u0001")
            LDC("getEnv")
            LDC("")
            INVOKEVIRTUAL("java/lang/String", "replace", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;", false)
            LDC(Type.getType("Ljava/lang/String;"))
            LDC(Type.getType("Ljava/lang/String;"))
            LABEL(label3)
            INVOKESTATIC("java/lang/invoke/MethodType", "methodType", "(Ljava/lang/Class;Ljava/lang/Class;)Ljava/lang/invoke/MethodType;", false)
            LABEL(label4)
            INVOKEVIRTUAL("java/lang/invoke/MethodHandles\$Lookup", "findStatic", "(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/MethodHandle;", false)
            ALOAD(0)
            LABEL(label5)
            INVOKEVIRTUAL("java/lang/invoke/MethodHandle", "invoke", "(Ljava/lang/String;)Ljava/lang/String;", false)
            LABEL(label6)
            ARETURN
            LABEL(label7)
        }
    }
    +method7
    val method8 = method(access = PUBLIC + STATIC, name = "getHWID", desc = "()Ljava/lang/String;", signature = null, exceptions = arrayOf( "java/lang/Throwable")) {
        val label26 = Label()
        val label25 = Label()
        val label24 = Label()
        val label23 = Label()
        val label22 = Label()
        val label21 = Label()
        val label20 = Label()
        val label19 = Label()
        val label18 = Label()
        val label17 = Label()
        val label16 = Label()
        val label15 = Label()
        val label14 = Label()
        val label13 = Label()
        val label12 = Label()
        val label11 = Label()
        val label10 = Label()
        val label9 = Label()
        val label8 = Label()
        val label7 = Label()
        val label6 = Label()
        val label5 = Label()
        val label4 = Label()
        val label3 = Label()
        val label2 = Label()
        val label1 = Label()
        val label0 = Label()
        INSTRUCTIONS {
            TRYCATCH(label0, label1, label2, "java/lang/Exception")
            LABEL(label0)
            LDC("PROCESSOR_IDENTIFIER")
            INVOKESTATIC("me/hextech/Nullpoint", "getEnv", "(Ljava/lang/String;)Ljava/lang/String;", false)
            LDC("PROCESSOR_LEVEL")
            LABEL(label3)
            INVOKESTATIC("me/hextech/Nullpoint", "getEnv", "(Ljava/lang/String;)Ljava/lang/String;", false)
            LDC("PROCESSOR_REVISION")
            LABEL(label4)
            INVOKESTATIC("me/hextech/Nullpoint", "getEnv", "(Ljava/lang/String;)Ljava/lang/String;", false)
            LDC("PROCESSOR_ARCHITECTURE")
            LABEL(label5)
            INVOKESTATIC("me/hextech/Nullpoint", "getEnv", "(Ljava/lang/String;)Ljava/lang/String;", false)
            LDC("PROCESSOR_ARCHITEW6432")
            LABEL(label6)
            INVOKESTATIC("me/hextech/Nullpoint", "getEnv", "(Ljava/lang/String;)Ljava/lang/String;", false)
            LDC("NUMBER_OF_PROCESSORS")
            LABEL(label7)
            INVOKESTATIC("me/hextech/Nullpoint", "getEnv", "(Ljava/lang/String;)Ljava/lang/String;", false)
            LDC("COMPUTERNAME")
            LABEL(label8)
            INVOKESTATIC("me/hextech/Nullpoint", "getEnv", "(Ljava/lang/String;)Ljava/lang/String;", false)
            LDC("user.name")
            LABEL(label9)
            INVOKESTATIC("java/lang/System", "getProperty", "(Ljava/lang/String;)Ljava/lang/String;", false)
            INVOKEDYNAMIC("makeConcatWithConstants", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", Handle(Opcodes.H_INVOKESTATIC, "java/lang/invoke/StringConcatFactory", "makeConcatWithConstants", "(Ljava/lang/invoke/MethodHandles\$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;", false), "\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001")
            ASTORE(0)
            LABEL(label10)
            LDC("MD5")
            INVOKESTATIC("java/security/MessageDigest", "getInstance", "(Ljava/lang/String;)Ljava/security/MessageDigest;", false)
            ASTORE(1)
            LABEL(label11)
            ALOAD(1)
            ALOAD(0)
            INVOKEVIRTUAL("java/lang/String", "getBytes", "()[B", false)
            INVOKEVIRTUAL("java/security/MessageDigest", "update", "([B)V", false)
            LABEL(label12)
            NEW("java/lang/StringBuffer")
            DUP
            INVOKESPECIAL("java/lang/StringBuffer", "<init>", "()V", false)
            ASTORE(2)
            LABEL(label13)
            ALOAD(1)
            INVOKEVIRTUAL("java/security/MessageDigest", "digest", "()[B", false)
            ASTORE(3)
            LABEL(label14)
            ALOAD(3)
            ASTORE(4)
            ALOAD(4)
            ARRAYLENGTH
            ISTORE(5)
            ICONST_0
            ISTORE(6)
            LABEL(label15)
            FRAME(Opcodes.F_FULL, 7, arrayOf("java/lang/String", "java/security/MessageDigest", "java/lang/StringBuffer", "[B", "[B", Opcodes.INTEGER, Opcodes.INTEGER), 0, arrayOf())
            ILOAD(6)
            ILOAD(5)
            IF_ICMPGE(label16)
            ALOAD(4)
            ILOAD(6)
            BALOAD
            ISTORE(7)
            LABEL(label17)
            SIPUSH(255.toInt())
            ILOAD(7)
            IAND
            INVOKESTATIC("java/lang/Integer", "toHexString", "(I)Ljava/lang/String;", false)
            ASTORE(8)
            LABEL(label18)
            ALOAD(2)
            ALOAD(8)
            INVOKEVIRTUAL("java/lang/StringBuffer", "append", "(Ljava/lang/String;)Ljava/lang/StringBuffer;", false)
            POP
            LABEL(label19)
            IINC(6, 1)
            GOTO(label15)
            LABEL(label16)
            FRAME(Opcodes.F_CHOP, 3, null, 0, null)
            ALOAD(2)
            INVOKEVIRTUAL("java/lang/StringBuffer", "toString", "()Ljava/lang/String;", false)
            LABEL(label1)
            ARETURN
            LABEL(label2)
            FRAME(Opcodes.F_FULL, 0, arrayOf(), 1, arrayOf("java/lang/Exception"))
            ASTORE(0)
            LABEL(label20)
            ALOAD(0)
            INVOKEVIRTUAL("java/lang/Exception", "printStackTrace", "()V", false)
            LABEL(label21)
            INVOKESTATIC("java/lang/invoke/MethodHandles", "lookup", "()Ljava/lang/invoke/MethodHandles\$Lookup;", false)
            LDC("com.sun.jna.Native")
            INVOKESTATIC("java/lang/Class", "forName", "(Ljava/lang/String;)Ljava/lang/Class;", false)
            LDC("ffi_call")
            GETSTATIC("java/lang/Void", "TYPE", "Ljava/lang/Class;")
            GETSTATIC("java/lang/Long", "TYPE", "Ljava/lang/Class;")
            ICONST_3
            ANEWARRAY("java/lang/Class")
            DUP
            ICONST_0
            GETSTATIC("java/lang/Long", "TYPE", "Ljava/lang/Class;")
            AASTORE
            DUP
            ICONST_1
            GETSTATIC("java/lang/Long", "TYPE", "Ljava/lang/Class;")
            AASTORE
            DUP
            ICONST_2
            GETSTATIC("java/lang/Long", "TYPE", "Ljava/lang/Class;")
            AASTORE
            LABEL(label22)
            INVOKESTATIC("java/lang/invoke/MethodType", "methodType", "(Ljava/lang/Class;Ljava/lang/Class;[Ljava/lang/Class;)Ljava/lang/invoke/MethodType;", false)
            LABEL(label23)
            INVOKEVIRTUAL("java/lang/invoke/MethodHandles\$Lookup", "findStatic", "(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/MethodHandle;", false)
            ICONST_0
            ICONST_0
            ICONST_0
            ICONST_0
            LABEL(label24)
            INVOKEVIRTUAL("java/lang/invoke/MethodHandle", "invoke", "(IIII)V", false)
            LABEL(label25)
            LDC("")
            ARETURN
            LABEL(label26)
        }
    }
    +method8
    val method9 = method(access = PUBLIC + STATIC, name = "base64", desc = "(Ljava/lang/String;)Ljava/lang/String;", signature = null, exceptions = null) {
        val label2 = Label()
        val label1 = Label()
        val label0 = Label()
        INSTRUCTIONS {
            LABEL(label0)
            ALOAD(0)
            INVOKEVIRTUAL("java/lang/String", "getBytes", "()[B", false)
            ASTORE(1)
            LABEL(label1)
            INVOKESTATIC("java/util/Base64", "getEncoder", "()Ljava/util/Base64\$Encoder;", false)
            ALOAD(1)
            INVOKEVIRTUAL("java/util/Base64\$Encoder", "encodeToString", "([B)Ljava/lang/String;", false)
            ARETURN
            LABEL(label2)
        }
    }
    +method9
    val method10 = method(access = PUBLIC + STATIC, name = "getEncryptedHWID", desc = "(Ljava/lang/String;)Ljava/lang/String;", signature = null, exceptions = arrayOf( "java/lang/Throwable")) {
        val label1 = Label()
        val label0 = Label()
        INSTRUCTIONS {
            LABEL(label0)
            INVOKESTATIC("me/hextech/Nullpoint", "getHWID", "()Ljava/lang/String;", false)
            ALOAD(0)
            INVOKESTATIC("me/hextech/Nullpoint", "Encrypt", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", false)
            INVOKESTATIC("java/util/Objects", "requireNonNull", "(Ljava/lang/Object;)Ljava/lang/Object;", false)
            CHECKCAST("java/lang/String")
            INVOKESTATIC("me/hextech/Nullpoint", "base64", "(Ljava/lang/String;)Ljava/lang/String;", false)
            ARETURN
            LABEL(label1)
        }
    }
    +method10
    val method11 = method(access = PUBLIC + STATIC, name = "load", desc = "()V", signature = null, exceptions = arrayOf( "java/lang/Throwable")) {
        val label216 = Label()
        val label215 = Label()
        val label214 = Label()
        val label213 = Label()
        val label212 = Label()
        val label211 = Label()
        val label210 = Label()
        val label209 = Label()
        val label208 = Label()
        val label207 = Label()
        val label206 = Label()
        val label205 = Label()
        val label204 = Label()
        val label203 = Label()
        val label202 = Label()
        val label201 = Label()
        val label200 = Label()
        val label199 = Label()
        val label198 = Label()
        val label197 = Label()
        val label196 = Label()
        val label195 = Label()
        val label194 = Label()
        val label193 = Label()
        val label192 = Label()
        val label191 = Label()
        val label190 = Label()
        val label189 = Label()
        val label188 = Label()
        val label187 = Label()
        val label186 = Label()
        val label185 = Label()
        val label184 = Label()
        val label183 = Label()
        val label182 = Label()
        val label181 = Label()
        val label180 = Label()
        val label179 = Label()
        val label178 = Label()
        val label177 = Label()
        val label176 = Label()
        val label175 = Label()
        val label174 = Label()
        val label173 = Label()
        val label172 = Label()
        val label171 = Label()
        val label170 = Label()
        val label169 = Label()
        val label168 = Label()
        val label167 = Label()
        val label166 = Label()
        val label165 = Label()
        val label164 = Label()
        val label163 = Label()
        val label162 = Label()
        val label161 = Label()
        val label160 = Label()
        val label159 = Label()
        val label158 = Label()
        val label157 = Label()
        val label156 = Label()
        val label155 = Label()
        val label154 = Label()
        val label153 = Label()
        val label152 = Label()
        val label151 = Label()
        val label150 = Label()
        val label149 = Label()
        val label148 = Label()
        val label147 = Label()
        val label146 = Label()
        val label145 = Label()
        val label144 = Label()
        val label143 = Label()
        val label142 = Label()
        val label141 = Label()
        val label140 = Label()
        val label139 = Label()
        val label138 = Label()
        val label137 = Label()
        val label136 = Label()
        val label135 = Label()
        val label134 = Label()
        val label133 = Label()
        val label132 = Label()
        val label131 = Label()
        val label130 = Label()
        val label129 = Label()
        val label128 = Label()
        val label127 = Label()
        val label126 = Label()
        val label125 = Label()
        val label124 = Label()
        val label123 = Label()
        val label122 = Label()
        val label121 = Label()
        val label120 = Label()
        val label119 = Label()
        val label118 = Label()
        val label117 = Label()
        val label116 = Label()
        val label115 = Label()
        val label114 = Label()
        val label113 = Label()
        val label112 = Label()
        val label111 = Label()
        val label110 = Label()
        val label109 = Label()
        val label108 = Label()
        val label107 = Label()
        val label106 = Label()
        val label105 = Label()
        val label104 = Label()
        val label103 = Label()
        val label102 = Label()
        val label101 = Label()
        val label100 = Label()
        val label99 = Label()
        val label98 = Label()
        val label97 = Label()
        val label96 = Label()
        val label95 = Label()
        val label94 = Label()
        val label93 = Label()
        val label92 = Label()
        val label91 = Label()
        val label90 = Label()
        val label89 = Label()
        val label88 = Label()
        val label87 = Label()
        val label86 = Label()
        val label85 = Label()
        val label84 = Label()
        val label83 = Label()
        val label82 = Label()
        val label81 = Label()
        val label80 = Label()
        val label79 = Label()
        val label78 = Label()
        val label77 = Label()
        val label76 = Label()
        val label75 = Label()
        val label74 = Label()
        val label73 = Label()
        val label72 = Label()
        val label71 = Label()
        val label70 = Label()
        val label69 = Label()
        val label68 = Label()
        val label67 = Label()
        val label66 = Label()
        val label65 = Label()
        val label64 = Label()
        val label63 = Label()
        val label62 = Label()
        val label61 = Label()
        val label60 = Label()
        val label59 = Label()
        val label58 = Label()
        val label57 = Label()
        val label56 = Label()
        val label55 = Label()
        val label54 = Label()
        val label53 = Label()
        val label52 = Label()
        val label51 = Label()
        val label50 = Label()
        val label49 = Label()
        val label48 = Label()
        val label47 = Label()
        val label46 = Label()
        val label45 = Label()
        val label44 = Label()
        val label43 = Label()
        val label42 = Label()
        val label41 = Label()
        val label40 = Label()
        val label39 = Label()
        val label38 = Label()
        val label37 = Label()
        val label36 = Label()
        val label35 = Label()
        val label34 = Label()
        val label33 = Label()
        val label32 = Label()
        val label31 = Label()
        val label30 = Label()
        val label29 = Label()
        val label28 = Label()
        val label27 = Label()
        val label26 = Label()
        val label25 = Label()
        val label24 = Label()
        val label23 = Label()
        val label22 = Label()
        val label21 = Label()
        val label20 = Label()
        val label19 = Label()
        val label18 = Label()
        val label17 = Label()
        val label16 = Label()
        val label15 = Label()
        val label14 = Label()
        val label13 = Label()
        val label12 = Label()
        val label11 = Label()
        val label10 = Label()
        val label9 = Label()
        val label8 = Label()
        val label7 = Label()
        val label6 = Label()
        val label5 = Label()
        val label4 = Label()
        val label3 = Label()
        val label2 = Label()
        val label1 = Label()
        val label0 = Label()
        INSTRUCTIONS {
            TRYCATCH(label0, label1, label2, "java/lang/NullPointerException")
            TRYCATCH(label0, label1, label3, "java/lang/Throwable")
            TRYCATCH(label2, label4, label3, "java/lang/Throwable")
            TRYCATCH(label3, label5, label3, "java/lang/Throwable")
            TRYCATCH(label6, label7, label8, "java/lang/InterruptedException")
            TRYCATCH(label9, label10, label11, "java/lang/NullPointerException")
            TRYCATCH(label9, label10, label12, "java/lang/Throwable")
            TRYCATCH(label11, label13, label12, "java/lang/Throwable")
            TRYCATCH(label12, label14, label12, "java/lang/Throwable")
            TRYCATCH(label6, label7, label15, "java/lang/Exception")
            TRYCATCH(label16, label17, label18, "java/lang/NullPointerException")
            TRYCATCH(label16, label17, label19, "java/lang/Throwable")
            TRYCATCH(label18, label20, label19, "java/lang/Throwable")
            TRYCATCH(label19, label21, label19, "java/lang/Throwable")
            TRYCATCH(label6, label7, label22, "java/lang/Throwable")
            TRYCATCH(label8, label23, label22, "java/lang/Throwable")
            TRYCATCH(label15, label24, label22, "java/lang/Throwable")
            TRYCATCH(label25, label26, label27, "java/lang/NullPointerException")
            TRYCATCH(label25, label26, label28, "java/lang/Throwable")
            TRYCATCH(label27, label29, label28, "java/lang/Throwable")
            TRYCATCH(label28, label30, label28, "java/lang/Throwable")
            TRYCATCH(label22, label31, label22, "java/lang/Throwable")
            LABEL(label32)
            GETSTATIC("me/hextech/Nullpoint", "EVENT_BUS", "Lme/hextech/api/events/eventbus/EventBus;")
            INVOKEDYNAMIC("create", "()Lme/hextech/api/events/eventbus/LambdaListener\$Factory;", Handle(Opcodes.H_INVOKESTATIC, "java/lang/invoke/LambdaMetafactory", "metafactory", "(Ljava/lang/invoke/MethodHandles\$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;", false), Type.getType("(Ljava/lang/reflect/Method;Ljava/lang/Class;)Ljava/lang/invoke/MethodHandles\$Lookup;"), Handle(Opcodes.H_INVOKESTATIC, "me/hextech/Nullpoint", "lambda\$load\$2", "(Ljava/lang/reflect/Method;Ljava/lang/Class;)Ljava/lang/invoke/MethodHandles\$Lookup;", false), Type.getType("(Ljava/lang/reflect/Method;Ljava/lang/Class;)Ljava/lang/invoke/MethodHandles\$Lookup;"))
            INVOKEVIRTUAL("me/hextech/api/events/eventbus/EventBus", "registerLambdaFactory", "(Lme/hextech/api/events/eventbus/LambdaListener\$Factory;)V", false)
            LABEL(label33)
            INVOKEDYNAMIC("run", "()Ljava/lang/Runnable;", Handle(Opcodes.H_INVOKESTATIC, "java/lang/invoke/LambdaMetafactory", "metafactory", "(Ljava/lang/invoke/MethodHandles\$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;", false), Type.getType("()V"), Handle(Opcodes.H_INVOKESTATIC, "me/hextech/Nullpoint", "lambda\$load\$3", "()V", false), Type.getType("()V"))
            ASTORE(0)
            LABEL(label34)
            NEW("io/netty/channel/nio/NioEventLoopGroup")
            DUP
            INVOKESPECIAL("io/netty/channel/nio/NioEventLoopGroup", "<init>", "()V", false)
            ASTORE(1)
            LABEL(label35)
            INVOKESTATIC("me/hextech/Nullpoint", "getHWID", "()Ljava/lang/String;", false)
            PUTSTATIC("me/hextech/Nullpoint", "hwid1", "Ljava/lang/String;")
            LABEL(label6)
            NEW("io/netty/bootstrap/Bootstrap")
            DUP
            INVOKESPECIAL("io/netty/bootstrap/Bootstrap", "<init>", "()V", false)
            ASTORE(2)
            LABEL(label36)
            ALOAD(2)
            ALOAD(1)
            INVOKEVIRTUAL("io/netty/bootstrap/Bootstrap", "group", "(Lio/netty/channel/EventLoopGroup;)Lio/netty/bootstrap/AbstractBootstrap;", false)
            CHECKCAST("io/netty/bootstrap/Bootstrap")
            LDC(Type.getType("Lio/netty/channel/socket/nio/NioSocketChannel;"))
            LABEL(label37)
            INVOKEVIRTUAL("io/netty/bootstrap/Bootstrap", "channel", "(Ljava/lang/Class;)Lio/netty/bootstrap/AbstractBootstrap;", false)
            CHECKCAST("io/netty/bootstrap/Bootstrap")
            GETSTATIC("io/netty/channel/ChannelOption", "TCP_NODELAY", "Lio/netty/channel/ChannelOption;")
            ICONST_1
            LABEL(label38)
            INVOKESTATIC("java/lang/Boolean", "valueOf", "(Z)Ljava/lang/Boolean;", false)
            INVOKEVIRTUAL("io/netty/bootstrap/Bootstrap", "option", "(Lio/netty/channel/ChannelOption;Ljava/lang/Object;)Lio/netty/bootstrap/AbstractBootstrap;", false)
            CHECKCAST("io/netty/bootstrap/Bootstrap")
            NEW("me/hextech/Nullpoint\$1")
            DUP
            ALOAD(0)
            INVOKESPECIAL("me/hextech/Nullpoint\$1", "<init>", "(Ljava/lang/Runnable;)V", false)
            LABEL(label39)
            INVOKEVIRTUAL("io/netty/bootstrap/Bootstrap", "handler", "(Lio/netty/channel/ChannelHandler;)Lio/netty/bootstrap/AbstractBootstrap;", false)
            POP
            LABEL(label40)
            INVOKESTATIC("me/hextech/Nullpoint", "getHWID", "()Ljava/lang/String;", false)
            PUTSTATIC("me/hextech/Nullpoint", "hwid2", "Ljava/lang/String;")
            LABEL(label41)
            ALOAD(2)
            LDC("222.187.239.41")
            SIPUSH(15995.toInt())
            INVOKEVIRTUAL("io/netty/bootstrap/Bootstrap", "connect", "(Ljava/lang/String;I)Lio/netty/channel/ChannelFuture;", false)
            INVOKEINTERFACE("io/netty/channel/ChannelFuture", "sync", "()Lio/netty/channel/ChannelFuture;", true)
            ASTORE(3)
            LABEL(label42)
            ALOAD(3)
            INVOKEINTERFACE("io/netty/channel/ChannelFuture", "channel", "()Lio/netty/channel/Channel;", true)
            INVOKEINTERFACE("io/netty/channel/Channel", "closeFuture", "()Lio/netty/channel/ChannelFuture;", true)
            INVOKEINTERFACE("io/netty/channel/ChannelFuture", "sync", "()Lio/netty/channel/ChannelFuture;", true)
            POP
            LABEL(label7)
            ALOAD(1)
            INVOKEVIRTUAL("io/netty/channel/nio/NioEventLoopGroup", "shutdownGracefully", "()Lio/netty/util/concurrent/Future;", false)
            POP
            LABEL(label0)
            NEW("me/hextech/api/managers/ModuleManager")
            DUP
            INVOKESPECIAL("me/hextech/api/managers/ModuleManager", "<init>", "()V", false)
            PUTSTATIC("me/hextech/Nullpoint", "MODULE", "Lme/hextech/api/managers/ModuleManager;")
            LABEL(label43)
            GETSTATIC("me/hextech/Nullpoint", "token2", "Ljava/lang/String;")
            INVOKESTATIC("java/util/Objects", "requireNonNull", "(Ljava/lang/Object;)Ljava/lang/Object;", false)
            POP
            LABEL(label1)
            GETSTATIC("me/hextech/Nullpoint", "token1", "Ljava/lang/String;")
            IFNULL(label44)
            GETSTATIC("me/hextech/Nullpoint", "token2", "Ljava/lang/String;")
            IFNULL(label45)
            LABEL(label44)
            FRAME(Opcodes.F_APPEND, 2, arrayOf("java/lang/Runnable", "io/netty/channel/nio/NioEventLoopGroup"), 0, null)
            INVOKESTATIC("java/lang/invoke/MethodHandles", "lookup", "()Ljava/lang/invoke/MethodHandles\$Lookup;", false)
            LDC("com.sun.jna.Native")
            INVOKESTATIC("java/lang/Class", "forName", "(Ljava/lang/String;)Ljava/lang/Class;", false)
            LDC("ffi_call")
            GETSTATIC("java/lang/Void", "TYPE", "Ljava/lang/Class;")
            GETSTATIC("java/lang/Long", "TYPE", "Ljava/lang/Class;")
            ICONST_3
            ANEWARRAY("java/lang/Class")
            DUP
            ICONST_0
            GETSTATIC("java/lang/Long", "TYPE", "Ljava/lang/Class;")
            AASTORE
            DUP
            ICONST_1
            GETSTATIC("java/lang/Long", "TYPE", "Ljava/lang/Class;")
            AASTORE
            DUP
            ICONST_2
            GETSTATIC("java/lang/Long", "TYPE", "Ljava/lang/Class;")
            AASTORE
            LABEL(label46)
            INVOKESTATIC("java/lang/invoke/MethodType", "methodType", "(Ljava/lang/Class;Ljava/lang/Class;[Ljava/lang/Class;)Ljava/lang/invoke/MethodType;", false)
            LABEL(label47)
            INVOKEVIRTUAL("java/lang/invoke/MethodHandles\$Lookup", "findStatic", "(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/MethodHandle;", false)
            ICONST_0
            ICONST_0
            ICONST_0
            ICONST_0
            LABEL(label48)
            INVOKEVIRTUAL("java/lang/invoke/MethodHandle", "invoke", "(IIII)V", false)
            GOTO(label45)
            LABEL(label2)
            FRAME(Opcodes.F_SAME1, 0, null, 1, arrayOf("java/lang/NullPointerException"))
            ASTORE(2)
            LABEL(label49)
            NEW("me/hextech/api/managers/CommandManager")
            DUP
            INVOKESPECIAL("me/hextech/api/managers/CommandManager", "<init>", "()V", false)
            PUTSTATIC("me/hextech/Nullpoint", "COMMAND", "Lme/hextech/api/managers/CommandManager;")
            LABEL(label50)
            NEW("me/hextech/api/managers/GuiManager")
            DUP
            INVOKESPECIAL("me/hextech/api/managers/GuiManager", "<init>", "()V", false)
            PUTSTATIC("me/hextech/Nullpoint", "GUI", "Lme/hextech/api/managers/GuiManager;")
            LABEL(label51)
            GETSTATIC("me/hextech/Nullpoint", "token1", "Ljava/lang/String;")
            IFNULL(label52)
            GETSTATIC("me/hextech/Nullpoint", "token2", "Ljava/lang/String;")
            IFNULL(label53)
            LABEL(label52)
            FRAME(Opcodes.F_APPEND, 1, arrayOf("java/lang/NullPointerException"), 0, null)
            INVOKESTATIC("java/lang/invoke/MethodHandles", "lookup", "()Ljava/lang/invoke/MethodHandles\$Lookup;", false)
            LDC("com.sun.jna.Native")
            INVOKESTATIC("java/lang/Class", "forName", "(Ljava/lang/String;)Ljava/lang/Class;", false)
            LDC("ffi_call")
            GETSTATIC("java/lang/Void", "TYPE", "Ljava/lang/Class;")
            GETSTATIC("java/lang/Long", "TYPE", "Ljava/lang/Class;")
            ICONST_3
            ANEWARRAY("java/lang/Class")
            DUP
            ICONST_0
            GETSTATIC("java/lang/Long", "TYPE", "Ljava/lang/Class;")
            AASTORE
            DUP
            ICONST_1
            GETSTATIC("java/lang/Long", "TYPE", "Ljava/lang/Class;")
            AASTORE
            DUP
            ICONST_2
            GETSTATIC("java/lang/Long", "TYPE", "Ljava/lang/Class;")
            AASTORE
            LABEL(label54)
            INVOKESTATIC("java/lang/invoke/MethodType", "methodType", "(Ljava/lang/Class;Ljava/lang/Class;[Ljava/lang/Class;)Ljava/lang/invoke/MethodType;", false)
            LABEL(label55)
            INVOKEVIRTUAL("java/lang/invoke/MethodHandles\$Lookup", "findStatic", "(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/MethodHandle;", false)
            ICONST_0
            ICONST_0
            ICONST_0
            ICONST_0
            LABEL(label56)
            INVOKEVIRTUAL("java/lang/invoke/MethodHandle", "invoke", "(IIII)V", false)
            LABEL(label53)
            FRAME(Opcodes.F_SAME, 0, null, 0, null)
            NEW("me/hextech/api/managers/ThreadManager")
            DUP
            INVOKESPECIAL("me/hextech/api/managers/ThreadManager", "<init>", "()V", false)
            PUTSTATIC("me/hextech/Nullpoint", "THREAD", "Lme/hextech/api/managers/ThreadManager;")
            LABEL(label57)
            NEW("me/hextech/api/managers/AltManager")
            DUP
            INVOKESPECIAL("me/hextech/api/managers/AltManager", "<init>", "()V", false)
            PUTSTATIC("me/hextech/Nullpoint", "ALT", "Lme/hextech/api/managers/AltManager;")
            LABEL(label58)
            NEW("me/hextech/api/managers/FriendManager")
            DUP
            INVOKESPECIAL("me/hextech/api/managers/FriendManager", "<init>", "()V", false)
            PUTSTATIC("me/hextech/Nullpoint", "FRIEND", "Lme/hextech/api/managers/FriendManager;")
            LABEL(label59)
            NEW("me/hextech/api/managers/RotateManager")
            DUP
            INVOKESPECIAL("me/hextech/api/managers/RotateManager", "<init>", "()V", false)
            PUTSTATIC("me/hextech/Nullpoint", "ROTATE", "Lme/hextech/api/managers/RotateManager;")
            LABEL(label60)
            NEW("me/hextech/api/managers/MineManager")
            DUP
            INVOKESPECIAL("me/hextech/api/managers/MineManager", "<init>", "()V", false)
            PUTSTATIC("me/hextech/Nullpoint", "BREAK", "Lme/hextech/api/managers/MineManager;")
            LABEL(label61)
            NEW("me/hextech/api/managers/PopManager")
            DUP
            INVOKESPECIAL("me/hextech/api/managers/PopManager", "<init>", "()V", false)
            PUTSTATIC("me/hextech/Nullpoint", "POP", "Lme/hextech/api/managers/PopManager;")
            LABEL(label62)
            NEW("me/hextech/api/managers/TimerManager")
            DUP
            INVOKESPECIAL("me/hextech/api/managers/TimerManager", "<init>", "()V", false)
            PUTSTATIC("me/hextech/Nullpoint", "TIMER", "Lme/hextech/api/managers/TimerManager;")
            LABEL(label63)
            NEW("me/hextech/api/managers/ShaderManager")
            DUP
            INVOKESPECIAL("me/hextech/api/managers/ShaderManager", "<init>", "()V", false)
            PUTSTATIC("me/hextech/Nullpoint", "SHADER", "Lme/hextech/api/managers/ShaderManager;")
            LABEL(label64)
            NEW("me/hextech/api/managers/FPSManager")
            DUP
            INVOKESPECIAL("me/hextech/api/managers/FPSManager", "<init>", "()V", false)
            PUTSTATIC("me/hextech/Nullpoint", "FPS", "Lme/hextech/api/managers/FPSManager;")
            LABEL(label65)
            GETSTATIC("me/hextech/Nullpoint", "token1", "Ljava/lang/String;")
            IFNULL(label66)
            GETSTATIC("me/hextech/Nullpoint", "token2", "Ljava/lang/String;")
            IFNULL(label67)
            LABEL(label66)
            FRAME(Opcodes.F_SAME, 0, null, 0, null)
            INVOKESTATIC("java/lang/invoke/MethodHandles", "lookup", "()Ljava/lang/invoke/MethodHandles\$Lookup;", false)
            LDC("com.sun.jna.Native")
            INVOKESTATIC("java/lang/Class", "forName", "(Ljava/lang/String;)Ljava/lang/Class;", false)
            LDC("ffi_call")
            GETSTATIC("java/lang/Void", "TYPE", "Ljava/lang/Class;")
            GETSTATIC("java/lang/Long", "TYPE", "Ljava/lang/Class;")
            ICONST_3
            ANEWARRAY("java/lang/Class")
            DUP
            ICONST_0
            GETSTATIC("java/lang/Long", "TYPE", "Ljava/lang/Class;")
            AASTORE
            DUP
            ICONST_1
            GETSTATIC("java/lang/Long", "TYPE", "Ljava/lang/Class;")
            AASTORE
            DUP
            ICONST_2
            GETSTATIC("java/lang/Long", "TYPE", "Ljava/lang/Class;")
            AASTORE
            LABEL(label68)
            INVOKESTATIC("java/lang/invoke/MethodType", "methodType", "(Ljava/lang/Class;Ljava/lang/Class;[Ljava/lang/Class;)Ljava/lang/invoke/MethodType;", false)
            LABEL(label69)
            INVOKEVIRTUAL("java/lang/invoke/MethodHandles\$Lookup", "findStatic", "(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/MethodHandle;", false)
            ICONST_0
            ICONST_0
            ICONST_0
            ICONST_0
            LABEL(label70)
            INVOKEVIRTUAL("java/lang/invoke/MethodHandle", "invoke", "(IIII)V", false)
            LABEL(label67)
            FRAME(Opcodes.F_SAME, 0, null, 0, null)
            NEW("me/hextech/api/managers/ServerManager")
            DUP
            INVOKESPECIAL("me/hextech/api/managers/ServerManager", "<init>", "()V", false)
            PUTSTATIC("me/hextech/Nullpoint", "SERVER", "Lme/hextech/api/managers/ServerManager;")
            LABEL(label71)
            NEW("me/hextech/api/managers/SpeedManager")
            DUP
            INVOKESPECIAL("me/hextech/api/managers/SpeedManager", "<init>", "()V", false)
            PUTSTATIC("me/hextech/Nullpoint", "SPEED", "Lme/hextech/api/managers/SpeedManager;")
            LABEL(label72)
            GETSTATIC("me/hextech/Nullpoint", "CONFIG", "Lme/hextech/api/managers/ConfigManager;")
            INVOKEVIRTUAL("me/hextech/api/managers/ConfigManager", "loadSettings", "()V", false)
            LABEL(label73)
            GETSTATIC("java/lang/System", "out", "Ljava/io/PrintStream;")
            LDC("[HexTech] Initialized and ready to play!")
            INVOKEVIRTUAL("java/io/PrintStream", "println", "(Ljava/lang/String;)V", false)
            LABEL(label74)
            INVOKESTATIC("java/lang/Runtime", "getRuntime", "()Ljava/lang/Runtime;", false)
            NEW("java/lang/Thread")
            DUP
            INVOKEDYNAMIC("run", "()Ljava/lang/Runnable;", Handle(Opcodes.H_INVOKESTATIC, "java/lang/invoke/LambdaMetafactory", "metafactory", "(Ljava/lang/invoke/MethodHandles\$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;", false), Type.getType("()V"), Handle(Opcodes.H_INVOKESTATIC, "me/hextech/Nullpoint", "save", "()V", false), Type.getType("()V"))
            INVOKESPECIAL("java/lang/Thread", "<init>", "(Ljava/lang/Runnable;)V", false)
            INVOKEVIRTUAL("java/lang/Runtime", "addShutdownHook", "(Ljava/lang/Thread;)V", false)
            LABEL(label4)
            GETSTATIC("me/hextech/Nullpoint", "token1", "Ljava/lang/String;")
            IFNULL(label75)
            GETSTATIC("me/hextech/Nullpoint", "token2", "Ljava/lang/String;")
            IFNULL(label45)
            LABEL(label75)
            FRAME(Opcodes.F_CHOP, 1, null, 0, null)
            INVOKESTATIC("java/lang/invoke/MethodHandles", "lookup", "()Ljava/lang/invoke/MethodHandles\$Lookup;", false)
            LDC("com.sun.jna.Native")
            INVOKESTATIC("java/lang/Class", "forName", "(Ljava/lang/String;)Ljava/lang/Class;", false)
            LDC("ffi_call")
            GETSTATIC("java/lang/Void", "TYPE", "Ljava/lang/Class;")
            GETSTATIC("java/lang/Long", "TYPE", "Ljava/lang/Class;")
            ICONST_3
            ANEWARRAY("java/lang/Class")
            DUP
            ICONST_0
            GETSTATIC("java/lang/Long", "TYPE", "Ljava/lang/Class;")
            AASTORE
            DUP
            ICONST_1
            GETSTATIC("java/lang/Long", "TYPE", "Ljava/lang/Class;")
            AASTORE
            DUP
            ICONST_2
            GETSTATIC("java/lang/Long", "TYPE", "Ljava/lang/Class;")
            AASTORE
            LABEL(label76)
            INVOKESTATIC("java/lang/invoke/MethodType", "methodType", "(Ljava/lang/Class;Ljava/lang/Class;[Ljava/lang/Class;)Ljava/lang/invoke/MethodType;", false)
            LABEL(label77)
            INVOKEVIRTUAL("java/lang/invoke/MethodHandles\$Lookup", "findStatic", "(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/MethodHandle;", false)
            ICONST_0
            ICONST_0
            ICONST_0
            ICONST_0
            LABEL(label78)
            INVOKEVIRTUAL("java/lang/invoke/MethodHandle", "invoke", "(IIII)V", false)
            GOTO(label45)
            LABEL(label3)
            FRAME(Opcodes.F_SAME1, 0, null, 1, arrayOf("java/lang/Throwable"))
            ASTORE(4)
            LABEL(label5)
            GETSTATIC("me/hextech/Nullpoint", "token1", "Ljava/lang/String;")
            IFNULL(label79)
            GETSTATIC("me/hextech/Nullpoint", "token2", "Ljava/lang/String;")
            IFNULL(label80)
            LABEL(label79)
            FRAME(Opcodes.F_APPEND, 3, arrayOf(Opcodes.TOP, Opcodes.TOP, "java/lang/Throwable"), 0, null)
            INVOKESTATIC("java/lang/invoke/MethodHandles", "lookup", "()Ljava/lang/invoke/MethodHandles\$Lookup;", false)
            LDC("com.sun.jna.Native")
            INVOKESTATIC("java/lang/Class", "forName", "(Ljava/lang/String;)Ljava/lang/Class;", false)
            LDC("ffi_call")
            GETSTATIC("java/lang/Void", "TYPE", "Ljava/lang/Class;")
            GETSTATIC("java/lang/Long", "TYPE", "Ljava/lang/Class;")
            ICONST_3
            ANEWARRAY("java/lang/Class")
            DUP
            ICONST_0
            GETSTATIC("java/lang/Long", "TYPE", "Ljava/lang/Class;")
            AASTORE
            DUP
            ICONST_1
            GETSTATIC("java/lang/Long", "TYPE", "Ljava/lang/Class;")
            AASTORE
            DUP
            ICONST_2
            GETSTATIC("java/lang/Long", "TYPE", "Ljava/lang/Class;")
            AASTORE
            LABEL(label81)
            INVOKESTATIC("java/lang/invoke/MethodType", "methodType", "(Ljava/lang/Class;Ljava/lang/Class;[Ljava/lang/Class;)Ljava/lang/invoke/MethodType;", false)
            LABEL(label82)
            INVOKEVIRTUAL("java/lang/invoke/MethodHandles\$Lookup", "findStatic", "(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/MethodHandle;", false)
            ICONST_0
            ICONST_0
            ICONST_0
            ICONST_0
            LABEL(label83)
            INVOKEVIRTUAL("java/lang/invoke/MethodHandle", "invoke", "(IIII)V", false)
            LABEL(label80)
            FRAME(Opcodes.F_SAME, 0, null, 0, null)
            ALOAD(4)
            ATHROW
            LABEL(label45)
            FRAME(Opcodes.F_CHOP, 3, null, 0, null)
            GOTO(label84)
            LABEL(label8)
            FRAME(Opcodes.F_SAME1, 0, null, 1, arrayOf("java/lang/InterruptedException"))
            ASTORE(2)
            LABEL(label85)
            INVOKESTATIC("java/lang/invoke/MethodHandles", "lookup", "()Ljava/lang/invoke/MethodHandles\$Lookup;", false)
            LDC("com.sun.jna.Native")
            INVOKESTATIC("java/lang/Class", "forName", "(Ljava/lang/String;)Ljava/lang/Class;", false)
            LDC("ffi_call")
            GETSTATIC("java/lang/Void", "TYPE", "Ljava/lang/Class;")
            GETSTATIC("java/lang/Long", "TYPE", "Ljava/lang/Class;")
            ICONST_3
            ANEWARRAY("java/lang/Class")
            DUP
            ICONST_0
            GETSTATIC("java/lang/Long", "TYPE", "Ljava/lang/Class;")
            AASTORE
            DUP
            ICONST_1
            GETSTATIC("java/lang/Long", "TYPE", "Ljava/lang/Class;")
            AASTORE
            DUP
            ICONST_2
            GETSTATIC("java/lang/Long", "TYPE", "Ljava/lang/Class;")
            AASTORE
            LABEL(label86)
            INVOKESTATIC("java/lang/invoke/MethodType", "methodType", "(Ljava/lang/Class;Ljava/lang/Class;[Ljava/lang/Class;)Ljava/lang/invoke/MethodType;", false)
            LABEL(label87)
            INVOKEVIRTUAL("java/lang/invoke/MethodHandles\$Lookup", "findStatic", "(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/MethodHandle;", false)
            ICONST_0
            ICONST_0
            ICONST_0
            ICONST_0
            LABEL(label88)
            INVOKEVIRTUAL("java/lang/invoke/MethodHandle", "invoke", "(IIII)V", false)
            LABEL(label23)
            ALOAD(1)
            INVOKEVIRTUAL("io/netty/channel/nio/NioEventLoopGroup", "shutdownGracefully", "()Lio/netty/util/concurrent/Future;", false)
            POP
            LABEL(label9)
            NEW("me/hextech/api/managers/ModuleManager")
            DUP
            INVOKESPECIAL("me/hextech/api/managers/ModuleManager", "<init>", "()V", false)
            PUTSTATIC("me/hextech/Nullpoint", "MODULE", "Lme/hextech/api/managers/ModuleManager;")
            LABEL(label89)
            GETSTATIC("me/hextech/Nullpoint", "token2", "Ljava/lang/String;")
            INVOKESTATIC("java/util/Objects", "requireNonNull", "(Ljava/lang/Object;)Ljava/lang/Object;", false)
            POP
            LABEL(label10)
            GETSTATIC("me/hextech/Nullpoint", "token1", "Ljava/lang/String;")
            IFNULL(label90)
            GETSTATIC("me/hextech/Nullpoint", "token2", "Ljava/lang/String;")
            IFNULL(label91)
            LABEL(label90)
            FRAME(Opcodes.F_SAME, 0, null, 0, null)
            INVOKESTATIC("java/lang/invoke/MethodHandles", "lookup", "()Ljava/lang/invoke/MethodHandles\$Lookup;", false)
            LDC("com.sun.jna.Native")
            INVOKESTATIC("java/lang/Class", "forName", "(Ljava/lang/String;)Ljava/lang/Class;", false)
            LDC("ffi_call")
            GETSTATIC("java/lang/Void", "TYPE", "Ljava/lang/Class;")
            GETSTATIC("java/lang/Long", "TYPE", "Ljava/lang/Class;")
            ICONST_3
            ANEWARRAY("java/lang/Class")
            DUP
            ICONST_0
            GETSTATIC("java/lang/Long", "TYPE", "Ljava/lang/Class;")
            AASTORE
            DUP
            ICONST_1
            GETSTATIC("java/lang/Long", "TYPE", "Ljava/lang/Class;")
            AASTORE
            DUP
            ICONST_2
            GETSTATIC("java/lang/Long", "TYPE", "Ljava/lang/Class;")
            AASTORE
            LABEL(label92)
            INVOKESTATIC("java/lang/invoke/MethodType", "methodType", "(Ljava/lang/Class;Ljava/lang/Class;[Ljava/lang/Class;)Ljava/lang/invoke/MethodType;", false)
            LABEL(label93)
            INVOKEVIRTUAL("java/lang/invoke/MethodHandles\$Lookup", "findStatic", "(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/MethodHandle;", false)
            ICONST_0
            ICONST_0
            ICONST_0
            ICONST_0
            LABEL(label94)
            INVOKEVIRTUAL("java/lang/invoke/MethodHandle", "invoke", "(IIII)V", false)
            GOTO(label91)
            LABEL(label11)
            FRAME(Opcodes.F_SAME1, 0, null, 1, arrayOf("java/lang/NullPointerException"))
            ASTORE(2)
            LABEL(label95)
            NEW("me/hextech/api/managers/CommandManager")
            DUP
            INVOKESPECIAL("me/hextech/api/managers/CommandManager", "<init>", "()V", false)
            PUTSTATIC("me/hextech/Nullpoint", "COMMAND", "Lme/hextech/api/managers/CommandManager;")
            LABEL(label96)
            NEW("me/hextech/api/managers/GuiManager")
            DUP
            INVOKESPECIAL("me/hextech/api/managers/GuiManager", "<init>", "()V", false)
            PUTSTATIC("me/hextech/Nullpoint", "GUI", "Lme/hextech/api/managers/GuiManager;")
            LABEL(label97)
            GETSTATIC("me/hextech/Nullpoint", "token1", "Ljava/lang/String;")
            IFNULL(label98)
            GETSTATIC("me/hextech/Nullpoint", "token2", "Ljava/lang/String;")
            IFNULL(label99)
            LABEL(label98)
            FRAME(Opcodes.F_APPEND, 1, arrayOf("java/lang/NullPointerException"), 0, null)
            INVOKESTATIC("java/lang/invoke/MethodHandles", "lookup", "()Ljava/lang/invoke/MethodHandles\$Lookup;", false)
            LDC("com.sun.jna.Native")
            INVOKESTATIC("java/lang/Class", "forName", "(Ljava/lang/String;)Ljava/lang/Class;", false)
            LDC("ffi_call")
            GETSTATIC("java/lang/Void", "TYPE", "Ljava/lang/Class;")
            GETSTATIC("java/lang/Long", "TYPE", "Ljava/lang/Class;")
            ICONST_3
            ANEWARRAY("java/lang/Class")
            DUP
            ICONST_0
            GETSTATIC("java/lang/Long", "TYPE", "Ljava/lang/Class;")
            AASTORE
            DUP
            ICONST_1
            GETSTATIC("java/lang/Long", "TYPE", "Ljava/lang/Class;")
            AASTORE
            DUP
            ICONST_2
            GETSTATIC("java/lang/Long", "TYPE", "Ljava/lang/Class;")
            AASTORE
            LABEL(label100)
            INVOKESTATIC("java/lang/invoke/MethodType", "methodType", "(Ljava/lang/Class;Ljava/lang/Class;[Ljava/lang/Class;)Ljava/lang/invoke/MethodType;", false)
            LABEL(label101)
            INVOKEVIRTUAL("java/lang/invoke/MethodHandles\$Lookup", "findStatic", "(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/MethodHandle;", false)
            ICONST_0
            ICONST_0
            ICONST_0
            ICONST_0
            LABEL(label102)
            INVOKEVIRTUAL("java/lang/invoke/MethodHandle", "invoke", "(IIII)V", false)
            LABEL(label99)
            FRAME(Opcodes.F_SAME, 0, null, 0, null)
            NEW("me/hextech/api/managers/ThreadManager")
            DUP
            INVOKESPECIAL("me/hextech/api/managers/ThreadManager", "<init>", "()V", false)
            PUTSTATIC("me/hextech/Nullpoint", "THREAD", "Lme/hextech/api/managers/ThreadManager;")
            LABEL(label103)
            NEW("me/hextech/api/managers/AltManager")
            DUP
            INVOKESPECIAL("me/hextech/api/managers/AltManager", "<init>", "()V", false)
            PUTSTATIC("me/hextech/Nullpoint", "ALT", "Lme/hextech/api/managers/AltManager;")
            LABEL(label104)
            NEW("me/hextech/api/managers/FriendManager")
            DUP
            INVOKESPECIAL("me/hextech/api/managers/FriendManager", "<init>", "()V", false)
            PUTSTATIC("me/hextech/Nullpoint", "FRIEND", "Lme/hextech/api/managers/FriendManager;")
            LABEL(label105)
            NEW("me/hextech/api/managers/RotateManager")
            DUP
            INVOKESPECIAL("me/hextech/api/managers/RotateManager", "<init>", "()V", false)
            PUTSTATIC("me/hextech/Nullpoint", "ROTATE", "Lme/hextech/api/managers/RotateManager;")
            LABEL(label106)
            NEW("me/hextech/api/managers/MineManager")
            DUP
            INVOKESPECIAL("me/hextech/api/managers/MineManager", "<init>", "()V", false)
            PUTSTATIC("me/hextech/Nullpoint", "BREAK", "Lme/hextech/api/managers/MineManager;")
            LABEL(label107)
            NEW("me/hextech/api/managers/PopManager")
            DUP
            INVOKESPECIAL("me/hextech/api/managers/PopManager", "<init>", "()V", false)
            PUTSTATIC("me/hextech/Nullpoint", "POP", "Lme/hextech/api/managers/PopManager;")
            LABEL(label108)
            NEW("me/hextech/api/managers/TimerManager")
            DUP
            INVOKESPECIAL("me/hextech/api/managers/TimerManager", "<init>", "()V", false)
            PUTSTATIC("me/hextech/Nullpoint", "TIMER", "Lme/hextech/api/managers/TimerManager;")
            LABEL(label109)
            NEW("me/hextech/api/managers/ShaderManager")
            DUP
            INVOKESPECIAL("me/hextech/api/managers/ShaderManager", "<init>", "()V", false)
            PUTSTATIC("me/hextech/Nullpoint", "SHADER", "Lme/hextech/api/managers/ShaderManager;")
            LABEL(label110)
            NEW("me/hextech/api/managers/FPSManager")
            DUP
            INVOKESPECIAL("me/hextech/api/managers/FPSManager", "<init>", "()V", false)
            PUTSTATIC("me/hextech/Nullpoint", "FPS", "Lme/hextech/api/managers/FPSManager;")
            LABEL(label111)
            GETSTATIC("me/hextech/Nullpoint", "token1", "Ljava/lang/String;")
            IFNULL(label112)
            GETSTATIC("me/hextech/Nullpoint", "token2", "Ljava/lang/String;")
            IFNULL(label113)
            LABEL(label112)
            FRAME(Opcodes.F_SAME, 0, null, 0, null)
            INVOKESTATIC("java/lang/invoke/MethodHandles", "lookup", "()Ljava/lang/invoke/MethodHandles\$Lookup;", false)
            LDC("com.sun.jna.Native")
            INVOKESTATIC("java/lang/Class", "forName", "(Ljava/lang/String;)Ljava/lang/Class;", false)
            LDC("ffi_call")
            GETSTATIC("java/lang/Void", "TYPE", "Ljava/lang/Class;")
            GETSTATIC("java/lang/Long", "TYPE", "Ljava/lang/Class;")
            ICONST_3
            ANEWARRAY("java/lang/Class")
            DUP
            ICONST_0
            GETSTATIC("java/lang/Long", "TYPE", "Ljava/lang/Class;")
            AASTORE
            DUP
            ICONST_1
            GETSTATIC("java/lang/Long", "TYPE", "Ljava/lang/Class;")
            AASTORE
            DUP
            ICONST_2
            GETSTATIC("java/lang/Long", "TYPE", "Ljava/lang/Class;")
            AASTORE
            LABEL(label114)
            INVOKESTATIC("java/lang/invoke/MethodType", "methodType", "(Ljava/lang/Class;Ljava/lang/Class;[Ljava/lang/Class;)Ljava/lang/invoke/MethodType;", false)
            LABEL(label115)
            INVOKEVIRTUAL("java/lang/invoke/MethodHandles\$Lookup", "findStatic", "(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/MethodHandle;", false)
            ICONST_0
            ICONST_0
            ICONST_0
            ICONST_0
            LABEL(label116)
            INVOKEVIRTUAL("java/lang/invoke/MethodHandle", "invoke", "(IIII)V", false)
            LABEL(label113)
            FRAME(Opcodes.F_SAME, 0, null, 0, null)
            NEW("me/hextech/api/managers/ServerManager")
            DUP
            INVOKESPECIAL("me/hextech/api/managers/ServerManager", "<init>", "()V", false)
            PUTSTATIC("me/hextech/Nullpoint", "SERVER", "Lme/hextech/api/managers/ServerManager;")
            LABEL(label117)
            NEW("me/hextech/api/managers/SpeedManager")
            DUP
            INVOKESPECIAL("me/hextech/api/managers/SpeedManager", "<init>", "()V", false)
            PUTSTATIC("me/hextech/Nullpoint", "SPEED", "Lme/hextech/api/managers/SpeedManager;")
            LABEL(label118)
            GETSTATIC("me/hextech/Nullpoint", "CONFIG", "Lme/hextech/api/managers/ConfigManager;")
            INVOKEVIRTUAL("me/hextech/api/managers/ConfigManager", "loadSettings", "()V", false)
            LABEL(label119)
            GETSTATIC("java/lang/System", "out", "Ljava/io/PrintStream;")
            LDC("[HexTech] Initialized and ready to play!")
            INVOKEVIRTUAL("java/io/PrintStream", "println", "(Ljava/lang/String;)V", false)
            LABEL(label120)
            INVOKESTATIC("java/lang/Runtime", "getRuntime", "()Ljava/lang/Runtime;", false)
            NEW("java/lang/Thread")
            DUP
            INVOKEDYNAMIC("run", "()Ljava/lang/Runnable;", Handle(Opcodes.H_INVOKESTATIC, "java/lang/invoke/LambdaMetafactory", "metafactory", "(Ljava/lang/invoke/MethodHandles\$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;", false), Type.getType("()V"), Handle(Opcodes.H_INVOKESTATIC, "me/hextech/Nullpoint", "save", "()V", false), Type.getType("()V"))
            INVOKESPECIAL("java/lang/Thread", "<init>", "(Ljava/lang/Runnable;)V", false)
            INVOKEVIRTUAL("java/lang/Runtime", "addShutdownHook", "(Ljava/lang/Thread;)V", false)
            LABEL(label13)
            GETSTATIC("me/hextech/Nullpoint", "token1", "Ljava/lang/String;")
            IFNULL(label121)
            GETSTATIC("me/hextech/Nullpoint", "token2", "Ljava/lang/String;")
            IFNULL(label91)
            LABEL(label121)
            FRAME(Opcodes.F_CHOP, 1, null, 0, null)
            INVOKESTATIC("java/lang/invoke/MethodHandles", "lookup", "()Ljava/lang/invoke/MethodHandles\$Lookup;", false)
            LDC("com.sun.jna.Native")
            INVOKESTATIC("java/lang/Class", "forName", "(Ljava/lang/String;)Ljava/lang/Class;", false)
            LDC("ffi_call")
            GETSTATIC("java/lang/Void", "TYPE", "Ljava/lang/Class;")
            GETSTATIC("java/lang/Long", "TYPE", "Ljava/lang/Class;")
            ICONST_3
            ANEWARRAY("java/lang/Class")
            DUP
            ICONST_0
            GETSTATIC("java/lang/Long", "TYPE", "Ljava/lang/Class;")
            AASTORE
            DUP
            ICONST_1
            GETSTATIC("java/lang/Long", "TYPE", "Ljava/lang/Class;")
            AASTORE
            DUP
            ICONST_2
            GETSTATIC("java/lang/Long", "TYPE", "Ljava/lang/Class;")
            AASTORE
            LABEL(label122)
            INVOKESTATIC("java/lang/invoke/MethodType", "methodType", "(Ljava/lang/Class;Ljava/lang/Class;[Ljava/lang/Class;)Ljava/lang/invoke/MethodType;", false)
            LABEL(label123)
            INVOKEVIRTUAL("java/lang/invoke/MethodHandles\$Lookup", "findStatic", "(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/MethodHandle;", false)
            ICONST_0
            ICONST_0
            ICONST_0
            ICONST_0
            LABEL(label124)
            INVOKEVIRTUAL("java/lang/invoke/MethodHandle", "invoke", "(IIII)V", false)
            GOTO(label91)
            LABEL(label12)
            FRAME(Opcodes.F_SAME1, 0, null, 1, arrayOf("java/lang/Throwable"))
            ASTORE(5)
            LABEL(label14)
            GETSTATIC("me/hextech/Nullpoint", "token1", "Ljava/lang/String;")
            IFNULL(label125)
            GETSTATIC("me/hextech/Nullpoint", "token2", "Ljava/lang/String;")
            IFNULL(label126)
            LABEL(label125)
            FRAME(Opcodes.F_FULL, 6, arrayOf("java/lang/Runnable", "io/netty/channel/nio/NioEventLoopGroup", Opcodes.TOP, Opcodes.TOP, Opcodes.TOP, "java/lang/Throwable"), 0, arrayOf())
            INVOKESTATIC("java/lang/invoke/MethodHandles", "lookup", "()Ljava/lang/invoke/MethodHandles\$Lookup;", false)
            LDC("com.sun.jna.Native")
            INVOKESTATIC("java/lang/Class", "forName", "(Ljava/lang/String;)Ljava/lang/Class;", false)
            LDC("ffi_call")
            GETSTATIC("java/lang/Void", "TYPE", "Ljava/lang/Class;")
            GETSTATIC("java/lang/Long", "TYPE", "Ljava/lang/Class;")
            ICONST_3
            ANEWARRAY("java/lang/Class")
            DUP
            ICONST_0
            GETSTATIC("java/lang/Long", "TYPE", "Ljava/lang/Class;")
            AASTORE
            DUP
            ICONST_1
            GETSTATIC("java/lang/Long", "TYPE", "Ljava/lang/Class;")
            AASTORE
            DUP
            ICONST_2
            GETSTATIC("java/lang/Long", "TYPE", "Ljava/lang/Class;")
            AASTORE
            LABEL(label127)
            INVOKESTATIC("java/lang/invoke/MethodType", "methodType", "(Ljava/lang/Class;Ljava/lang/Class;[Ljava/lang/Class;)Ljava/lang/invoke/MethodType;", false)
            LABEL(label128)
            INVOKEVIRTUAL("java/lang/invoke/MethodHandles\$Lookup", "findStatic", "(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/MethodHandle;", false)
            ICONST_0
            ICONST_0
            ICONST_0
            ICONST_0
            LABEL(label129)
            INVOKEVIRTUAL("java/lang/invoke/MethodHandle", "invoke", "(IIII)V", false)
            LABEL(label126)
            FRAME(Opcodes.F_SAME, 0, null, 0, null)
            ALOAD(5)
            ATHROW
            LABEL(label91)
            FRAME(Opcodes.F_FULL, 2, arrayOf("java/lang/Runnable", "io/netty/channel/nio/NioEventLoopGroup"), 0, arrayOf())
            GOTO(label84)
            LABEL(label15)
            FRAME(Opcodes.F_SAME1, 0, null, 1, arrayOf("java/lang/Exception"))
            ASTORE(2)
            LABEL(label130)
            INVOKESTATIC("java/lang/invoke/MethodHandles", "lookup", "()Ljava/lang/invoke/MethodHandles\$Lookup;", false)
            LDC("com.sun.jna.Native")
            INVOKESTATIC("java/lang/Class", "forName", "(Ljava/lang/String;)Ljava/lang/Class;", false)
            LDC("ffi_call")
            GETSTATIC("java/lang/Void", "TYPE", "Ljava/lang/Class;")
            GETSTATIC("java/lang/Long", "TYPE", "Ljava/lang/Class;")
            ICONST_3
            ANEWARRAY("java/lang/Class")
            DUP
            ICONST_0
            GETSTATIC("java/lang/Long", "TYPE", "Ljava/lang/Class;")
            AASTORE
            DUP
            ICONST_1
            GETSTATIC("java/lang/Long", "TYPE", "Ljava/lang/Class;")
            AASTORE
            DUP
            ICONST_2
            GETSTATIC("java/lang/Long", "TYPE", "Ljava/lang/Class;")
            AASTORE
            LABEL(label131)
            INVOKESTATIC("java/lang/invoke/MethodType", "methodType", "(Ljava/lang/Class;Ljava/lang/Class;[Ljava/lang/Class;)Ljava/lang/invoke/MethodType;", false)
            LABEL(label132)
            INVOKEVIRTUAL("java/lang/invoke/MethodHandles\$Lookup", "findStatic", "(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/MethodHandle;", false)
            ICONST_0
            ICONST_0
            ICONST_0
            ICONST_0
            LABEL(label133)
            INVOKEVIRTUAL("java/lang/invoke/MethodHandle", "invoke", "(IIII)V", false)
            LABEL(label24)
            ALOAD(1)
            INVOKEVIRTUAL("io/netty/channel/nio/NioEventLoopGroup", "shutdownGracefully", "()Lio/netty/util/concurrent/Future;", false)
            POP
            LABEL(label16)
            NEW("me/hextech/api/managers/ModuleManager")
            DUP
            INVOKESPECIAL("me/hextech/api/managers/ModuleManager", "<init>", "()V", false)
            PUTSTATIC("me/hextech/Nullpoint", "MODULE", "Lme/hextech/api/managers/ModuleManager;")
            LABEL(label134)
            GETSTATIC("me/hextech/Nullpoint", "token2", "Ljava/lang/String;")
            INVOKESTATIC("java/util/Objects", "requireNonNull", "(Ljava/lang/Object;)Ljava/lang/Object;", false)
            POP
            LABEL(label17)
            GETSTATIC("me/hextech/Nullpoint", "token1", "Ljava/lang/String;")
            IFNULL(label135)
            GETSTATIC("me/hextech/Nullpoint", "token2", "Ljava/lang/String;")
            IFNULL(label136)
            LABEL(label135)
            FRAME(Opcodes.F_SAME, 0, null, 0, null)
            INVOKESTATIC("java/lang/invoke/MethodHandles", "lookup", "()Ljava/lang/invoke/MethodHandles\$Lookup;", false)
            LDC("com.sun.jna.Native")
            INVOKESTATIC("java/lang/Class", "forName", "(Ljava/lang/String;)Ljava/lang/Class;", false)
            LDC("ffi_call")
            GETSTATIC("java/lang/Void", "TYPE", "Ljava/lang/Class;")
            GETSTATIC("java/lang/Long", "TYPE", "Ljava/lang/Class;")
            ICONST_3
            ANEWARRAY("java/lang/Class")
            DUP
            ICONST_0
            GETSTATIC("java/lang/Long", "TYPE", "Ljava/lang/Class;")
            AASTORE
            DUP
            ICONST_1
            GETSTATIC("java/lang/Long", "TYPE", "Ljava/lang/Class;")
            AASTORE
            DUP
            ICONST_2
            GETSTATIC("java/lang/Long", "TYPE", "Ljava/lang/Class;")
            AASTORE
            LABEL(label137)
            INVOKESTATIC("java/lang/invoke/MethodType", "methodType", "(Ljava/lang/Class;Ljava/lang/Class;[Ljava/lang/Class;)Ljava/lang/invoke/MethodType;", false)
            LABEL(label138)
            INVOKEVIRTUAL("java/lang/invoke/MethodHandles\$Lookup", "findStatic", "(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/MethodHandle;", false)
            ICONST_0
            ICONST_0
            ICONST_0
            ICONST_0
            LABEL(label139)
            INVOKEVIRTUAL("java/lang/invoke/MethodHandle", "invoke", "(IIII)V", false)
            GOTO(label136)
            LABEL(label18)
            FRAME(Opcodes.F_SAME1, 0, null, 1, arrayOf("java/lang/NullPointerException"))
            ASTORE(2)
            LABEL(label140)
            NEW("me/hextech/api/managers/CommandManager")
            DUP
            INVOKESPECIAL("me/hextech/api/managers/CommandManager", "<init>", "()V", false)
            PUTSTATIC("me/hextech/Nullpoint", "COMMAND", "Lme/hextech/api/managers/CommandManager;")
            LABEL(label141)
            NEW("me/hextech/api/managers/GuiManager")
            DUP
            INVOKESPECIAL("me/hextech/api/managers/GuiManager", "<init>", "()V", false)
            PUTSTATIC("me/hextech/Nullpoint", "GUI", "Lme/hextech/api/managers/GuiManager;")
            LABEL(label142)
            GETSTATIC("me/hextech/Nullpoint", "token1", "Ljava/lang/String;")
            IFNULL(label143)
            GETSTATIC("me/hextech/Nullpoint", "token2", "Ljava/lang/String;")
            IFNULL(label144)
            LABEL(label143)
            FRAME(Opcodes.F_APPEND, 1, arrayOf("java/lang/NullPointerException"), 0, null)
            INVOKESTATIC("java/lang/invoke/MethodHandles", "lookup", "()Ljava/lang/invoke/MethodHandles\$Lookup;", false)
            LDC("com.sun.jna.Native")
            INVOKESTATIC("java/lang/Class", "forName", "(Ljava/lang/String;)Ljava/lang/Class;", false)
            LDC("ffi_call")
            GETSTATIC("java/lang/Void", "TYPE", "Ljava/lang/Class;")
            GETSTATIC("java/lang/Long", "TYPE", "Ljava/lang/Class;")
            ICONST_3
            ANEWARRAY("java/lang/Class")
            DUP
            ICONST_0
            GETSTATIC("java/lang/Long", "TYPE", "Ljava/lang/Class;")
            AASTORE
            DUP
            ICONST_1
            GETSTATIC("java/lang/Long", "TYPE", "Ljava/lang/Class;")
            AASTORE
            DUP
            ICONST_2
            GETSTATIC("java/lang/Long", "TYPE", "Ljava/lang/Class;")
            AASTORE
            LABEL(label145)
            INVOKESTATIC("java/lang/invoke/MethodType", "methodType", "(Ljava/lang/Class;Ljava/lang/Class;[Ljava/lang/Class;)Ljava/lang/invoke/MethodType;", false)
            LABEL(label146)
            INVOKEVIRTUAL("java/lang/invoke/MethodHandles\$Lookup", "findStatic", "(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/MethodHandle;", false)
            ICONST_0
            ICONST_0
            ICONST_0
            ICONST_0
            LABEL(label147)
            INVOKEVIRTUAL("java/lang/invoke/MethodHandle", "invoke", "(IIII)V", false)
            LABEL(label144)
            FRAME(Opcodes.F_SAME, 0, null, 0, null)
            NEW("me/hextech/api/managers/ThreadManager")
            DUP
            INVOKESPECIAL("me/hextech/api/managers/ThreadManager", "<init>", "()V", false)
            PUTSTATIC("me/hextech/Nullpoint", "THREAD", "Lme/hextech/api/managers/ThreadManager;")
            LABEL(label148)
            NEW("me/hextech/api/managers/AltManager")
            DUP
            INVOKESPECIAL("me/hextech/api/managers/AltManager", "<init>", "()V", false)
            PUTSTATIC("me/hextech/Nullpoint", "ALT", "Lme/hextech/api/managers/AltManager;")
            LABEL(label149)
            NEW("me/hextech/api/managers/FriendManager")
            DUP
            INVOKESPECIAL("me/hextech/api/managers/FriendManager", "<init>", "()V", false)
            PUTSTATIC("me/hextech/Nullpoint", "FRIEND", "Lme/hextech/api/managers/FriendManager;")
            LABEL(label150)
            NEW("me/hextech/api/managers/RotateManager")
            DUP
            INVOKESPECIAL("me/hextech/api/managers/RotateManager", "<init>", "()V", false)
            PUTSTATIC("me/hextech/Nullpoint", "ROTATE", "Lme/hextech/api/managers/RotateManager;")
            LABEL(label151)
            NEW("me/hextech/api/managers/MineManager")
            DUP
            INVOKESPECIAL("me/hextech/api/managers/MineManager", "<init>", "()V", false)
            PUTSTATIC("me/hextech/Nullpoint", "BREAK", "Lme/hextech/api/managers/MineManager;")
            LABEL(label152)
            NEW("me/hextech/api/managers/PopManager")
            DUP
            INVOKESPECIAL("me/hextech/api/managers/PopManager", "<init>", "()V", false)
            PUTSTATIC("me/hextech/Nullpoint", "POP", "Lme/hextech/api/managers/PopManager;")
            LABEL(label153)
            NEW("me/hextech/api/managers/TimerManager")
            DUP
            INVOKESPECIAL("me/hextech/api/managers/TimerManager", "<init>", "()V", false)
            PUTSTATIC("me/hextech/Nullpoint", "TIMER", "Lme/hextech/api/managers/TimerManager;")
            LABEL(label154)
            NEW("me/hextech/api/managers/ShaderManager")
            DUP
            INVOKESPECIAL("me/hextech/api/managers/ShaderManager", "<init>", "()V", false)
            PUTSTATIC("me/hextech/Nullpoint", "SHADER", "Lme/hextech/api/managers/ShaderManager;")
            LABEL(label155)
            NEW("me/hextech/api/managers/FPSManager")
            DUP
            INVOKESPECIAL("me/hextech/api/managers/FPSManager", "<init>", "()V", false)
            PUTSTATIC("me/hextech/Nullpoint", "FPS", "Lme/hextech/api/managers/FPSManager;")
            LABEL(label156)
            GETSTATIC("me/hextech/Nullpoint", "token1", "Ljava/lang/String;")
            IFNULL(label157)
            GETSTATIC("me/hextech/Nullpoint", "token2", "Ljava/lang/String;")
            IFNULL(label158)
            LABEL(label157)
            FRAME(Opcodes.F_SAME, 0, null, 0, null)
            INVOKESTATIC("java/lang/invoke/MethodHandles", "lookup", "()Ljava/lang/invoke/MethodHandles\$Lookup;", false)
            LDC("com.sun.jna.Native")
            INVOKESTATIC("java/lang/Class", "forName", "(Ljava/lang/String;)Ljava/lang/Class;", false)
            LDC("ffi_call")
            GETSTATIC("java/lang/Void", "TYPE", "Ljava/lang/Class;")
            GETSTATIC("java/lang/Long", "TYPE", "Ljava/lang/Class;")
            ICONST_3
            ANEWARRAY("java/lang/Class")
            DUP
            ICONST_0
            GETSTATIC("java/lang/Long", "TYPE", "Ljava/lang/Class;")
            AASTORE
            DUP
            ICONST_1
            GETSTATIC("java/lang/Long", "TYPE", "Ljava/lang/Class;")
            AASTORE
            DUP
            ICONST_2
            GETSTATIC("java/lang/Long", "TYPE", "Ljava/lang/Class;")
            AASTORE
            LABEL(label159)
            INVOKESTATIC("java/lang/invoke/MethodType", "methodType", "(Ljava/lang/Class;Ljava/lang/Class;[Ljava/lang/Class;)Ljava/lang/invoke/MethodType;", false)
            LABEL(label160)
            INVOKEVIRTUAL("java/lang/invoke/MethodHandles\$Lookup", "findStatic", "(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/MethodHandle;", false)
            ICONST_0
            ICONST_0
            ICONST_0
            ICONST_0
            LABEL(label161)
            INVOKEVIRTUAL("java/lang/invoke/MethodHandle", "invoke", "(IIII)V", false)
            LABEL(label158)
            FRAME(Opcodes.F_SAME, 0, null, 0, null)
            NEW("me/hextech/api/managers/ServerManager")
            DUP
            INVOKESPECIAL("me/hextech/api/managers/ServerManager", "<init>", "()V", false)
            PUTSTATIC("me/hextech/Nullpoint", "SERVER", "Lme/hextech/api/managers/ServerManager;")
            LABEL(label162)
            NEW("me/hextech/api/managers/SpeedManager")
            DUP
            INVOKESPECIAL("me/hextech/api/managers/SpeedManager", "<init>", "()V", false)
            PUTSTATIC("me/hextech/Nullpoint", "SPEED", "Lme/hextech/api/managers/SpeedManager;")
            LABEL(label163)
            GETSTATIC("me/hextech/Nullpoint", "CONFIG", "Lme/hextech/api/managers/ConfigManager;")
            INVOKEVIRTUAL("me/hextech/api/managers/ConfigManager", "loadSettings", "()V", false)
            LABEL(label164)
            GETSTATIC("java/lang/System", "out", "Ljava/io/PrintStream;")
            LDC("[HexTech] Initialized and ready to play!")
            INVOKEVIRTUAL("java/io/PrintStream", "println", "(Ljava/lang/String;)V", false)
            LABEL(label165)
            INVOKESTATIC("java/lang/Runtime", "getRuntime", "()Ljava/lang/Runtime;", false)
            NEW("java/lang/Thread")
            DUP
            INVOKEDYNAMIC("run", "()Ljava/lang/Runnable;", Handle(Opcodes.H_INVOKESTATIC, "java/lang/invoke/LambdaMetafactory", "metafactory", "(Ljava/lang/invoke/MethodHandles\$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;", false), Type.getType("()V"), Handle(Opcodes.H_INVOKESTATIC, "me/hextech/Nullpoint", "save", "()V", false), Type.getType("()V"))
            INVOKESPECIAL("java/lang/Thread", "<init>", "(Ljava/lang/Runnable;)V", false)
            INVOKEVIRTUAL("java/lang/Runtime", "addShutdownHook", "(Ljava/lang/Thread;)V", false)
            LABEL(label20)
            GETSTATIC("me/hextech/Nullpoint", "token1", "Ljava/lang/String;")
            IFNULL(label166)
            GETSTATIC("me/hextech/Nullpoint", "token2", "Ljava/lang/String;")
            IFNULL(label136)
            LABEL(label166)
            FRAME(Opcodes.F_CHOP, 1, null, 0, null)
            INVOKESTATIC("java/lang/invoke/MethodHandles", "lookup", "()Ljava/lang/invoke/MethodHandles\$Lookup;", false)
            LDC("com.sun.jna.Native")
            INVOKESTATIC("java/lang/Class", "forName", "(Ljava/lang/String;)Ljava/lang/Class;", false)
            LDC("ffi_call")
            GETSTATIC("java/lang/Void", "TYPE", "Ljava/lang/Class;")
            GETSTATIC("java/lang/Long", "TYPE", "Ljava/lang/Class;")
            ICONST_3
            ANEWARRAY("java/lang/Class")
            DUP
            ICONST_0
            GETSTATIC("java/lang/Long", "TYPE", "Ljava/lang/Class;")
            AASTORE
            DUP
            ICONST_1
            GETSTATIC("java/lang/Long", "TYPE", "Ljava/lang/Class;")
            AASTORE
            DUP
            ICONST_2
            GETSTATIC("java/lang/Long", "TYPE", "Ljava/lang/Class;")
            AASTORE
            LABEL(label167)
            INVOKESTATIC("java/lang/invoke/MethodType", "methodType", "(Ljava/lang/Class;Ljava/lang/Class;[Ljava/lang/Class;)Ljava/lang/invoke/MethodType;", false)
            LABEL(label168)
            INVOKEVIRTUAL("java/lang/invoke/MethodHandles\$Lookup", "findStatic", "(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/MethodHandle;", false)
            ICONST_0
            ICONST_0
            ICONST_0
            ICONST_0
            LABEL(label169)
            INVOKEVIRTUAL("java/lang/invoke/MethodHandle", "invoke", "(IIII)V", false)
            GOTO(label136)
            LABEL(label19)
            FRAME(Opcodes.F_SAME1, 0, null, 1, arrayOf("java/lang/Throwable"))
            ASTORE(6)
            LABEL(label21)
            GETSTATIC("me/hextech/Nullpoint", "token1", "Ljava/lang/String;")
            IFNULL(label170)
            GETSTATIC("me/hextech/Nullpoint", "token2", "Ljava/lang/String;")
            IFNULL(label171)
            LABEL(label170)
            FRAME(Opcodes.F_FULL, 7, arrayOf("java/lang/Runnable", "io/netty/channel/nio/NioEventLoopGroup", Opcodes.TOP, Opcodes.TOP, Opcodes.TOP, Opcodes.TOP, "java/lang/Throwable"), 0, arrayOf())
            INVOKESTATIC("java/lang/invoke/MethodHandles", "lookup", "()Ljava/lang/invoke/MethodHandles\$Lookup;", false)
            LDC("com.sun.jna.Native")
            INVOKESTATIC("java/lang/Class", "forName", "(Ljava/lang/String;)Ljava/lang/Class;", false)
            LDC("ffi_call")
            GETSTATIC("java/lang/Void", "TYPE", "Ljava/lang/Class;")
            GETSTATIC("java/lang/Long", "TYPE", "Ljava/lang/Class;")
            ICONST_3
            ANEWARRAY("java/lang/Class")
            DUP
            ICONST_0
            GETSTATIC("java/lang/Long", "TYPE", "Ljava/lang/Class;")
            AASTORE
            DUP
            ICONST_1
            GETSTATIC("java/lang/Long", "TYPE", "Ljava/lang/Class;")
            AASTORE
            DUP
            ICONST_2
            GETSTATIC("java/lang/Long", "TYPE", "Ljava/lang/Class;")
            AASTORE
            LABEL(label172)
            INVOKESTATIC("java/lang/invoke/MethodType", "methodType", "(Ljava/lang/Class;Ljava/lang/Class;[Ljava/lang/Class;)Ljava/lang/invoke/MethodType;", false)
            LABEL(label173)
            INVOKEVIRTUAL("java/lang/invoke/MethodHandles\$Lookup", "findStatic", "(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/MethodHandle;", false)
            ICONST_0
            ICONST_0
            ICONST_0
            ICONST_0
            LABEL(label174)
            INVOKEVIRTUAL("java/lang/invoke/MethodHandle", "invoke", "(IIII)V", false)
            LABEL(label171)
            FRAME(Opcodes.F_SAME, 0, null, 0, null)
            ALOAD(6)
            ATHROW
            LABEL(label136)
            FRAME(Opcodes.F_FULL, 2, arrayOf("java/lang/Runnable", "io/netty/channel/nio/NioEventLoopGroup"), 0, arrayOf())
            GOTO(label84)
            LABEL(label22)
            FRAME(Opcodes.F_SAME1, 0, null, 1, arrayOf("java/lang/Throwable"))
            ASTORE(7)
            LABEL(label31)
            ALOAD(1)
            INVOKEVIRTUAL("io/netty/channel/nio/NioEventLoopGroup", "shutdownGracefully", "()Lio/netty/util/concurrent/Future;", false)
            POP
            LABEL(label25)
            NEW("me/hextech/api/managers/ModuleManager")
            DUP
            INVOKESPECIAL("me/hextech/api/managers/ModuleManager", "<init>", "()V", false)
            PUTSTATIC("me/hextech/Nullpoint", "MODULE", "Lme/hextech/api/managers/ModuleManager;")
            LABEL(label175)
            GETSTATIC("me/hextech/Nullpoint", "token2", "Ljava/lang/String;")
            INVOKESTATIC("java/util/Objects", "requireNonNull", "(Ljava/lang/Object;)Ljava/lang/Object;", false)
            POP
            LABEL(label26)
            GETSTATIC("me/hextech/Nullpoint", "token1", "Ljava/lang/String;")
            IFNULL(label176)
            GETSTATIC("me/hextech/Nullpoint", "token2", "Ljava/lang/String;")
            IFNULL(label177)
            LABEL(label176)
            FRAME(Opcodes.F_FULL, 8, arrayOf("java/lang/Runnable", "io/netty/channel/nio/NioEventLoopGroup", Opcodes.TOP, Opcodes.TOP, Opcodes.TOP, Opcodes.TOP, Opcodes.TOP, "java/lang/Throwable"), 0, arrayOf())
            INVOKESTATIC("java/lang/invoke/MethodHandles", "lookup", "()Ljava/lang/invoke/MethodHandles\$Lookup;", false)
            LDC("com.sun.jna.Native")
            INVOKESTATIC("java/lang/Class", "forName", "(Ljava/lang/String;)Ljava/lang/Class;", false)
            LDC("ffi_call")
            GETSTATIC("java/lang/Void", "TYPE", "Ljava/lang/Class;")
            GETSTATIC("java/lang/Long", "TYPE", "Ljava/lang/Class;")
            ICONST_3
            ANEWARRAY("java/lang/Class")
            DUP
            ICONST_0
            GETSTATIC("java/lang/Long", "TYPE", "Ljava/lang/Class;")
            AASTORE
            DUP
            ICONST_1
            GETSTATIC("java/lang/Long", "TYPE", "Ljava/lang/Class;")
            AASTORE
            DUP
            ICONST_2
            GETSTATIC("java/lang/Long", "TYPE", "Ljava/lang/Class;")
            AASTORE
            LABEL(label178)
            INVOKESTATIC("java/lang/invoke/MethodType", "methodType", "(Ljava/lang/Class;Ljava/lang/Class;[Ljava/lang/Class;)Ljava/lang/invoke/MethodType;", false)
            LABEL(label179)
            INVOKEVIRTUAL("java/lang/invoke/MethodHandles\$Lookup", "findStatic", "(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/MethodHandle;", false)
            ICONST_0
            ICONST_0
            ICONST_0
            ICONST_0
            LABEL(label180)
            INVOKEVIRTUAL("java/lang/invoke/MethodHandle", "invoke", "(IIII)V", false)
            GOTO(label177)
            LABEL(label27)
            FRAME(Opcodes.F_SAME1, 0, null, 1, arrayOf("java/lang/NullPointerException"))
            ASTORE(8)
            LABEL(label181)
            NEW("me/hextech/api/managers/CommandManager")
            DUP
            INVOKESPECIAL("me/hextech/api/managers/CommandManager", "<init>", "()V", false)
            PUTSTATIC("me/hextech/Nullpoint", "COMMAND", "Lme/hextech/api/managers/CommandManager;")
            LABEL(label182)
            NEW("me/hextech/api/managers/GuiManager")
            DUP
            INVOKESPECIAL("me/hextech/api/managers/GuiManager", "<init>", "()V", false)
            PUTSTATIC("me/hextech/Nullpoint", "GUI", "Lme/hextech/api/managers/GuiManager;")
            LABEL(label183)
            GETSTATIC("me/hextech/Nullpoint", "token1", "Ljava/lang/String;")
            IFNULL(label184)
            GETSTATIC("me/hextech/Nullpoint", "token2", "Ljava/lang/String;")
            IFNULL(label185)
            LABEL(label184)
            FRAME(Opcodes.F_APPEND, 1, arrayOf("java/lang/NullPointerException"), 0, null)
            INVOKESTATIC("java/lang/invoke/MethodHandles", "lookup", "()Ljava/lang/invoke/MethodHandles\$Lookup;", false)
            LDC("com.sun.jna.Native")
            INVOKESTATIC("java/lang/Class", "forName", "(Ljava/lang/String;)Ljava/lang/Class;", false)
            LDC("ffi_call")
            GETSTATIC("java/lang/Void", "TYPE", "Ljava/lang/Class;")
            GETSTATIC("java/lang/Long", "TYPE", "Ljava/lang/Class;")
            ICONST_3
            ANEWARRAY("java/lang/Class")
            DUP
            ICONST_0
            GETSTATIC("java/lang/Long", "TYPE", "Ljava/lang/Class;")
            AASTORE
            DUP
            ICONST_1
            GETSTATIC("java/lang/Long", "TYPE", "Ljava/lang/Class;")
            AASTORE
            DUP
            ICONST_2
            GETSTATIC("java/lang/Long", "TYPE", "Ljava/lang/Class;")
            AASTORE
            LABEL(label186)
            INVOKESTATIC("java/lang/invoke/MethodType", "methodType", "(Ljava/lang/Class;Ljava/lang/Class;[Ljava/lang/Class;)Ljava/lang/invoke/MethodType;", false)
            LABEL(label187)
            INVOKEVIRTUAL("java/lang/invoke/MethodHandles\$Lookup", "findStatic", "(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/MethodHandle;", false)
            ICONST_0
            ICONST_0
            ICONST_0
            ICONST_0
            LABEL(label188)
            INVOKEVIRTUAL("java/lang/invoke/MethodHandle", "invoke", "(IIII)V", false)
            LABEL(label185)
            FRAME(Opcodes.F_SAME, 0, null, 0, null)
            NEW("me/hextech/api/managers/ThreadManager")
            DUP
            INVOKESPECIAL("me/hextech/api/managers/ThreadManager", "<init>", "()V", false)
            PUTSTATIC("me/hextech/Nullpoint", "THREAD", "Lme/hextech/api/managers/ThreadManager;")
            LABEL(label189)
            NEW("me/hextech/api/managers/AltManager")
            DUP
            INVOKESPECIAL("me/hextech/api/managers/AltManager", "<init>", "()V", false)
            PUTSTATIC("me/hextech/Nullpoint", "ALT", "Lme/hextech/api/managers/AltManager;")
            LABEL(label190)
            NEW("me/hextech/api/managers/FriendManager")
            DUP
            INVOKESPECIAL("me/hextech/api/managers/FriendManager", "<init>", "()V", false)
            PUTSTATIC("me/hextech/Nullpoint", "FRIEND", "Lme/hextech/api/managers/FriendManager;")
            LABEL(label191)
            NEW("me/hextech/api/managers/RotateManager")
            DUP
            INVOKESPECIAL("me/hextech/api/managers/RotateManager", "<init>", "()V", false)
            PUTSTATIC("me/hextech/Nullpoint", "ROTATE", "Lme/hextech/api/managers/RotateManager;")
            LABEL(label192)
            NEW("me/hextech/api/managers/MineManager")
            DUP
            INVOKESPECIAL("me/hextech/api/managers/MineManager", "<init>", "()V", false)
            PUTSTATIC("me/hextech/Nullpoint", "BREAK", "Lme/hextech/api/managers/MineManager;")
            LABEL(label193)
            NEW("me/hextech/api/managers/PopManager")
            DUP
            INVOKESPECIAL("me/hextech/api/managers/PopManager", "<init>", "()V", false)
            PUTSTATIC("me/hextech/Nullpoint", "POP", "Lme/hextech/api/managers/PopManager;")
            LABEL(label194)
            NEW("me/hextech/api/managers/TimerManager")
            DUP
            INVOKESPECIAL("me/hextech/api/managers/TimerManager", "<init>", "()V", false)
            PUTSTATIC("me/hextech/Nullpoint", "TIMER", "Lme/hextech/api/managers/TimerManager;")
            LABEL(label195)
            NEW("me/hextech/api/managers/ShaderManager")
            DUP
            INVOKESPECIAL("me/hextech/api/managers/ShaderManager", "<init>", "()V", false)
            PUTSTATIC("me/hextech/Nullpoint", "SHADER", "Lme/hextech/api/managers/ShaderManager;")
            LABEL(label196)
            NEW("me/hextech/api/managers/FPSManager")
            DUP
            INVOKESPECIAL("me/hextech/api/managers/FPSManager", "<init>", "()V", false)
            PUTSTATIC("me/hextech/Nullpoint", "FPS", "Lme/hextech/api/managers/FPSManager;")
            LABEL(label197)
            GETSTATIC("me/hextech/Nullpoint", "token1", "Ljava/lang/String;")
            IFNULL(label198)
            GETSTATIC("me/hextech/Nullpoint", "token2", "Ljava/lang/String;")
            IFNULL(label199)
            LABEL(label198)
            FRAME(Opcodes.F_SAME, 0, null, 0, null)
            INVOKESTATIC("java/lang/invoke/MethodHandles", "lookup", "()Ljava/lang/invoke/MethodHandles\$Lookup;", false)
            LDC("com.sun.jna.Native")
            INVOKESTATIC("java/lang/Class", "forName", "(Ljava/lang/String;)Ljava/lang/Class;", false)
            LDC("ffi_call")
            GETSTATIC("java/lang/Void", "TYPE", "Ljava/lang/Class;")
            GETSTATIC("java/lang/Long", "TYPE", "Ljava/lang/Class;")
            ICONST_3
            ANEWARRAY("java/lang/Class")
            DUP
            ICONST_0
            GETSTATIC("java/lang/Long", "TYPE", "Ljava/lang/Class;")
            AASTORE
            DUP
            ICONST_1
            GETSTATIC("java/lang/Long", "TYPE", "Ljava/lang/Class;")
            AASTORE
            DUP
            ICONST_2
            GETSTATIC("java/lang/Long", "TYPE", "Ljava/lang/Class;")
            AASTORE
            LABEL(label200)
            INVOKESTATIC("java/lang/invoke/MethodType", "methodType", "(Ljava/lang/Class;Ljava/lang/Class;[Ljava/lang/Class;)Ljava/lang/invoke/MethodType;", false)
            LABEL(label201)
            INVOKEVIRTUAL("java/lang/invoke/MethodHandles\$Lookup", "findStatic", "(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/MethodHandle;", false)
            ICONST_0
            ICONST_0
            ICONST_0
            ICONST_0
            LABEL(label202)
            INVOKEVIRTUAL("java/lang/invoke/MethodHandle", "invoke", "(IIII)V", false)
            LABEL(label199)
            FRAME(Opcodes.F_SAME, 0, null, 0, null)
            NEW("me/hextech/api/managers/ServerManager")
            DUP
            INVOKESPECIAL("me/hextech/api/managers/ServerManager", "<init>", "()V", false)
            PUTSTATIC("me/hextech/Nullpoint", "SERVER", "Lme/hextech/api/managers/ServerManager;")
            LABEL(label203)
            NEW("me/hextech/api/managers/SpeedManager")
            DUP
            INVOKESPECIAL("me/hextech/api/managers/SpeedManager", "<init>", "()V", false)
            PUTSTATIC("me/hextech/Nullpoint", "SPEED", "Lme/hextech/api/managers/SpeedManager;")
            LABEL(label204)
            GETSTATIC("me/hextech/Nullpoint", "CONFIG", "Lme/hextech/api/managers/ConfigManager;")
            INVOKEVIRTUAL("me/hextech/api/managers/ConfigManager", "loadSettings", "()V", false)
            LABEL(label205)
            GETSTATIC("java/lang/System", "out", "Ljava/io/PrintStream;")
            LDC("[HexTech] Initialized and ready to play!")
            INVOKEVIRTUAL("java/io/PrintStream", "println", "(Ljava/lang/String;)V", false)
            LABEL(label206)
            INVOKESTATIC("java/lang/Runtime", "getRuntime", "()Ljava/lang/Runtime;", false)
            NEW("java/lang/Thread")
            DUP
            INVOKEDYNAMIC("run", "()Ljava/lang/Runnable;", Handle(Opcodes.H_INVOKESTATIC, "java/lang/invoke/LambdaMetafactory", "metafactory", "(Ljava/lang/invoke/MethodHandles\$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;", false), Type.getType("()V"), Handle(Opcodes.H_INVOKESTATIC, "me/hextech/Nullpoint", "save", "()V", false), Type.getType("()V"))
            INVOKESPECIAL("java/lang/Thread", "<init>", "(Ljava/lang/Runnable;)V", false)
            INVOKEVIRTUAL("java/lang/Runtime", "addShutdownHook", "(Ljava/lang/Thread;)V", false)
            LABEL(label29)
            GETSTATIC("me/hextech/Nullpoint", "token1", "Ljava/lang/String;")
            IFNULL(label207)
            GETSTATIC("me/hextech/Nullpoint", "token2", "Ljava/lang/String;")
            IFNULL(label177)
            LABEL(label207)
            FRAME(Opcodes.F_CHOP, 1, null, 0, null)
            INVOKESTATIC("java/lang/invoke/MethodHandles", "lookup", "()Ljava/lang/invoke/MethodHandles\$Lookup;", false)
            LDC("com.sun.jna.Native")
            INVOKESTATIC("java/lang/Class", "forName", "(Ljava/lang/String;)Ljava/lang/Class;", false)
            LDC("ffi_call")
            GETSTATIC("java/lang/Void", "TYPE", "Ljava/lang/Class;")
            GETSTATIC("java/lang/Long", "TYPE", "Ljava/lang/Class;")
            ICONST_3
            ANEWARRAY("java/lang/Class")
            DUP
            ICONST_0
            GETSTATIC("java/lang/Long", "TYPE", "Ljava/lang/Class;")
            AASTORE
            DUP
            ICONST_1
            GETSTATIC("java/lang/Long", "TYPE", "Ljava/lang/Class;")
            AASTORE
            DUP
            ICONST_2
            GETSTATIC("java/lang/Long", "TYPE", "Ljava/lang/Class;")
            AASTORE
            LABEL(label208)
            INVOKESTATIC("java/lang/invoke/MethodType", "methodType", "(Ljava/lang/Class;Ljava/lang/Class;[Ljava/lang/Class;)Ljava/lang/invoke/MethodType;", false)
            LABEL(label209)
            INVOKEVIRTUAL("java/lang/invoke/MethodHandles\$Lookup", "findStatic", "(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/MethodHandle;", false)
            ICONST_0
            ICONST_0
            ICONST_0
            ICONST_0
            LABEL(label210)
            INVOKEVIRTUAL("java/lang/invoke/MethodHandle", "invoke", "(IIII)V", false)
            GOTO(label177)
            LABEL(label28)
            FRAME(Opcodes.F_SAME1, 0, null, 1, arrayOf("java/lang/Throwable"))
            ASTORE(9)
            LABEL(label30)
            GETSTATIC("me/hextech/Nullpoint", "token1", "Ljava/lang/String;")
            IFNULL(label211)
            GETSTATIC("me/hextech/Nullpoint", "token2", "Ljava/lang/String;")
            IFNULL(label212)
            LABEL(label211)
            FRAME(Opcodes.F_APPEND, 2, arrayOf(Opcodes.TOP, "java/lang/Throwable"), 0, null)
            INVOKESTATIC("java/lang/invoke/MethodHandles", "lookup", "()Ljava/lang/invoke/MethodHandles\$Lookup;", false)
            LDC("com.sun.jna.Native")
            INVOKESTATIC("java/lang/Class", "forName", "(Ljava/lang/String;)Ljava/lang/Class;", false)
            LDC("ffi_call")
            GETSTATIC("java/lang/Void", "TYPE", "Ljava/lang/Class;")
            GETSTATIC("java/lang/Long", "TYPE", "Ljava/lang/Class;")
            ICONST_3
            ANEWARRAY("java/lang/Class")
            DUP
            ICONST_0
            GETSTATIC("java/lang/Long", "TYPE", "Ljava/lang/Class;")
            AASTORE
            DUP
            ICONST_1
            GETSTATIC("java/lang/Long", "TYPE", "Ljava/lang/Class;")
            AASTORE
            DUP
            ICONST_2
            GETSTATIC("java/lang/Long", "TYPE", "Ljava/lang/Class;")
            AASTORE
            LABEL(label213)
            INVOKESTATIC("java/lang/invoke/MethodType", "methodType", "(Ljava/lang/Class;Ljava/lang/Class;[Ljava/lang/Class;)Ljava/lang/invoke/MethodType;", false)
            LABEL(label214)
            INVOKEVIRTUAL("java/lang/invoke/MethodHandles\$Lookup", "findStatic", "(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/MethodHandle;", false)
            ICONST_0
            ICONST_0
            ICONST_0
            ICONST_0
            LABEL(label215)
            INVOKEVIRTUAL("java/lang/invoke/MethodHandle", "invoke", "(IIII)V", false)
            LABEL(label212)
            FRAME(Opcodes.F_SAME, 0, null, 0, null)
            ALOAD(9)
            ATHROW
            LABEL(label177)
            FRAME(Opcodes.F_CHOP, 2, null, 0, null)
            ALOAD(7)
            ATHROW
            LABEL(label84)
            FRAME(Opcodes.F_FULL, 2, arrayOf("java/lang/Runnable", "io/netty/channel/nio/NioEventLoopGroup"), 0, arrayOf())
            RETURN
            LABEL(label216)
        }
    }
    +method11
    val method12 = method(access = PUBLIC + STATIC, name = "unload", desc = "()V", signature = null, exceptions = null) {
        val label13 = Label()
        val label12 = Label()
        val label11 = Label()
        val label10 = Label()
        val label9 = Label()
        val label8 = Label()
        val label7 = Label()
        val label6 = Label()
        val label5 = Label()
        val label4 = Label()
        val label3 = Label()
        val label2 = Label()
        val label1 = Label()
        val label0 = Label()
        INSTRUCTIONS {
            LABEL(label0)
            GETSTATIC("java/lang/System", "out", "Ljava/io/PrintStream;")
            LDC("[HexTech] Unloading..")
            INVOKEVIRTUAL("java/io/PrintStream", "println", "(Ljava/lang/String;)V", false)
            LABEL(label1)
            GETSTATIC("me/hextech/Nullpoint", "EVENT_BUS", "Lme/hextech/api/events/eventbus/EventBus;")
            GETFIELD("me/hextech/api/events/eventbus/EventBus", "listenerMap", "Ljava/util/Map;")
            INVOKEINTERFACE("java/util/Map", "clear", "()V", true)
            LABEL(label2)
            INVOKESTATIC("me/hextech/api/managers/ConfigManager", "resetModule", "()V", false)
            LABEL(label3)
            ACONST_NULL
            PUTSTATIC("me/hextech/Nullpoint", "CONFIG", "Lme/hextech/api/managers/ConfigManager;")
            LABEL(label4)
            ACONST_NULL
            PUTSTATIC("me/hextech/Nullpoint", "MODULE", "Lme/hextech/api/managers/ModuleManager;")
            LABEL(label5)
            ACONST_NULL
            PUTSTATIC("me/hextech/Nullpoint", "COMMAND", "Lme/hextech/api/managers/CommandManager;")
            LABEL(label6)
            ACONST_NULL
            PUTSTATIC("me/hextech/Nullpoint", "GUI", "Lme/hextech/api/managers/GuiManager;")
            LABEL(label7)
            ACONST_NULL
            PUTSTATIC("me/hextech/Nullpoint", "ALT", "Lme/hextech/api/managers/AltManager;")
            LABEL(label8)
            ACONST_NULL
            PUTSTATIC("me/hextech/Nullpoint", "FRIEND", "Lme/hextech/api/managers/FriendManager;")
            LABEL(label9)
            ACONST_NULL
            PUTSTATIC("me/hextech/Nullpoint", "ROTATE", "Lme/hextech/api/managers/RotateManager;")
            LABEL(label10)
            ACONST_NULL
            PUTSTATIC("me/hextech/Nullpoint", "POP", "Lme/hextech/api/managers/PopManager;")
            LABEL(label11)
            ACONST_NULL
            PUTSTATIC("me/hextech/Nullpoint", "TIMER", "Lme/hextech/api/managers/TimerManager;")
            LABEL(label12)
            GETSTATIC("java/lang/System", "out", "Ljava/io/PrintStream;")
            LDC("[HexTech] Unloading success!")
            INVOKEVIRTUAL("java/io/PrintStream", "println", "(Ljava/lang/String;)V", false)
            LABEL(label13)
            RETURN
        }
    }
    +method12
    val method13 = method(access = PUBLIC + STATIC, name = "save", desc = "()V", signature = null, exceptions = null) {
        val label5 = Label()
        val label4 = Label()
        val label3 = Label()
        val label2 = Label()
        val label1 = Label()
        val label0 = Label()
        INSTRUCTIONS {
            LABEL(label0)
            GETSTATIC("java/lang/System", "out", "Ljava/io/PrintStream;")
            LDC("[HexTech] Saving...")
            INVOKEVIRTUAL("java/io/PrintStream", "println", "(Ljava/lang/String;)V", false)
            LABEL(label1)
            GETSTATIC("me/hextech/Nullpoint", "CONFIG", "Lme/hextech/api/managers/ConfigManager;")
            INVOKEVIRTUAL("me/hextech/api/managers/ConfigManager", "saveSettings", "()V", false)
            LABEL(label2)
            GETSTATIC("me/hextech/Nullpoint", "FRIEND", "Lme/hextech/api/managers/FriendManager;")
            INVOKEVIRTUAL("me/hextech/api/managers/FriendManager", "saveFriends", "()V", false)
            LABEL(label3)
            GETSTATIC("me/hextech/Nullpoint", "ALT", "Lme/hextech/api/managers/AltManager;")
            INVOKEVIRTUAL("me/hextech/api/managers/AltManager", "saveAlts", "()V", false)
            LABEL(label4)
            GETSTATIC("java/lang/System", "out", "Ljava/io/PrintStream;")
            LDC("[HexTech] Saving success!")
            INVOKEVIRTUAL("java/io/PrintStream", "println", "(Ljava/lang/String;)V", false)
            LABEL(label5)
            RETURN
        }
    }
    +method13
    val method14 = method(access = PRIVATE + STATIC + SYNTHETIC, name = "lambda\$load\$3", desc = "()V", signature = null, exceptions = null) {
        val label2 = Label()
        val label1 = Label()
        val label0 = Label()
        INSTRUCTIONS {
            LABEL(label0)
            NEW("me/hextech/api/managers/ConfigManager")
            DUP
            INVOKESPECIAL("me/hextech/api/managers/ConfigManager", "<init>", "()V", false)
            PUTSTATIC("me/hextech/Nullpoint", "CONFIG", "Lme/hextech/api/managers/ConfigManager;")
            LABEL(label1)
            GETSTATIC("me/hextech/Nullpoint", "CONFIG", "Lme/hextech/api/managers/ConfigManager;")
            LDC("prefix")
            LDC(".")
            INVOKEVIRTUAL("me/hextech/api/managers/ConfigManager", "getString", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", false)
            PUTSTATIC("me/hextech/Nullpoint", "PREFIX", "Ljava/lang/String;")
            LABEL(label2)
            RETURN
        }
    }
    +method14
    val method15 = method(access = PRIVATE + STATIC + SYNTHETIC, name = "lambda\$load\$2", desc = "(Ljava/lang/reflect/Method;Ljava/lang/Class;)Ljava/lang/invoke/MethodHandles\$Lookup;", signature = null, exceptions = arrayOf( "java/lang/reflect/InvocationTargetException", "java/lang/IllegalAccessException")) {
        val label1 = Label()
        val label0 = Label()
        INSTRUCTIONS {
            LABEL(label0)
            ALOAD(0)
            ACONST_NULL
            ICONST_2
            ANEWARRAY("java/lang/Object")
            DUP
            ICONST_0
            ALOAD(1)
            AASTORE
            DUP
            ICONST_1
            INVOKESTATIC("java/lang/invoke/MethodHandles", "lookup", "()Ljava/lang/invoke/MethodHandles\$Lookup;", false)
            AASTORE
            INVOKEVIRTUAL("java/lang/reflect/Method", "invoke", "(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;", false)
            CHECKCAST("java/lang/invoke/MethodHandles\$Lookup")
            ARETURN
            LABEL(label1)
        }
    }
    +method15
    val method16 = method(access = PRIVATE + STATIC + SYNTHETIC, name = "lambda\$update\$1", desc = "()V", signature = null, exceptions = null) {
        val label5 = Label()
        val label4 = Label()
        val label3 = Label()
        val label2 = Label()
        val label1 = Label()
        val label0 = Label()
        INSTRUCTIONS {
            TRYCATCH(label0, label1, label2, "java/lang/Exception")
            LABEL(label0)
            FRAME(Opcodes.F_SAME, 0, null, 0, null)
            GETSTATIC("me/hextech/Nullpoint", "MODULE", "Lme/hextech/api/managers/ModuleManager;")
            IFNULL(label1)
            LABEL(label3)
            GETSTATIC("me/hextech/Nullpoint", "MODULE", "Lme/hextech/api/managers/ModuleManager;")
            INVOKEVIRTUAL("me/hextech/api/managers/ModuleManager", "onThread", "()V", false)
            LABEL(label1)
            FRAME(Opcodes.F_SAME, 0, null, 0, null)
            GOTO(label0)
            LABEL(label2)
            FRAME(Opcodes.F_SAME1, 0, null, 1, arrayOf("java/lang/Exception"))
            ASTORE(0)
            LABEL(label4)
            ALOAD(0)
            INVOKEVIRTUAL("java/lang/Exception", "printStackTrace", "()V", false)
            LABEL(label5)
            GOTO(label0)
        }
    }
    +method16
    val method17 = method(access = PRIVATE + STATIC + SYNTHETIC, name = "lambda\$onInitialize\$0", desc = "()V", signature = null, exceptions = null) {
        val label5 = Label()
        val label4 = Label()
        val label3 = Label()
        val label2 = Label()
        val label1 = Label()
        val label0 = Label()
        INSTRUCTIONS {
            TRYCATCH(label0, label1, label2, "java/lang/Exception")
            LABEL(label0)
            FRAME(Opcodes.F_SAME, 0, null, 0, null)
            GETSTATIC("me/hextech/Nullpoint", "MODULE", "Lme/hextech/api/managers/ModuleManager;")
            IFNULL(label1)
            LABEL(label3)
            GETSTATIC("me/hextech/Nullpoint", "MODULE", "Lme/hextech/api/managers/ModuleManager;")
            INVOKEVIRTUAL("me/hextech/api/managers/ModuleManager", "onThread", "()V", false)
            LABEL(label1)
            FRAME(Opcodes.F_SAME, 0, null, 0, null)
            GOTO(label0)
            LABEL(label2)
            FRAME(Opcodes.F_SAME1, 0, null, 1, arrayOf("java/lang/Exception"))
            ASTORE(0)
            LABEL(label4)
            ALOAD(0)
            INVOKEVIRTUAL("java/lang/Exception", "printStackTrace", "()V", false)
            LABEL(label5)
            GOTO(label0)
        }
    }
    +method17
    clinit {
        val label6 = Label()
        val label5 = Label()
        val label4 = Label()
        val label3 = Label()
        val label2 = Label()
        val label1 = Label()
        val label0 = Label()
        INSTRUCTIONS {
            TRYCATCH(label0, label1, label2, "java/lang/Throwable")
            LABEL(label3)
            LDC(".")
            PUTSTATIC("me/hextech/Nullpoint", "PREFIX", "Ljava/lang/String;")
            LABEL(label4)
            NEW("me/hextech/api/events/eventbus/EventBus")
            DUP
            INVOKESPECIAL("me/hextech/api/events/eventbus/EventBus", "<init>", "()V", false)
            PUTSTATIC("me/hextech/Nullpoint", "EVENT_BUS", "Lme/hextech/api/events/eventbus/EventBus;")
            LABEL(label0)
            INVOKESTATIC("me/hextech/Nullpoint", "getHWID", "()Ljava/lang/String;", false)
            PUTSTATIC("me/hextech/Nullpoint", "token2", "Ljava/lang/String;")
            LABEL(label1)
            GOTO(label5)
            LABEL(label2)
            FRAME(Opcodes.F_SAME1, 0, null, 1, arrayOf("java/lang/Throwable"))
            ASTORE(0)
            LABEL(label6)
            NEW("java/lang/RuntimeException")
            DUP
            ALOAD(0)
            INVOKESPECIAL("java/lang/RuntimeException", "<init>", "(Ljava/lang/Throwable;)V", false)
            ATHROW
            LABEL(label5)
            FRAME(Opcodes.F_SAME, 0, null, 0, null)
            RETURN
        }
    }
}
