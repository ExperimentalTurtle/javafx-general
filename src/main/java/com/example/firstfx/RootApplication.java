package com.example.firstfx;

import com.example.firstfx.controllers.ScreenController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class RootApplication extends Application {
    //TODO https://stackoverflow.com/questions/37200845/how-to-switch-scenes-in-javafx
    //TODO do this, best solution to scene changing

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(RootApplication.class.getResource("/com/example/firstfx/login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1400, 800, Color.LIGHTSKYBLUE);
        primaryStage.setTitle("Hello!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}


