module javafx.jlink.example.main {
    // Require JavaFX
    requires javafx.controls;
    requires javafx.fxml;

    // Require this module (in the folder "custom_element")
//    requires javafx.jlink.example.custom_nodes;

    // Export the "gui" package (needed by JavaFX to start the Application)
    // Replace "exports" with "opens" if "@FXML" is used in this module
    opens org.mystic.kagan;
}
