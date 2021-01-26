package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import viewcontroller.Controller;

/**
 * @author Simon Sperr
 * @version 2020.3, 21.1.2021
 */
public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception{
        Controller.show(stage);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
