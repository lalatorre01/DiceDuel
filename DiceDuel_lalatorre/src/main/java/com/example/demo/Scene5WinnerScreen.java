package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class Scene5WinnerScreen {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Label winningPlayer;
    @FXML private Button mainMenu;

        public void displayWinner(String winner){
            winningPlayer.setText(winner);
        }

        public void backToMainMenu(ActionEvent event) throws IOException {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("PigGame-StartingWindow.fxml"));
            root = loader.load();
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
}

