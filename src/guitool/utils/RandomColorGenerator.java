package guitool.utils;

import javafx.scene.paint.Color;

import java.util.Random;

// because why the fuck not
public class RandomColorGenerator {
    private static final Random rand = new Random();
    public static Color getColor() {
        return new Color(rand.nextDouble(), rand.nextDouble(), rand.nextDouble(), 1);
    }
    public static Color getColorNotInvisible() {
        return new Color(rand.nextDouble() % 0.6, rand.nextDouble() % 0.6, rand.nextDouble() % 0.6, 1);
    }
}
