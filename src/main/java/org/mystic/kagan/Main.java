package org.mystic.kagan;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        final String url = Main.class.getResource("/compare/training-session/1/0.jpg").toString();
        ImageView sample3 = new ImageView(new Image(url));
        sample3.setLayoutX(294);
        sample3.setLayoutY(25);
        root.getChildren().add(sample3);
        primaryStage.setTitle("Kagan Test");
        primaryStage.setScene(new Scene(root, 700, 600));
        primaryStage.show();
    }

    public void close() {
        System.exit(0);
    }
}
