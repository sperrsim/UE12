package viewcontroller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Simon Sperr
 * @version 2020.3, 21.1.2021
 */
public class Controller extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        show(stage);
    }

    public static void show(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Controller.class.getResource("view.fxml"));
            Parent root = fxmlLoader.load();

            stage.setTitle("ColorCalculator in JavaFX by Sperr");
            stage.setScene(new Scene(root, 400, 400));
            stage.show();
        }
        catch (IOException e) {
            System.err.println("Something wrong with view.fxml: " + e.getMessage());
            e.printStackTrace(System.err);
        }
    }


}
