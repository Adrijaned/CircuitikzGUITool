package guitool.grid;

import javafx.scene.shape.Line;
import guitool.utils.TooltipLabel;

public class GridLinks {
    private final GridCell firstCell;
    private final GridCell linkedCell;
    private final Line linkedLine;
    private final TooltipLabel linkedTooltip;

    public GridLinks(GridCell firstCell, GridCell linkedCell, Line linkedLine, TooltipLabel linkedTooltip) {
        this.firstCell = firstCell;
        this.linkedCell = linkedCell;
        this.linkedLine = linkedLine;
        this.linkedTooltip = linkedTooltip;
    }

    public GridCell getFirstCell() {
        return firstCell;
    }

    public GridCell getLinkedCell() {
        return linkedCell;
    }

    public Line getLinkedLine() {
        return linkedLine;
    }

    public TooltipLabel getLinkedTooltip() {
        return linkedTooltip;
    }
}
