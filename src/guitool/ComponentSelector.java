package guitool;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import guitool.grid.ComponentGrid;
import guitool.utils.BasicComponents;
import guitool.utils.CircuitComponent;

public class ComponentSelector extends VBox {
    private final TextField componentField = new TextField();
    private final Button cFButton = new Button("Add field");
    private final ScrollPane componentScP = new ScrollPane();
    private final VBox componentVBox = new VBox();

    public ComponentSelector(ComponentGrid grid) {
        super();
        setMinWidth(175);
        setMaxWidth(175);
        setAlignment(Pos.TOP_CENTER);
        setVgrow(componentScP, Priority.ALWAYS);

        componentScP.setContent(componentVBox);

        componentField.setAlignment(Pos.BOTTOM_CENTER);
        componentField.setPromptText("Add new component...");

        cFButton.setAlignment(Pos.BOTTOM_CENTER);

        cFButton.setOnMouseClicked(event -> {
            Button btn = new Button(componentField.getText());
            btn.setOnMouseClicked(event1 -> {
                if(event1.getButton() == MouseButton.PRIMARY) {
                    grid.setSelectedComponent(new CircuitComponent(componentField.getText()));
                } else if(event1.getButton() == MouseButton.SECONDARY) {
                    componentVBox.getChildren().remove(btn);
                }
            });
            componentVBox.getChildren().add(btn);
        });

        for(BasicComponents basicComponent : BasicComponents.values()) {
            Button btn = new Button(basicComponent.getName());
            btn.setOnMouseClicked(event -> grid.setSelectedComponent(new CircuitComponent(basicComponent)));
            componentVBox.getChildren().addAll(btn);
        }
        getChildren().addAll(componentScP, componentField, cFButton);
    }
}
