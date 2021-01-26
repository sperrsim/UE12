package viewcontroller;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.ColorCalc;
import model.ColorCode;

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

    ColorCalc colorCalc = new ColorCalc();

    @FXML
    TextField red_txt;
    @FXML
    TextField green_txt;
    @FXML
    TextField blue_txt;
    @FXML
    Label hex_lbl;
    @FXML
    Pane color_pane;

    public void RedPlus()
    {
        colorCalc.changeColorViaRelativValue(ColorCode.RED, 10);
        red_txt.setText(String.valueOf(colorCalc.getRed()));
    }

    public void RedMinus()
    {
        colorCalc.changeColorViaRelativValue(ColorCode.RED, -10);
        red_txt.setText(String.valueOf(colorCalc.getRed()));
    }

    public void GreenPlus()
    {
        colorCalc.changeColorViaRelativValue(ColorCode.GREEN, 10);
        green_txt.setText(String.valueOf(colorCalc.getGreen()));
    }

    public void GreenMinus()
    {
        colorCalc.changeColorViaRelativValue(ColorCode.GREEN, -10);
        green_txt.setText(String.valueOf(colorCalc.getGreen()));
    }

    public void BluePlus()
    {
        colorCalc.changeColorViaRelativValue(ColorCode.BLUE, 10);
        blue_txt.setText(String.valueOf(colorCalc.getBlue()));
    }

    public void BlueMinus()
    {
        colorCalc.changeColorViaRelativValue(ColorCode.BLUE, -10);
        blue_txt.setText(String.valueOf(colorCalc.getBlue()));
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
            stage.setScene(new Scene(root, 300, 300));
            stage.show();
        }
        catch (IOException e) {
            System.err.println("Something wrong with view.fxml: " + e.getMessage());
            e.printStackTrace(System.err);
        }
    }


}
