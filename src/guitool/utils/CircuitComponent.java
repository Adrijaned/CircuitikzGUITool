package guitool.utils;

public class CircuitComponent {
    private String name;
    private String label = "";
    private CircuitCoordinates coords;

    public CircuitComponent(BasicComponents basicComponent) {
        this.name = basicComponent.getName();
        this.label = basicComponent.getDefaultLabel();
    }
    public CircuitComponent(BasicComponents basicComponent, CircuitCoordinates coords) {
        this.name = basicComponent.getName();
        this.label = basicComponent.getDefaultLabel();
        this.coords = coords;
    }
    public CircuitComponent(BasicComponents basicComponent, CircuitCoordinates coords, String label) {
        this.name = basicComponent.getName();
        this.label = label;
        this.coords = coords;
    }
    public CircuitComponent(String name) {
        this.name = name;
    }
    public CircuitComponent(String name, String label) {
        this.name = name;
        this.label = label;
    }
    public CircuitComponent(String name, CircuitCoordinates coords) {
        this.name = name;
        this.coords = coords;
    }
    public CircuitComponent(String name, CircuitCoordinates coords, String label) {
        this.name = name;
        this.coords = coords;
        this.label = label;
    }

    public CircuitCoordinates getCoords() {
        return coords;
    }

    public void setCoords(CircuitCoordinates coords) {
        this.coords = coords;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String toString() {
        String temp = String.format("(%d,%d) to[%s", coords.getFromX(), coords.getFromY(), name);
        if(!label.equals("")) {
            temp += String.format(", l_=$%s$", label);
        }
        temp += String.format("] (%d,%d)\n", coords.getToX(), coords.getToY());
        return temp;
    }
}
