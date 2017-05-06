package ch.fhnw.ivis.javaFX.rgbMixer;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.*;
import javafx.scene.shape.Rectangle;

public class RgbUI extends GridPane {

    private Slider redSlider;
    private Slider greenSlider;
    private Slider blueSlider;

    private Label redLabel;
    private Label greenLabel;
    private Label blueLabel;

    private Label redNameLabel;
    private Label greenNameLabel;
    private Label blueNameLabel;

    private Rectangle colorRectangle;
    private CornerRadii radii;
    // todo radii soll Ecken abrunden mit 20

    private RgbPM pm;

    // Constructor
    public RgbUI(RgbPM pm) {
        this.pm = pm;
        initializeControls();
        layoutControls();
        addEventHandlers();
        addValueChangedListeners();
        addBindings();
    }

    private void initializeControls() {
        redSlider = new Slider(0.00, 255.0, 0);
        greenSlider = new Slider(0.00, 255.0, 0);
        blueSlider = new Slider(0.00, 255.0, 0);

        redLabel = new Label();
        greenLabel = new Label();
        blueLabel = new Label();

        redNameLabel = new Label("Red: ");
        greenNameLabel = new Label("Green: ");
        blueNameLabel = new Label("Blue: ");

        colorRectangle = new Rectangle();
        radii = new CornerRadii(20);
    }

    private void layoutControls() {
        setPadding(new Insets(20));
        setHgap(10);
        setVgap(10);
        setPrefHeight(getPrefHeight() + 400);

        ColumnConstraints cc = new ColumnConstraints();
        cc.setHgrow(Priority.ALWAYS);
        getColumnConstraints().addAll(cc);

        RowConstraints rc = new RowConstraints();
        getRowConstraints().add(0, new RowConstraints(10));


        addRow(0, redNameLabel, redLabel, redSlider);
        addRow(1, greenNameLabel, greenLabel, greenSlider);
        addRow(2, blueNameLabel, blueLabel, blueSlider);

        add(colorRectangle, 0, 3, 2, 1);

        //setGridLinesVisible(true);
    }

    private void addEventHandlers() {

    }

    private void addValueChangedListeners() {

    }

    // Stand des Sliders synchron zu rot, grün und blau
    private void addBindings() {
        redSlider.valueProperty().bindBidirectional(pm.redProperty());
        greenSlider.valueProperty().bindBidirectional(pm.greenProperty());
        blueSlider.valueProperty().bindBidirectional(pm.blueProperty());

        //textProperty fordert String, redProperty ist Integer, darum der Cast!
        redLabel.textProperty().bind(pm.redProperty().asString());
        greenLabel.textProperty().bind(pm.greenProperty().asString());
        blueLabel.textProperty().bind(pm.blueProperty().asString());

        colorRectangle.fillProperty().bind(pm.colorProperty());
        colorRectangle.widthProperty().bind(widthProperty().subtract(40)); // Padding links20+rechts20=40
        colorRectangle.heightProperty().bind(heightProperty()
                .subtract(redSlider.heightProperty())
                .subtract(greenSlider.heightProperty())
                .subtract(blueSlider.heightProperty())
                .subtract(50));
    }

}
