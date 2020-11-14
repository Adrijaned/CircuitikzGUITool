package guitool.grid;

import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class GridCell extends Pane {
    private boolean selected = false;
    private static final Border defaultBorder = new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT));
    private static final Border selectedBorder = new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT));
    private final int xPosInGrid;
    private final int yPosInGrid;

    public GridCell(int xPosInGrid, int yPosInGrid) {
        super();
        this.xPosInGrid = xPosInGrid;
        this.yPosInGrid = yPosInGrid;
        setMinSize(30, 30);
        setBorder(defaultBorder);
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
        setBorder(selected ? selectedBorder : defaultBorder);
    }

    public int getxPosInGrid() {
        return xPosInGrid;
    }

    public int getyPosInGrid() {
        return yPosInGrid;
    }
}
