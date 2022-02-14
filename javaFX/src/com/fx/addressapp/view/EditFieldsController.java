package com.fx.addressapp.view;

import com.fx.addressapp.model.Data;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditFieldsController {

    @FXML
    private TextField speedEdit;

    @FXML
    private TextField distanceEdit;

    @FXML
    private TextField headingEdit;

    @FXML
    private Button cancelEdit;

    @FXML
    private Button okayEdit;


    private Stage dialogStage;
    private Data data;

    @FXML
    public void initialize() {

    }

    public void setDialogStage (Stage dialogStage) {

        this.dialogStage = dialogStage;
    }

    public void setData(Data data) {
        this.data = data;
        speedEdit.setText(String.valueOf(data.getSpeed()));
        headingEdit.setText(String.valueOf(data.getHeading()));
        distanceEdit.setText(String.valueOf(data.getDistance()));
    }

    @FXML
    public void handleCancel () {
        dialogStage.close();
    }

    @FXML
    public void handleApply() {
        try {
            data.setDistance(Double.parseDouble(distanceEdit.getText()));
            data.setHeading(Double.parseDouble(distanceEdit.getText()));
            data.setSpeed(Double.parseDouble(speedEdit.getText()));
            dialogStage.close();
        }
        catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Invalid Entry");
            alert.showAndWait();
        }

    }
}
