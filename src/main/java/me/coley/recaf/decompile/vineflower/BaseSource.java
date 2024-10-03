package me.coley.recaf.decompile.vineflower;

import me.coley.recaf.workspace.Workspace;
import org.jetbrains.java.decompiler.main.extern.IContextSource;
import org.objectweb.asm.tree.ClassNode;

import javax.annotation.Nonnull;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * Base Vineflower class/library source.
 *
 * @author therathatter
 */
public abstract class BaseSource implements IContextSource {
	protected final Workspace workspace;
	protected final ClassNode targetInfo;
	protected final byte[] classBytes;

	/**
	 * @param workspace
	 * 		Workspace to pull class files from.
	 * @param targetInfo
	 * 		Target class to decompile.
	 */
	protected BaseSource(@Nonnull Workspace workspace, @Nonnull ClassNode targetInfo, byte[] classBytes) {
		this.workspace = workspace;
		this.targetInfo = targetInfo;
		this.classBytes = classBytes;
	}

	@Override
	public String getName() {
		return "Recaf";
	}

	@Override
	public InputStream getInputStream(String resource) {
		String name = resource.substring(0, resource.length() - IContextSource.CLASS_SUFFIX.length());
		if (name.equals(targetInfo.name))
			return new ByteArrayInputStream(classBytes);

		byte[] node = workspace.getRawClass(name);
		if (node == null) return null; // VF wants missing data to be null here, not an IOException or empty stream.
		return new ByteArrayInputStream(node);
	}
}