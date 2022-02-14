package com.fx.borderpane;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class BorderPaneController {
    @FXML
    private Label welcomeText;

    @FXML
    private Button Okay;

    @FXML
    private Button Cancel;

    @FXML
    private Button Help;

    @FXML
    public void initialize() {
//        buttonOne.setOnAction((event) -> onHelloButtonClick());
    }

    private void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}