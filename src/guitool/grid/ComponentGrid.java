package guitool.grid;

import guitool.utils.*;
import javafx.geometry.Point2D;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

import java.util.HashMap;
import java.util.Random;

public class ComponentGrid extends StackPane {
    private boolean shouldLink = false;
    private GridCell lastSelected;
    private GridPane gridPane = new GridPane();
    private final HashMap<GridLinks, CircuitComponent> linkedComponents = new HashMap<>();
    private CircuitComponent selectedComponent = new CircuitComponent(BasicComponents.SHORT);

    public ComponentGrid(int cols, int rows) {
        super();
        setMaxSize(600, 600);
        setMinSize(600, 600);
        GridCell[] cells = new GridCell[cols];
        for(int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                GridCell gridCell = new GridCell(j, rows - i);
                gridCell.setOnMouseClicked(event -> {
                    if(event.getButton() == MouseButton.PRIMARY) {
                        if(shouldLink) {
                            if(gridCell != lastSelected) {
                                linkCells(gridCell);
                            }
                            shouldLink = false;
                            lastSelected.setSelected(!lastSelected.isSelected());
                        } else {
                            shouldLink = true;
                            lastSelected = gridCell;
                            gridCell.setSelected(!gridCell.isSelected());
                        }
                    } else if (event.getButton() == MouseButton.SECONDARY) {
                        removeCellLink(gridCell);
                    }
                });
                cells[j] = gridCell;
            }
            gridPane.addRow(i, cells);
        }
        getChildren().add(gridPane);
    }
    private void linkCells(GridCell cell) {
        if(areLinked(cell, lastSelected)) {
            return;
        }

        Point2D cellBounds = cell.localToParent(cell.getWidth()/2, cell.getHeight()/2);
        Point2D linkedBounds = lastSelected.localToParent(lastSelected.getWidth()/2, lastSelected.getHeight()/2);

        Line gridLine = new Line(cellBounds.getX(), cellBounds.getY(), linkedBounds.getX(), linkedBounds.getY());
        gridLine.setStrokeWidth(2);
        gridLine.setStroke(RandomColorGenerator.getColor());
        // idk anymore
        double translateX = (cellBounds.getX() + linkedBounds.getX()) / 2;
        double translateY = (cellBounds.getY() + linkedBounds.getY()) / 2;

        gridLine.setTranslateX(translateX - 300);
        gridLine.setTranslateY(translateY - 300);

        TooltipLabel tpLabel = new TooltipLabel(selectedComponent.getName(), translateX - 300, translateY - 300, gridLine);
        linkedComponents.put(new GridLinks(cell, lastSelected, gridLine, tpLabel), selectedComponent);

        getChildren().addAll(gridLine, tpLabel);
    }

    private void removeCellLink(GridCell cell) {
        for(GridLinks c : linkedComponents.keySet()) {
            if(c.getFirstCell().equals(cell) || c.getLinkedCell().equals(cell)) {
                getChildren().removeAll(c.getLinkedLine(), c.getLinkedTooltip());
                linkedComponents.remove(c);
                break;
            }
        }
    }

    public void setSelectedComponent(CircuitComponent selectedComponent) {
        this.selectedComponent = selectedComponent;
    }
    public String generateTikz() {
        StringBuilder temp = new StringBuilder();
        // get links
        for(GridLinks gl : linkedComponents.keySet()) {
            // get first cell
            GridCell firstCell = gl.getFirstCell();
            GridCell linkedCell = gl.getLinkedCell();
            CircuitComponent circ = linkedComponents.get(gl);
            circ.setCoords(new CircuitCoordinates(firstCell.getxPosInGrid(), firstCell.getyPosInGrid(), linkedCell.getxPosInGrid(), linkedCell.getyPosInGrid()));
            temp.append(circ.toString());
        }
        return temp.toString();
    }
    private boolean areLinked(GridCell cell1, GridCell cell2) {
        for(GridLinks gridCell : linkedComponents.keySet()) {
            if((gridCell.getFirstCell().equals(cell1) && gridCell.getLinkedCell().equals(cell2))
                    || (gridCell.getFirstCell().equals(cell2) && gridCell.getLinkedCell().equals(cell1))) {
                return true;
            }
        }
        return false;
    }
}
