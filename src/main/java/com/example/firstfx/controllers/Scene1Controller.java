package com.example.firstfx.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Scene1Controller {
    @FXML
    AnchorPane anchorPane;

    public void exit() {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("You are about to exit !");
        alert.setContentText("Do you want to save before exiting ?");
        alert.showAndWait();

        if (alert.getResult() == ButtonType.OK) {
            System.out.println("You have successfully exited");
            Stage stage = (Stage) anchorPane.getScene().getWindow();
            stage.close();
        }
    }
}
