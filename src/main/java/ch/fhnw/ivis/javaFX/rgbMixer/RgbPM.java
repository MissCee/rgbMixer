package ch.fhnw.ivis.javaFX.rgbMixer;

import javafx.beans.binding.Bindings;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.paint.Color;

public class RgbPM {

    private IntegerProperty red = new SimpleIntegerProperty(100);
    private IntegerProperty green = new SimpleIntegerProperty(100);
    private IntegerProperty blue = new SimpleIntegerProperty(100);

    // Mischfarbe (!alles was kein primitiver Datentyp ist und kein String --> Object)
    private ObjectProperty<Color> color = new SimpleObjectProperty<>();

    // Constructor
    public RgbPM(){
        color.bind(Bindings.createObjectBinding(() -> Color.rgb(getRed(), getGreen(), getBlue()),
                red, green, blue));
    }


    // Getter und Setter

    public int getRed() {
        return red.get();
    }

    public IntegerProperty redProperty() {
        return red;
    }

    public void setRed(int red) {
        this.red.set(red);
    }

    public int getGreen() {
        return green.get();
    }

    public IntegerProperty greenProperty() {
        return green;
    }

    public void setGreen(int green) {
        this.green.set(green);
    }

    public int getBlue() {
        return blue.get();
    }

    public IntegerProperty blueProperty() {
        return blue;
    }

    public void setBlue(int blue) {
        this.blue.set(blue);
    }

    public Color getColor() {
        return color.get();
    }

    public ObjectProperty<Color> colorProperty() {
        return color;
    }

    public void setColor(Color color) {
        this.color.set(color);
    }
}
