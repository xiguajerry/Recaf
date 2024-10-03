package me.coley.recaf.decompile.vineflower;

import me.coley.recaf.workspace.Workspace;
import org.jetbrains.java.decompiler.main.extern.IResultSaver;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.InnerClassNode;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Single class source for Vineflower.
 *
 * @author Matt Coley
 * @author therathatter
 */
public class ClassSource extends BaseSource {
	private final DecompiledOutputSink sink;

	/**
	 * @param workspace
	 * 		Workspace to pull class files from.
	 * @param targetInfo
	 * 		Target class to decompile.
	 */
	protected ClassSource(@Nonnull Workspace workspace, @Nonnull ClassNode targetInfo, byte[] classBytes) {
		super(workspace, targetInfo, classBytes);
		sink = new DecompiledOutputSink(targetInfo);
	}

	/**
	 * @return Output which holds the decompilation result after the decompilation task completes.
	 */
	@Nonnull
	protected DecompiledOutputSink getSink() {
		return sink;
	}

	@Override
	public Entries getEntries() {
		// TODO: Bug in QF/VF makes it so that 'addLibrary' doesn't yield inner info for a class provided with 'addSource'
		//  So for now until this is fixed upstream we will also supply inners here.
		//  This will make QF/VF decompile each inner class separately as well, but its the best fix for now without
		//  too much of a perf hit.
		List<Entry> entries = new ArrayList<>();
		entries.add(new Entry(targetInfo.name, Entry.BASE_VERSION));
		for (InnerClassNode innerClass : targetInfo.innerClasses) {
			// Only add entry if it exists in the workspace.
			if (workspace.getRawClass(innerClass.name) != null)
				entries.add(new Entry(innerClass.name, Entry.BASE_VERSION));
		}
		return new Entries(entries, Collections.emptyList(), Collections.emptyList());
	}

	@Override
	public IOutputSink createOutputSink(IResultSaver saver) {
		return sink;
	}
}