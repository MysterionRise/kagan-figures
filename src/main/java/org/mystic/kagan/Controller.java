package org.mystic.kagan;

import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


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
            ImageView sample3 = new ImageView(new Image(url));
            sample3.setLayoutX(x[i]);
            sample3.setLayoutY(y[i]);
            sample3.setFitWidth(200);
            sample3.setFitHeight(150);
            sample3.setPreserveRatio(true);
            sample3.setPickOnBounds(true);
            rootGroup.getChildren().add(sample3);
        }
    }
}