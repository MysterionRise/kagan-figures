package org.mystic.kagan;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    private static final String TRAINING_SESSION_PATH = "/compare/training-session";
    private static final String MAIN_SESSION_PATH = "/compare/main-session";
    private final double[] x = {400, 10, 180, 360, 540, 10, 180, 360, 540};
    private final double[] y = {20, 200, 200, 200, 200, 400, 400, 400, 400};
    @FXML
    Group rootGroup;
    @FXML
    Button startTestButton;
    @FXML
    TextArea instructionText;
    @FXML
    TextField userName;
    @FXML
    Label label;
    private PrintWriter out;
    private String login;

    @FXML
    private void clearTextField() {
        userName.clear();
    }

    @FXML
    private void closeWindow() {
        if (null != out) {
            out.flush();
            out.close();
        }
        System.exit(0);
    }

    @FXML
    private void startKaganTest() throws FileNotFoundException {
        if (userName.getText().equalsIgnoreCase("Введите свое имя") || userName.getText().length() == 0) {
            
        } else {
            out = new PrintWriter((userName.getText() + (System.currentTimeMillis() % 100000)) + ".txt");
            this.login = userName.getText();
            out.println(login);
            final int[] steps = {1};
            startTestButton.setDisable(true);
            instructionText.setVisible(false);
            userName.setVisible(false);
            final List<ImageView> images = new ArrayList<>(9);
            goNextStep(steps, images);
        }
    }

    private void goNextStep(final int[] steps, final List<ImageView> images) {
        if (steps[0] > 14) {
            instructionText.setVisible(true);
            instructionText.setText("Вы закончили выполнение теста!");
            return;
        }
        final long startTime = System.currentTimeMillis();
        for (int i = 0; i <= 8; ++i) {
            String url;
            if (steps[0] <= 2) {
                url = Controller.class.getResource(TRAINING_SESSION_PATH + "/" + steps[0] + "/" + i + ".jpg").toString();
            } else {
                label.setVisible(false);
                url = Controller.class.getResource(MAIN_SESSION_PATH + "/" + (steps[0] - 2) + "/" + i + ".jpg").toString();
            }
            ImageView imageView = new ImageView(new Image(url));
            imageView.setLayoutX(x[i]);
            imageView.setLayoutY(y[i]);
            imageView.setFitWidth(170);
            imageView.setFitHeight(170);
            imageView.setPreserveRatio(true);
            imageView.setPickOnBounds(true);
            imageView.setOnMouseClicked(mouseEvent -> {
                final double sceneX = mouseEvent.getSceneX();
                final double sceneY = mouseEvent.getSceneY();
                for (int j = 1; j <= 8; ++j) {
                    if (sceneX >= x[j] && sceneX <= x[j] + 170 && sceneY >= y[j] && sceneY <= y[j] + 170) {
                        if (steps[0] == 1) {
                            if (j == 1) {
                                label.setText("Вы выбрали правильный ответ!");
                                label.setVisible(true);
                            } else {
                                label.setText("Вы выбрали НЕправильный ответ!");
                                label.setVisible(true);
                            }
                        }
                        if (steps[0] == 2) {
                            if (j == 5) {
                                label.setText("Вы выбрали правильный ответ!");
                                label.setVisible(true);
                            } else {
                                label.setText("Вы выбрали НЕправильный ответ!");
                                label.setVisible(true);
                            }
                        }
                        steps[0]++;
                        out.println(j + " \t" + (System.currentTimeMillis() - startTime) + " \t");
                        for (ImageView i1 : images) {
                            rootGroup.getChildren().remove(i1);
                        }
                        images.clear();
                        goNextStep(steps, images);
                    }
                }
            });
            images.add(imageView);
            rootGroup.getChildren().add(imageView);
        }
    }
}
