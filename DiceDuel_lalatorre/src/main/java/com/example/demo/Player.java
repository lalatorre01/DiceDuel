package com.example.demo;

import java.time.LocalDate;
import java.util.Random;


public class Player {
//    private Random diceNum = new Random();
    private int playerScore = 0;
    private String playerName;
    private LocalDate date = LocalDate.now();
    private int numbOfWinsOfPlayer = 0;
    private int playerDiceResult = new Random().nextInt(1, 7);



    public Player(String playerName) {
        this.playerName = playerName;
    }


    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }


    public int getNumbOfWinsOfPlayer() {
        return numbOfWinsOfPlayer;
    }

    public void incrementNumbOfWins() {
       numbOfWinsOfPlayer++;
    }



    public int getPlayerDiceResult() {
        return playerDiceResult;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public int rollDice() {
        //Allows that player to roll or reroll the dice during their turn
        playerDiceResult = new Random().nextInt(1, 7);
        return playerDiceResult;
    }

    public void addToPlayerScore(int roll) {
        playerScore += roll;
    }

    public void setPlayerScoreToZero() {
        playerScore = 0;
    }
    public String wonText(){

        return"won";
    }
    public String loseText(){

        return"lose";
    }

}

