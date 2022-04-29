package com.example.firstfx.controllers;

import javafx.scene.Node;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class LoginController {
    private final String SECRET = "gio";

    @FXML
    TextField passwordField;

    @FXML
    TextField displayNameField;

    public String displayName;

    public void authorize(ActionEvent event) throws IOException {
        String password = passwordField.getText();
        String tempDisplayName = displayNameField.getText();

        if (Objects.equals(password, SECRET)) {
            // set display name
            displayName = tempDisplayName;

            // logging
            System.out.println(event);
            System.out.println(password);

            // load scene 1
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/firstfx/scene1.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(fxmlLoader.load(), 1400, 800, Color.LIGHTSKYBLUE);
            stage.setScene(scene);
            stage.show();
        }

    }
}
