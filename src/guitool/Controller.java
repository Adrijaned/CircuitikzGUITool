package guitool;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import guitool.grid.ComponentGrid;

public class Controller {
    @FXML
    private BorderPane mainBorder;
    private final ComponentGrid componentGrid = new ComponentGrid(18, 18);
    private final ComponentSelector componentSelector = new ComponentSelector(componentGrid);
    private final ExportBox exportBox = new ExportBox(componentGrid);

    public void initialize() {
        mainBorder.setCenter(componentGrid);
        mainBorder.setLeft(componentSelector);
        mainBorder.setRight(exportBox);
    }
}
