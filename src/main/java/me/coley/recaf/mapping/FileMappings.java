package me.coley.recaf.mapping;

import me.coley.recaf.workspace.Workspace;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;

/**
 * Extended base for mappings that load mappings from a given file.
 * Implementations will create file-loading logic for different mapping types.
 *
 * @author Matt
 */
public abstract class FileMappings extends Mappings {
	/**
	 * @param path
	 * 		A path to a text file containing mappings.
	 * @param workspace
	 * 		Workspace to pull names from when using hierarchy lookups.
	 *
	 * @throws IOException
	 * 		Thrown if the file could not be read.
	 */
	public FileMappings(Path path, Workspace workspace) throws IOException {
		this(path, workspace, true);
	}

	/**
	 * @param path
	 * 		A path to a text file containing mappings.
	 * @param workspace
	 * 		Workspace to pull names from when using hierarchy lookups.
	 * @param readNow
	 * 		Flag to indicate reading now. Typically {@code true}.
	 *
	 * @throws IOException
	 * 		Thrown if the file could not be read.
	 */
	protected FileMappings(Path path, Workspace workspace, boolean readNow) throws IOException {
		super(workspace);
		if (readNow) {
			read(path.toFile());
		}
	}

	/**
	 * @param file
	 * 		Text file containing mappings.
	 *
	 * @throws IOException
	 * 		Thrown if the file could not be read.
	 */
	protected void read(File file) throws IOException {
		String text = FileUtils.readFileToString(file, "UTF-8");
		setMappings(parse(text));
	}

	/**
	 * Parses the mappings into the standard ASM format. See the
	 * {@link org.objectweb.asm.commons.SimpleRemapper#SimpleRemapper(Map)} docs for more
	 * information.
	 *
	 *  <ul>
	 *    <li>for method names, the key is the owner, name and descriptor of the method (in the
	 *        form &lt;owner&gt;.&lt;name&gt;&lt;descriptor&gt;), and the value is the new method
	 *        name.
	 *    <li>for invokedynamic method names, the key is the name and descriptor of the method (in
	 *        the form .&lt;name&gt;&lt;descriptor&gt;), and the value is the new method name.
	 *    <li>for field and attribute names, the key is the owner and name of the field or
	 *        attribute (in the form &lt;owner&gt;.&lt;name&gt;), and the value is the new field
	 *        name.
	 *    <li>for internal names, the key is the old internal name, and the value is the new
	 *        internal name (see {@link org.objectweb.asm.Type#getInternalName()}).
	 *  </ul>
	 *
	 * @param text
	 * 		Text of the mappings.
	 *
	 * @return ASM formatted mappings.
	 */
	protected abstract Map<String, String> parse(String text);
}
