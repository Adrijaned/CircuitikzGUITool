package guitool.utils;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class TooltipLabel extends Label {

    public TooltipLabel(String text, double transformX, double transformY, Node addTo) {
        super(text);
        setFont(new Font(20));
        setTranslateX(transformX + 20);
        setTranslateY(transformY + 20);
        setTextFill(Color.RED);
        setMouseTransparent(true);
        setVisible(false);
        addTo.setOnMouseEntered(event -> setVisible(true));
        addTo.setOnMouseExited(event -> setVisible(false));
    }
}
