package me.coley.recaf.ui.controls.tree;

import com.google.common.base.Preconditions;
import com.google.common.base.Predicates;
import me.coley.recaf.Recaf;
import me.coley.recaf.control.Controller;
import me.coley.recaf.util.fabric.FabricEntrypoints;
import me.coley.recaf.workspace.JavaResource;
import org.apache.commons.lang3.StringEscapeUtils;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.AnnotationNode;
import org.objectweb.asm.tree.ClassNode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Item to represent classes.
 *
 * @author Matt
 */
public class ClassItem extends DirectoryItem {
	private final String name;
	private final ClassReader reader;
	private final ClassNode classNode;
	private final boolean isMixinClass;
	private final Set<String> mixinTargetClasses;
	private final boolean isFabricEntrypoint;
	private final Set<String> entrypointTypes;

	/**
	 * @param resource
	 * 		The resource associated with the item.
	 * @param local
	 * 		Local item name.
	 * @param name
	 * 		Full class name.
	 */
	public ClassItem(JavaResource resource, String local, String name) {
		super(resource, local);
		this.name = name;
		this.reader = new ClassReader(resource.getClasses().get(name));
		this.classNode = new ClassNode();
		reader.accept(classNode, ClassReader.SKIP_FRAMES);

		// search annotations
		String escapedName = StringEscapeUtils.escapeJava(super.getLocalName());

		Set<AnnotationNode> mergedAnnotations = new HashSet<>();
		if (classNode.visibleAnnotations != null) {
			mergedAnnotations.addAll(classNode.visibleAnnotations);
		}
		if (classNode.invisibleAnnotations != null) {
			mergedAnnotations.addAll(classNode.invisibleAnnotations);
		}
		checkMixinClass: {
			if (!mergedAnnotations.isEmpty()) {
				Set<AnnotationNode> mixinNodes = mergedAnnotations.stream()
						.filter(annotationNode -> "Lorg/spongepowered/asm/mixin/Mixin;".equals(annotationNode.desc))
						.collect(Collectors.toSet());
				if (!mixinNodes.isEmpty()) {
					Preconditions.checkState(mixinNodes.size() == 1,
							"Find multiple @Mixin annotations in class " + escapedName);
					AnnotationNode mixinNode = mixinNodes.stream().findFirst().get();
					List<Object> annotationArgs = mixinNode.values;
					Preconditions.checkState(annotationArgs.size() % 2 == 0,
							"Find odd arguments in @Mixin annotations, in class " + escapedName);
					Set<String> targetClasses = new HashSet<>();
					if (annotationArgs.size() == 2) {
						String firstLabel = (String) annotationArgs.get(0);
						if ("value".equals(firstLabel)) {
							List<Type> classes = (List<Type>) annotationArgs.get(1);
							targetClasses.addAll(classes.stream().map(Type::getClassName).collect(Collectors.toSet()));
						} else if ("targets".equals(firstLabel)) {
							targetClasses.addAll((List<String>) annotationArgs.get(1));
						}
					} else if (annotationArgs.size() == 4) {
						String firstLabel = (String) annotationArgs.get(0);
						String secondLabel = (String) annotationArgs.get(2);
						if ("value".equals(firstLabel)) {
							List<Type> classes = (List<Type>) annotationArgs.get(1);
							targetClasses.addAll(classes.stream().map(Type::getClassName).collect(Collectors.toSet()));
						} else if ("targets".equals(firstLabel)) {
							targetClasses.addAll((List<String>) annotationArgs.get(1));
						}
						if ("value".equals(secondLabel)) {
							List<Type> classes = (List<Type>) annotationArgs.get(3);
							targetClasses.addAll(classes.stream().map(Type::getClassName).collect(Collectors.toSet()));
						} else if ("targets".equals(secondLabel)) {
							targetClasses.addAll((List<String>) annotationArgs.get(3));
						}
					}
					if (!targetClasses.isEmpty()) {
						isMixinClass = true;
						this.mixinTargetClasses = targetClasses;
						break checkMixinClass;
					}
				}
			}
			isMixinClass = false;
			this.mixinTargetClasses = new HashSet<>();
		}


		// search interfaces
		Set<String> entrypointTypes = new HashSet<>();
		if (classNode.interfaces != null) {
			classNode.interfaces.forEach(interf -> {
				if (FabricEntrypoints.isEntrypointInterface(interf)) {
					entrypointTypes.add(FabricEntrypoints.getEntrypointType(interf));
				}
			});
		}
		this.isFabricEntrypoint = !entrypointTypes.isEmpty();
		this.entrypointTypes = entrypointTypes;
	}

	/**
	 * @return Contained class name.
	 */
	public String getClassName() {
		return name;
	}

	public boolean isMixinClass() {
		return isMixinClass;
	}

	public boolean isFabricEntrypoint() {
		return isFabricEntrypoint;
	}

	@Override
	public String getLocalName() {
		Controller controller = Recaf.getController();
		StringBuilder sb = new StringBuilder();
		String escapedName = StringEscapeUtils.escapeJava(super.getLocalName());
		sb.append(escapedName);

		if (controller.config().enhancement().showFabricEntrypoints && isFabricEntrypoint) {
			sb.append(" (Fabric Entrypoints:");
			entrypointTypes.stream().sorted().forEach(mixinTarget -> sb.append(" ").append(mixinTarget));
			sb.append(")");
		}

		if (controller.config().enhancement().showMixinTargets && isMixinClass) {
			sb.append(" (Mixin Targets:");
			mixinTargetClasses.stream().sorted().forEach(mixinTarget -> sb.append(" ").append(mixinTarget));
			sb.append(")");
		}

		return sb.toString();
	}

	@Override
	public int compareTo(DirectoryItem o) {
		if(o instanceof ClassItem) {
			ClassItem c = (ClassItem) o;
			return name.compareTo(c.name);
		}
		return 1;
	}
}