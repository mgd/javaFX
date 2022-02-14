package com.fx.addressapp.view;

import com.fx.addressapp.MainApp;
import com.fx.addressapp.model.Data;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class MainAppController {
    @FXML
    private Button delete;

    @FXML
    private Button create;

    @FXML
    private TextField speed;

    @FXML
    private TextField heading;

    @FXML
    private TextField uuid;

    @FXML
    private TableView table;

    @FXML
    private TableColumn<Data, Number> speedCol;

    @FXML
    private TableColumn<Data, Number> headingCol;

    @FXML
    private TableColumn<Data, Number> distanceCol;

    @FXML
    private TableColumn<Data, String> uuidCol;

    private MainApp mainApp;
    private Boolean refresh;


    public MainAppController() {
    }

    @FXML
    public void initialize() {
        refresh = false;
        uuidCol.setCellValueFactory(cellData -> cellData.getValue().uuidProperty());
        speedCol.setCellValueFactory(cellData -> cellData.getValue().speedProperty());
        headingCol.setCellValueFactory(cellData -> cellData.getValue().headingProperty());
        distanceCol.setCellValueFactory(cellData -> cellData.getValue().distanceProperty());
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        table.setItems(mainApp.getTableList());

    }

    @FXML
    public void deleteRow() {

        int selectedIndex = table.getSelectionModel().getSelectedIndex();
        if (selectedIndex >=0) {
            table.getItems().remove(selectedIndex);
        }
        else {
            //Warning popup
        }
    }

    @FXML
    public void createRow() {
        String u = uuid.getText();
        Double s = null;
        Double h = null;
        Double d = null;

        try {
            s = Double.parseDouble(speed.getText());
            h = Double.parseDouble(heading.getText());
            d = 0.0;
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("Invalid Double value");
//            alert.setHeaderText();
            alert.setContentText("Please enter a valid double value.");
            alert.showAndWait();
            return;
        }

        Data newDataRow = new Data(u, s, h, d);
        mainApp.getTableList().add(newDataRow);

        if (!refresh) {
            refresh = true;
            Thread t = new Thread(() -> {
                while (true) {
                    try {
                        Thread.sleep(1000);
                        Platform.runLater(() -> {
                            update();
                        });
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            t.setDaemon(true);
            t.start();
        }
    }

    @FXML
    public void handleEdit() {
        Data row = (Data) table.getSelectionModel().getSelectedItem();
        if (row == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.showAndWait();
        }
        else {
            mainApp.showEditWindow(row);
        }
    }
    public void update() {
        int size = mainApp.getTableList().size();
        for (int i = 0; i < size; i++) {
            Data row = mainApp.getTableList().get(i);
            double distance = row.getDistance() + row.getSpeed();
            row.setDistance(distance);
        }
    }
}
