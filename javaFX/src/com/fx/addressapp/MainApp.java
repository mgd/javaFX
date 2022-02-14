package com.fx.addressapp;

import com.fx.addressapp.model.Data;
import com.fx.addressapp.view.EditFieldsController;
import com.fx.addressapp.view.MainAppController;
import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.TimeUnit;

public class MainApp extends Application {

    private ObservableList<Data> tableList = FXCollections.observableArrayList();
    private Stage primaryStage;
    MainAppController controller;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws IOException, InterruptedException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("view/overview.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Hello!");
        this.primaryStage.setScene(scene);
        this.primaryStage.show();

        controller = fxmlLoader.getController();
        // In setMainApp, we call getTableList to get the Observable List
        controller.setMainApp(this);
    }

    public ObservableList<Data> getTableList() {
        return tableList;
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public void showEditWindow(Data data) {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("view/editFields.fxml"));
        try {
            AnchorPane page = loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Feilds");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            EditFieldsController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setData(data);

            dialogStage.showAndWait();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public MainApp() {
    }
}