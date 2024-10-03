package me.coley.recaf.decompile.vineflower;

import me.coley.recaf.workspace.Workspace;
import org.objectweb.asm.tree.ClassNode;

import javax.annotation.Nonnull;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Full library source for Vineflower.
 *
 * @author Matt Coley
 * @author therathatter
 */
public class LibrarySource extends BaseSource {
	/**
	 * @param workspace
	 * 		Workspace to pull class files from.
	 * @param targetInfo
	 * 		Target class to decompile.
	 */
	protected LibrarySource(@Nonnull Workspace workspace, @Nonnull ClassNode targetInfo, byte[] classBytes) {
		super(workspace, targetInfo, classBytes);
	}

	@Override
	public Entries getEntries() {
		List<Entry> entries = workspace.getLibraryClassNames().stream()
				.map(className -> new Entry(className, Entry.BASE_VERSION))
				.collect(Collectors.toList());
		return new Entries(entries, Collections.emptyList(), Collections.emptyList());
	}
}