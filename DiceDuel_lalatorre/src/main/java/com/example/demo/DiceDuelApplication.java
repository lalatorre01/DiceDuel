package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;

public class PigGameApplication extends Application{

    @Override
    public void start(Stage stage) throws IOException {

       try{
           //Start up code
           Parent root = FXMLLoader.load(getClass().getResource("PigGame-StartingWindow.fxml"));
           Scene scene = new Scene(root);
           stage.setScene(scene);
           stage.show();

       }catch (Exception e){
           e.printStackTrace();
       }

    }

    public static void main(String[] args) {
        launch();

    }


}