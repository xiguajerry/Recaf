package me.coley.recaf.ui.controls.pane;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import me.coley.recaf.Recaf;
import me.coley.recaf.control.gui.GuiController;
import me.coley.recaf.ui.controls.tree.JavaResourceTree;
import me.coley.recaf.util.fabric.FabricEntrypoints;
import me.coley.recaf.workspace.JavaResource;
import me.coley.recaf.workspace.Workspace;
import org.apache.commons.codec.StringDecoder;
import org.apache.commons.lang3.StringEscapeUtils;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.tree.ClassNode;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WorkspaceSummaryPane extends BorderPane {
    private final VBox vbox;
    private Workspace workspace;

    public WorkspaceSummaryPane(Workspace workspace) {
        this.workspace = workspace;
        this.vbox = new VBox();

        JavaResource primaryResource = workspace.getPrimary();
        setCenter(vbox);
        int totalClasses = workspace.getPrimaryClasses().size() + workspace.getLibraryClasses().size();
        vbox.getChildren().addAll(
                new Label("Summary") {
                    {
                        setFont(Font.font("Arial", FontWeight.MEDIUM, 30));
                    }
                },
                new Label("File Path: " + workspace.getPrimary().getName().toString()),
                new Label(totalClasses + " classes loaded (" + workspace.getLibraryClasses().size() + " library classes)")
        );

        byte[] manifestFile = workspace.getFile("META-INF/MANIFEST.MF");
        if (manifestFile != null) {
            Set<String> lines = Arrays.stream(new String(manifestFile, StandardCharsets.UTF_8)
                            .intern().split("\n")).map(String::trim)
                            .filter(line -> line.startsWith("Main-Class: "))
                            .collect(Collectors.toSet());
            if (!lines.isEmpty()) {
                String mainClass = lines.stream().findFirst().get().replace("Main-Class: ", "")
                        .trim().replace(".", "/");
                vbox.getChildren().addAll(
                        new HBox() {
                            {
                                setSpacing(8);
                                setAlignment(Pos.CENTER_LEFT);
                                getChildren().addAll(
                                        new Label("Main-Class: "),
                                        new Label(StringEscapeUtils.escapeJava(mainClass)),
                                        new Button() {
                                            {
                                                setText("Open");
                                                setOnMouseClicked((event) -> {
                                                    if (Recaf.getController() instanceof GuiController) {
                                                        GuiController controller = (GuiController) Recaf.getController();
                                                        controller.windows().getMainWindow()
                                                                .openClass(primaryResource, mainClass);
                                                    }
                                                });
                                            }
                                        }
                                );
                            }
                        }
                );
            }
        }

        int currentEntrypointNum = 0;
        workspace.getPrimaryClasses().forEach(classData -> {
            ClassReader reader = new ClassReader(classData);
            Set<String> entrypointTypes = new HashSet<>();
            if (reader.getInterfaces() != null) {
                Arrays.asList(reader.getInterfaces()).forEach(interf -> {
                    if (FabricEntrypoints.isEntrypointInterface(interf)) {
                        entrypointTypes.add(FabricEntrypoints.getEntrypointType(interf));
                    }
                });
            }
            boolean isFabricEntrypoint = !entrypointTypes.isEmpty();
            if (isFabricEntrypoint) {
                String escapedName = StringEscapeUtils.escapeJava(reader.getClassName());
                StringBuilder sb = new StringBuilder();
                sb.append(escapedName).append(" (Entrypoint Types:");
                entrypointTypes.forEach(type -> sb.append(" ").append(type));
                sb.append(")");
                vbox.getChildren().addAll(
                        new HBox() {
                            {
                                setSpacing(8);
                                setAlignment(Pos.CENTER_LEFT);
                                getChildren().addAll(
                                        new Label("FabricEntrypoint" + currentEntrypointNum + ": "),
                                        new Label(sb.toString()),
                                        new Button() {
                                            {
                                                setText("Open");
                                                setOnMouseClicked((event) -> {
                                                    if (Recaf.getController() instanceof GuiController) {
                                                        GuiController controller = (GuiController) Recaf.getController();
                                                        controller.windows().getMainWindow().openClass(primaryResource, reader.getClassName());
                                                    }
                                                });
                                            }
                                        }
                                );
                            }
                        }
                );
            }
        });
    }
}
