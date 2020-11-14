package guitool;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import guitool.grid.ComponentGrid;

public class ExportBox extends VBox {
    private final ComponentGrid grid;
    public ExportBox(ComponentGrid grid) {
        super();
        this.grid = grid;
        setMinWidth(200);
        setMaxWidth(200);
        Button exportBtn = new Button("Generate Circuitikz");
        TextArea codeArea = new TextArea();
        codeArea.setPadding(new Insets(10, 10, 10, 10));
        VBox.setVgrow(codeArea, Priority.ALWAYS);
        exportBtn.setOnMouseClicked(event -> codeArea.setText("\\begin{circuitikz} \\draw\n" + grid.generateTikz() + ";\n\\end{circuitikz}"));
        getChildren().addAll(exportBtn, codeArea);
    }
}
