package com.example.firstfx.controllers;

import com.example.firstfx.RootApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LoginController {
    @FXML
    TextField passwordField;

    @FXML
    TextField displayNameField;

    public String displayName;

    public void authorize(ActionEvent event) throws IOException {
        RootApplication rootApplication = RootApplication.getInstance();

        String password = passwordField.getText();
        String tempDisplayName = displayNameField.getText();

        if (password.contains("gio")) {
            // set display name
            displayName = tempDisplayName;

            // logging
            System.out.println(event);
            System.out.println(password);

            // load scene 1
            //  SceneController sceneController = new SceneController();
            //  sceneController.switchToScene1(event);
        }

    }
}
