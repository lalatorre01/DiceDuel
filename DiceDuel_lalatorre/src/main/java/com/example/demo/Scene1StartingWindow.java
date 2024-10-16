package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;


public class Scene1StartingWindow {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML private RadioButton rBnNewGame;
    @FXML private RadioButton rBnHistory;



    public void switchToScene2(ActionEvent event) throws IOException {
        //Starting Window

        FXMLLoader loader = new FXMLLoader(getClass().getResource("PigGame-EnterName.fxml"));
        root = loader.load();

        //root = FXMLLoader.load(getClass().getResource("PigGame-StartingWindow.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToHistory(ActionEvent event) throws IOException {
        //Starting Window

        FXMLLoader loader = new FXMLLoader(getClass().getResource("PigGame-History.fxml"));
        root = loader.load();

        //root = FXMLLoader.load(getClass().getResource("PigGame-StartingWindow.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



}

