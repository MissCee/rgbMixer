package ch.fhnw.ivis.javaFX.rgbMixer;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RgbAPP extends Application{

    // Stage enthält die Scene, Scene enthält Parent, Parent enthält Presentation Model
    @Override
    public void start(Stage primaryStage) throws Exception{
        RgbPM pm = new RgbPM();
        Parent rootPanel = new RgbUI(pm);
        Scene scene = new Scene(rootPanel);

        primaryStage.setScene(scene);
        primaryStage.titleProperty().bind(pm.titleProperty());
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
