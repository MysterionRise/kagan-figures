package org.mystic.kagan;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.initStyle(StageStyle.UNDECORATED);
        Group root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Kagan Test");
        primaryStage.setScene(new Scene(root, 1000, 750));
        primaryStage.show();
    }
}
