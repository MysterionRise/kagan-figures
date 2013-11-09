package org.mystic.kagan;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Kagan Test");
        primaryStage.setScene(new Scene(root, 700, 600));
        primaryStage.show();
    }
}
