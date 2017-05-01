package ch.fhnw.ivis.javaFX.rgbMixer;

import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;

/**
 * Created by Iris Cipriano.
 */
public class RgbUI extends GridPane {

    private Slider redSlider;
    private Slider greenSlider;
    private Slider blueSlider;

    private Label redLabel;
    private Label greenLabel;
    private Label blueLabel;

    private Rectangle colorGround;

    // todo: Instanz von PM

    public RgbUI(RgbPM pm){
        //this.pm = pm;
        initializeControls();
        layoutControls();
        addEventHandlers();
        addValueChangedListeners();
        addBindings();
    }

    private void initializeControls(){
        redSlider     = new Slider(0.00, 255.0, 0);
        greenSlider   = new Slider(0.00, 255.0, 0);
        blueSlider    = new Slider(0.00, 255.0, 0);

        redLabel = new Label();
        greenLabel = new Label();
        blueLabel = new Label();

        colorGround = new Rectangle();
    }

    private void layoutControls(){
        addRow(0, redLabel, redSlider);
        addRow(1, greenLabel, greenSlider);
        addRow(2, blueLabel, blueSlider);

        add(colorGround,0, 3, 2, 1);
    }

    private void addEventHandlers(){

    }
    private void addValueChangedListeners(){

    }
    private void addBindings(){

    }


}
