package com.example.firstfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class RootApplication extends Application {
    private static RootApplication instance;

    public Stage stage;
    public Scene scene;
    public AnchorPane content;

    public static RootApplication getInstance() {
        if (instance == null) {
            instance = new RootApplication();
        }

        return instance;
    }


    @Override
    public void start(Stage primaryStage) throws IOException {
        //TODO https://stackoverflow.com/questions/37200845/how-to-switch-scenes-in-javafx
        //TODO do this, best solution to scene changing
        FXMLLoader fxmlLoader = new FXMLLoader(RootApplication.class.getResource("login.fxml"));

        content = fxmlLoader.load();
        scene = new Scene(content);
        stage = primaryStage;

        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}


