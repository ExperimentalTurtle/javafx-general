package com.example.firstfx.controllers;

import com.example.firstfx.RootApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneController {
    public void switchToScene1(ActionEvent event) throws IOException {
        RootApplication rootApplication = RootApplication.getInstance();
        FXMLLoader loader = FXMLLoader.load(getClass().getResource("scene1.fxml"));

        // assignment
        rootApplication.content = loader.load();
        rootApplication.scene = new Scene(rootApplication.content);
        rootApplication.stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        // show
        rootApplication.stage.setScene(rootApplication.scene);
        rootApplication.stage.show();
    }

    public void switchToScene2(ActionEvent event) throws IOException {
        RootApplication rootApplication = RootApplication.getInstance();
        FXMLLoader loader = FXMLLoader.load(getClass().getResource("scene2.fxml"));

        // assignment
        rootApplication.content = loader.load();
        rootApplication.scene = new Scene(rootApplication.content);
        rootApplication.stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        // show
        rootApplication.stage.setScene(rootApplication.scene);
        rootApplication.stage.show();
    }
}
