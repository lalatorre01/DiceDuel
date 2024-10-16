package com.example.demo;


import javafx.collections.FXCollections;
import javafx.collections.ObservableIntegerArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;


public class Scene4HistoryController {

    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML private Button mainMenu;
    @FXML private TableView tableView;
    @FXML private TableColumn nameColumn;
    @FXML private TableColumn dateColumn;
    @FXML private TableColumn scoreColumn;
    @FXML private TableColumn winOrLoseColumn;
    private Player player1;
    private Player player2;

    public void switchToScene1(ActionEvent event) throws IOException {
        //Starting Window

        FXMLLoader loader = new FXMLLoader(getClass().getResource("PigGame-StartingWindow.fxml"));
        root = loader.load();

        //root = FXMLLoader.load(getClass().getResource("PigGame-StartingWindow.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void addInformationToColumn(){
        tableView = new TableView<Player>();
        nameColumn = new TableColumn<Player, String>("nameColumn");
        nameColumn.setCellValueFactory(new PropertyValueFactory<Player, String >("firstName"));

        dateColumn = new TableColumn<Player,LocalDate>("date");
        dateColumn.setCellValueFactory(new PropertyValueFactory<Player, LocalDate>("date"));

        scoreColumn = new TableColumn<Player, Integer>("scoreColumn");
        scoreColumn.setCellValueFactory(new PropertyValueFactory<Player, LocalDate>("playerScore"));
        winOrLoseColumn = new TableColumn<Player, String>("winOrLoseColumn");

        tableView.getColumns().add(nameColumn);
        tableView.getColumns().add(dateColumn);
        tableView.getColumns().add(scoreColumn);



    }
//    public ObservableList<Player> getPlayer(){
//        ObservableList<Player> players = FXCollections.observableArrayList();
//
//        players.add(player1.getPlayerName());
//        players.add(pla)
//        return null;
//    }
}
