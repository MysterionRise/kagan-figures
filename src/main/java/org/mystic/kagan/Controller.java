package org.mystic.kagan;

import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class Controller {

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

    @FXML
    private void startKaganTest() {
        startTestButton.setDisable(true);
        instructionText.setVisible(false);
        final String url = Controller.class.getResource("/compare/training-session/1/0.jpg").toString();
        ImageView sample3 = new ImageView(new Image(url));
        sample3.setLayoutX(294);
        sample3.setLayoutY(25);
        rootGroup.getChildren().add(sample3);
    }
}
