package com.example.firstfx.controllers;

import javafx.animation.FadeTransition;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

@SuppressWarnings("unchecked")
public class Scene1Controller implements Initializable {
    @FXML
    AnchorPane anchorPane;

    @FXML
    ColorPicker colorPicker;

    @FXML
    ImageView imageView;

    @FXML
    Label choiceBoxLabel;

    @FXML
    ChoiceBox<String> choiceBox;

    private final String[] generalItems = {"pizza", "sushi", "ramen"};

    @FXML
    Slider slider;

    @FXML
    Label sliderLabel;

    public void prev() {
        Image shrek1Image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/example/firstfx/shrek1.jpg")));
        imageView.setImage(shrek1Image);
    }

    public void next() {
        Image shrek2Image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/example/firstfx/shrek2.jpg")));
        imageView.setImage(shrek2Image);
    }

    public void setBackgroundColor() {
        Color tempColor = colorPicker.getValue();
        anchorPane.setBackground(new Background(new BackgroundFill(tempColor, null, null)));
    }

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

    private void getFood(ActionEvent event) {
        String food = choiceBox.getValue();
        choiceBoxLabel.setText(food);
    }


    @FXML
    ProgressBar progressBar;

    @FXML
    Label progressBarLabel;

    private double progress = 0;

    public void onProgressBarIncrement() {
        progress += 0.1;
        int progressAmount = (int) Math.round(progress * 100);
        final int MAX_AMOUNT = 100;

        if (progressAmount <= MAX_AMOUNT) {
            progressBar.setProgress(progress);
            progressBarLabel.setText(progressAmount + " %");
        }

        if (progressAmount == MAX_AMOUNT) {
            progressBar.setStyle("-fx-accent: #00FF00");
        }
    }

    @FXML
    ListView<String> listView;

    @FXML
    Label listViewLabel;

    @FXML
    TreeView<String> treeView;

    public void selectTreeItem() {
        TreeItem<String> item = treeView.getSelectionModel().getSelectedItem();

        if (item != null) {
            System.out.println(item.getValue());
        }
    }

    public void onMenuBarItemClick(ActionEvent event) {
        MenuItem menuItem = (MenuItem) event.getSource();
        System.out.println(menuItem.getText());

        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(menuItem.getText());
        alert.setHeaderText("Shortcut key pressed !");
        alert.setContentText("Do you want to exit ?");
        alert.showAndWait();
    }

    @FXML
    ImageView animationImageView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choiceBox.getItems().addAll(generalItems);
        choiceBox.setValue(generalItems[0]);
        choiceBox.setOnAction(this::getFood);

        listView.getItems().addAll(generalItems);
        listView.getSelectionModel().selectFirst();
        listView.getSelectionModel().selectedItemProperty().addListener((observableValue, s, t1) -> listViewLabel.setText(observableValue.getValue()));
        listViewLabel.setText(generalItems[0]);

        slider.valueProperty().addListener((observableValue, number, t1) -> {
            String sliderValue = String.valueOf(observableValue.getValue().intValue());
            sliderLabel.setText(sliderValue);
        });

        progressBar.setProgress(progress);
        progressBar.setStyle("-fx-accent: orange");

        // TreeView
        TreeItem<String> root1 = new TreeItem<>("Root 1");
        TreeItem<String> root2 = new TreeItem<>("Root 2");

        TreeItem<String> model11 = new TreeItem<>("Model1.1");
        TreeItem<String> model12 = new TreeItem<>("Model1.2");

        root1.getChildren().add(model11);
        root1.getChildren().add(model12);

        // for showing multiple roots on tree view
        TreeItem<String> invisibleRoot = new TreeItem<>(null);
        invisibleRoot.getChildren().addAll(root1, root2);
        treeView.setRoot(invisibleRoot);
        treeView.setShowRoot(false);


        // add context menu to tree
        ContextMenu contextMenu = new ContextMenu();

        MenuItem menuItem1 = new MenuItem("menu item 1");
        MenuItem menuItem2 = new MenuItem("menu item 2");
        MenuItem menuItem3 = new MenuItem("menu item 3");

        contextMenu.getItems().addAll(menuItem1, menuItem2, menuItem3);
        treeView.setContextMenu(contextMenu);

        // animation
        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.millis(1000));
        transition.setCycleCount(TranslateTransition.INDEFINITE);
        transition.setByY(250);
        transition.setAutoReverse(true);


        RotateTransition rotateTransition = new RotateTransition();
        rotateTransition.setDuration(Duration.millis(1000));
        rotateTransition.setCycleCount(TranslateTransition.INDEFINITE);
        rotateTransition.setByAngle(360);
        rotateTransition.setAutoReverse(true);

        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setDuration(Duration.millis(1000));
        fadeTransition.setCycleCount(TranslateTransition.INDEFINITE);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.setAutoReverse(true);



        // start animating three of them at the same time for same image
        transition.setNode(animationImageView);
        rotateTransition.setNode(animationImageView);
        fadeTransition.setNode(animationImageView);

        transition.play();
        rotateTransition.play();
        fadeTransition.play();
    }
}
