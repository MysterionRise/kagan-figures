package org.mystic.kagan;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;


public class Controller {

    private static final String TRAINING_SESSION_PATH = "/compare/training-session";
    private static final String MAIN_SESSION_PATH = "/compare/main-session";
    @FXML
    Group rootGroup;
    @FXML
    Button startTestButton;
    @FXML
    TextArea instructionText;

    @FXML
    private void closeWindow() {
        System.out.println(rootGroup.getChildren().size());
        System.exit(0);
    }

    private final double[] x = {294, 14, 190, 366, 537, 14, 190, 366, 537};
    private final double[] y = {25, 185, 185, 185, 185, 367, 367, 367, 367};

    @FXML
    private void startKaganTest() {
        startTestButton.setDisable(true);
        instructionText.setVisible(false);
        for (int i = 0; i <= 8; ++i) {
            final String url = Controller.class.getResource(TRAINING_SESSION_PATH + "/1/" + i + ".jpg").toString();
            ImageView imageView = new ImageView(new Image(url));
            imageView.setLayoutX(x[i]);
            imageView.setLayoutY(y[i]);
            imageView.setFitWidth(200);
            imageView.setFitHeight(150);
            imageView.setPreserveRatio(true);
            imageView.setPickOnBounds(true);
            imageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    final double sceneX = mouseEvent.getSceneX();
                    final double sceneY = mouseEvent.getSceneY();
                    for (int j = 1; j <= 8; ++j) {
                        if (sceneX >= x[j] && sceneX <= x[j] + 200 && sceneY >= y[j] && sceneY <= y[j] + 150) {
                            System.out.println("Clicked on figure number" + j);
                        }
                    }
                }
            });
            rootGroup.getChildren().add(imageView);
        }
    }
}