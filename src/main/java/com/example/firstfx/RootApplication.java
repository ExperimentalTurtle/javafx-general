package com.example.firstfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

@SuppressWarnings("CommentedOutCode")
public class RootApplication extends Application {
    //TODO https://stackoverflow.com/questions/37200845/how-to-switch-scenes-in-javafx
    //TODO do this, best solution to scene changing

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(RootApplication.class.getResource("/com/example/firstfx/scene1.fxml"));

        // start with login screen
        // FXMLLoader fxmlLoader = new FXMLLoader(RootApplication.class.getResource("/com/example/firstfx/login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1400, 800, Color.LIGHTSKYBLUE);
        primaryStage.setTitle("Hello!");
        primaryStage.setScene(scene);
        primaryStage.show();

        //! load css
        String generalCss = Objects.requireNonNull(getClass().getResource("/com/example/firstfx/general.css")).toExternalForm();
        String bestMenuBarCss = Objects.requireNonNull(getClass().getResource("/com/example/firstfx/best-menu-bar.css")).toExternalForm();
        scene.getStylesheets().add(generalCss);
        scene.getStylesheets().add(bestMenuBarCss);

        //! check with alert before exiting
        //  primaryStage.setOnCloseRequest(event -> {
        //  event.consume();
        //  exit(primaryStage);
        //  });
    }

    public static void main(String[] args) {
        launch();
    }


    public void exit(Stage stage) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("You are about to exit !");
        alert.setContentText("Do you want to save before exiting ?");
        alert.showAndWait();

        if (alert.getResult() == ButtonType.OK) {
            System.out.println("You have successfully exited");
            stage.close();
        }
    }
}


