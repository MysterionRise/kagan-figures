package org.mystic.kagan;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;
import java.util.List;


public class Controller {

    private static final String TRAINING_SESSION_PATH = "/compare/training-session";
    private static final String MAIN_SESSION_PATH = "/compare/main-session";
    private final double[] x = {500, 10, 260, 510, 760, 10, 260, 510, 760};
    private final double[] y = {20, 270, 270, 270, 270, 520, 520, 520, 520};
    @FXML
    Group rootGroup;
    @FXML
    Button startTestButton;
    @FXML
    TextArea instructionText;
    @FXML
    TextField userName;
    private String login;

    @FXML
    private void clearTextField() {
        userName.clear();
    }

    @FXML
    private void closeWindow() {
        System.exit(0);
    }

    @FXML
    private void startKaganTest() {
        if (userName.getText().equalsIgnoreCase("Введите свое имя") || userName.getText().length() == 0) {

        } else {
            this.login = userName.getText();
            System.out.println(login);
            final int[] steps = {1};
            startTestButton.setDisable(true);
            instructionText.setVisible(false);
            final List<ImageView> images = new ArrayList<ImageView>(9);
            goNextStep(steps, images);
        }
    }

    private void goNextStep(final int[] steps, final List<ImageView> images) {
        if (steps[0] > 14) {
            return;
        }
        for (int i = 0; i <= 8; ++i) {
            String url;
            if (steps[0] <= 2) {
                url = Controller.class.getResource(TRAINING_SESSION_PATH + "/" + steps[0] + "/" + i + ".jpg").toString();
            } else {
                url = Controller.class.getResource(MAIN_SESSION_PATH + "/" + (steps[0] - 2) + "/" + i + ".jpg").toString();
            }
            ImageView imageView = new ImageView(new Image(url));
            imageView.setLayoutX(x[i]);
            imageView.setLayoutY(y[i]);
            imageView.setFitWidth(200);
            imageView.setFitHeight(200);
            imageView.setPreserveRatio(true);
            imageView.setPickOnBounds(true);
            imageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    final double sceneX = mouseEvent.getSceneX();
                    final double sceneY = mouseEvent.getSceneY();
                    for (int j = 1; j <= 8; ++j) {
                        if (sceneX >= x[j] && sceneX <= x[j] + 200 && sceneY >= y[j] && sceneY <= y[j] + 200) {
                            steps[0]++;
                            System.out.println("Clicked on figure number " + j);
                            for (ImageView i : images) {
                                rootGroup.getChildren().remove(i);
                            }
                            images.clear();
                            goNextStep(steps, images);
                        }
                    }
                }
            });
            images.add(imageView);
            rootGroup.getChildren().add(imageView);
        }
    }
}