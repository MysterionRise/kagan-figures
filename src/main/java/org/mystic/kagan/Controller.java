package org.mystic.kagan;

import javafx.fxml.FXML;
import javafx.scene.Group;

public class Controller {
    @FXML
    Group rootGroup;

    @FXML
    private void closeWindow() {
        System.out.println(rootGroup.getChildren().size());
        System.exit(0);

    }
}
