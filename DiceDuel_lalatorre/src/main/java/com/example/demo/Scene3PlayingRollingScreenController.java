package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.*;
import java.nio.Buffer;
import java.time.LocalDate;
import java.util.ArrayList;

public class Scene3PlayingRollingScreenController {

    private Stage stage;
    private Scene scene;
    private Parent root;
    private LocalDate date = LocalDate.now();;


    @FXML private Label nameLabel;
    @FXML private Label rollLabel;
    @FXML private Button rollBtn;
    @FXML private Button holdBtn;
    @FXML private Button mainMenu;

    private Player activePlayer;
    private Player player1;
    private Player player2;
    private String gameResult = "";
    private String winner;
    private BufferedWriter writer;



    public void displayWinner(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("PigGame-WinnerScreen.fxml"));
        root = loader.load();

        Scene5WinnerScreen scene5Controller = new Scene5WinnerScreen();
        scene5Controller.displayWinner(gameResult);

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void displayName(String username){
        nameLabel.setText("Hello " + username);
    }
    public void displayLabel(String message){
        rollLabel.setText(message);
    }

    public void setActivePlayer(Player activePlayer) {
        this.activePlayer = activePlayer;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public void goToMainMenu(ActionEvent event) throws IOException {
        //Starting Window

        FXMLLoader loader = new FXMLLoader(getClass().getResource("PigGame-StartingWindow.fxml"));
        root = loader.load();

        //root = FXMLLoader.load(getClass().getResource("PigGame-StartingWindow.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void rollDiceButtonClick(MouseEvent event){
        int rollValue = 0;
        rollValue = activePlayer.rollDice();
        if (activePlayer.getPlayerDiceResult() >= 2 && activePlayer.getPlayerDiceResult() <= 6){
            activePlayer.addToPlayerScore(rollValue);
            rollLabel.setText("You rolled a " + activePlayer.getPlayerDiceResult() + "\n"
                    + "Your score is: " + activePlayer.getPlayerScore() + "\n"
                    + "Roll Again? or Hold?");
        }
        else if(activePlayer.getPlayerDiceResult() == 1){
            activePlayer.setPlayerScoreToZero();
            rollLabel.setText("Previous Player rolled a " + activePlayer.getPlayerDiceResult() + "\n" + "Their score is now: " + activePlayer.getPlayerScore()+ " \n New Round: Roll or Hold?") ;
            if (activePlayer == player1) {
                activePlayer = player2;

            } else {
                activePlayer = player1;
            }
            displayName(activePlayer.getPlayerName());
        }

        if (!declareAWinner(player1, player2).isBlank()) {
            //go to winner screen
            winner = gameResult;

        }

    }

    public void holdBtnClick(MouseEvent event){
        if (activePlayer == player1) {
            activePlayer = player2;
        } else {
            activePlayer = player1;
        }
        rollLabel.setText("New Round: Roll or Hold?" + " \n Your Score is: " + activePlayer.getPlayerScore());
        displayName(activePlayer.getPlayerName());
        if (!declareAWinner(player1, player2).isBlank()) {
            //take the string that is returned from isGameResult and show in victory screen
            winner = gameResult;
        }
    }
    public String declareAWinner(Player player1, Player player2) {
        //Determines if the player won or lost using java streams
        if (player1.getPlayerScore() >= 100) {
            player1.incrementNumbOfWins();
            player1.wonText();
            player2.loseText();
            gameResult = player1.getPlayerName() + " Won";
        } else if (player2.getPlayerScore() >= 100) {
            player2.incrementNumbOfWins();
            player2.wonText();
            player1.loseText();
            gameResult = player2.getPlayerName() + " Won";
        }
        return gameResult;
    }
}




