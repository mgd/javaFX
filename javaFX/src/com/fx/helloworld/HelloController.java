package com.fx.helloworld;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    private Button button1;

    @FXML
    private void initialize() {

        button1.setOnAction((event -> onHelloButtonClick()));
    }

    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}
