package com.fx.gridpane;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class GridPaneController {
    @FXML
    private Label welcomeText;

    @FXML
    private Button buttonOne;


    @FXML
    private void initialize() {
        buttonOne.setOnAction(event -> onHelloButtonClick());
    }
    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}