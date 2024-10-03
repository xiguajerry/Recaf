package me.coley.recaf.decompile.vineflower;

import me.coley.recaf.Recaf;
import me.coley.recaf.config.ConfDecompile;
import me.coley.recaf.control.Controller;
import me.coley.recaf.decompile.Decompiler;
import me.coley.recaf.util.ClassUtil;
import me.coley.recaf.workspace.Workspace;
import org.jetbrains.java.decompiler.main.Fernflower;
import org.jetbrains.java.decompiler.main.extern.IFernflowerPreferences;
import org.jetbrains.java.decompiler.main.extern.IResultSaver;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.tree.ClassNode;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.jetbrains.java.decompiler.main.extern.IFernflowerPreferences.*;

public class VineFlowerDecompiler extends Decompiler<Object> {
    private DummyResultSaver dummySaver = new DummyResultSaver();
    private VineflowerLogger logger = new VineflowerLogger();

    /**
     * Initialize the decompiler wrapper.
     *
     * @param controller Controller with configuration to pull from and the workspace to pull classes from.
     */
    public VineFlowerDecompiler(Controller controller) {
        super(controller);
    }

    @Override
    protected Map<String, Object> generateDefaultOptions() {
        return IFernflowerPreferences.getDefaults();
    }

    @Override
    public String decompile(String name) {
        Map<String, Object> options = new HashMap<>(generateDefaultOptions());
        ConfDecompile confDecompile = Recaf.getController().config().decompile();
        options.put(REMOVE_BRIDGE, convertBoolean(confDecompile.vfRemoveBridge));
        options.put(REMOVE_SYNTHETIC, convertBoolean(confDecompile.vfRemoveSynthetic));
        options.put(DECOMPILE_INNER, convertBoolean(confDecompile.vfDecompileInner));
        options.put(DECOMPILE_CLASS_1_4, convertBoolean(confDecompile.vfDecompileClass1_4));
        options.put(DECOMPILE_ASSERTIONS, convertBoolean(confDecompile.vfDecompileAssertions));
        options.put(HIDE_EMPTY_SUPER, convertBoolean(confDecompile.vfHideEmptySuper));
        options.put(HIDE_DEFAULT_CONSTRUCTOR, convertBoolean(confDecompile.vfHideDefaultConstructor));
        options.put(DECOMPILE_GENERIC_SIGNATURES, convertBoolean(confDecompile.vfDecompileGenericSignatures));
        options.put(INCORPORATE_RETURNS, convertBoolean(confDecompile.vfIncorporateReturns));
        Fernflower fernflower = new Fernflower(dummySaver, options, logger);

        try {
            Workspace workspace = Recaf.getCurrentWorkspace();
            byte[] data = workspace.getRawClass(name);
            ClassReader reader = new ClassReader(data);
            ClassNode classNode = new ClassNode();
            reader.accept(classNode, ClassReader.SKIP_FRAMES);
            ClassSource source = new ClassSource(workspace, classNode, data);
            fernflower.addSource(source);
            fernflower.addLibrary(new LibrarySource(workspace,  classNode, data));
            fernflower.decompileContext();

            String decompiled = source.getSink().getDecompiledOutput().get();

            if (decompiled == null || decompiled.isEmpty()) {
                return "// VF: Failed to decompile class";
            }

            return decompiled;
        } catch (Exception e) {
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            e.printStackTrace(printWriter);
            return "// VF: Failed to decompile class: " + e + "\n" + stringWriter;
        }
    }

    private String convertBoolean(boolean v) {
        return v ? "1" : "0";
    }
}
