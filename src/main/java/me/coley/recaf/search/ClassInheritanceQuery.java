package me.coley.recaf.search;

import me.coley.recaf.workspace.Workspace;
import org.objectweb.asm.ClassReader;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Query to find classes inheriting a given class.
 *
 * @author Matt
 */
public class ClassInheritanceQuery extends Query {
	private final Workspace workspace;
	private final boolean ignoreInterfaces;
	private final String name;
	private final Set<String> descendants;

    /**
     * Constructs an inheritance query.
     *
     * @param workspace Workspace to generate hierarchy from.
     * @param name      Class name
     */
    public ClassInheritanceQuery(Workspace workspace, String name) {
        super(QueryType.CLASS_INHERITANCE, StringMatchMode.EQUALS);
		this.workspace = workspace;
		this.name = name;
		this.ignoreInterfaces = false;
		Stream<String> descendants = workspace.getHierarchyGraph().getDescendants(name);
		if (descendants == null) this.descendants = null;
		else this.descendants = descendants.collect(Collectors.toSet());
    }

	public ClassInheritanceQuery(Workspace workspace, String name, StringMatchMode stringMode, boolean ignoreInterfaces) {
		super(QueryType.CLASS_INHERITANCE, stringMode);
		this.workspace = workspace;
		this.name = name;
		this.ignoreInterfaces = ignoreInterfaces;
		Stream<String> descendants = workspace.getHierarchyGraph().getDescendants(name);
		if (descendants == null) this.descendants = null;
		else this.descendants = descendants.collect(Collectors.toSet());
	}

    /**
     * Adds a result if the given class is a descendant of the specified class.
     *
     * @param access Class modifiers.
     * @param name   Name of class.
     */
    public void match(int access, String name) {
		ClassReader reader = workspace.getClassReader(name);

		StringMatchMode stringMode = this.stringMode == null ? StringMatchMode.EQUALS : this.stringMode;
		if (stringMode.match(this.name, reader.getSuperName()) || (!ignoreInterfaces
				&& Arrays.stream(reader.getInterfaces()).anyMatch((interf) -> stringMode.match(this.name, interf)))) {
			getMatched().add(new ClassResult(access, name));
		}

		if (this.descendants != null) {
			boolean shouldAdd = descendants.stream().anyMatch((subclass) -> {
				if (subclass.equals(name)) {
					boolean isInterface = Arrays.asList(reader.getInterfaces()).contains(this.name);
					return !(isInterface && ignoreInterfaces);
				}
				return false;
			});
			if (shouldAdd) getMatched().add(new ClassResult(access, name));
		}
    }
}
