package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class Scene2EnterNameController {
    // Enter name Scene
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML private TextField player1NameField; //name in
    @FXML private TextField player2NameField;
    @FXML private Button submitBtn;

    private Player activePlayer;
    private Player player1;
    private Player player2;


    public void submitPlayerNames(ActionEvent event) throws IOException {
        player1 = new Player( player1NameField.getText());
        player2 = new Player(player2NameField.getText());
        activePlayer = player1;
        String username = String.valueOf(activePlayer.getPlayerName());
        String message = "New Round: Roll or Hold?";

        FXMLLoader loader = new FXMLLoader(getClass().getResource("PigGame-PlayerRollingScreen.fxml"));
        root = loader.load();

        Scene3PlayingRollingScreenController scene3Controller = loader.getController();
        scene3Controller.displayLabel(message);
        scene3Controller.displayName(username);
        scene3Controller.setPlayer1(player1);
        scene3Controller.setPlayer2(player2);
        scene3Controller.setActivePlayer(activePlayer);

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
