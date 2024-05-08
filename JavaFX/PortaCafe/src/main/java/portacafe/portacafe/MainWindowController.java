package portacafe.portacafe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


import java.io.IOException;

public class MainWindowController  {

    @FXML
    Button lightCoffeeButton;
    @FXML
    Button mediumCoffeeButton;
    @FXML
    Button darkCoffeeButton;
    @FXML
    Button firstCoffeeTitle;
    @FXML
    Button firstMediumCoffeeTitle, secondMediumCoffeeTitle,
            thirdMediumCoffeeTitle, fourthMediumCoffeeTitle,
            fifthMediumCoffeeTitle, sixthMediumCoffeeTitle;
    @FXML
    Pane lightPane, mediumPane;



    @FXML
    public void initialize() {
        disableLightButtons(false);
    }

    public void showLightCoffees(javafx.event.ActionEvent actionEvent) {
        lightCoffeeButton.setDisable(true);
        mediumCoffeeButton.setDisable(false);
        lightPane.setVisible(true);
        mediumPane.setVisible(false);

    }

    public void showMediumCoffees(javafx.event.ActionEvent actionEvent) {
        mediumCoffeeButton.setDisable(true);
        lightCoffeeButton.setDisable(false);
        lightPane.setVisible(false);
        mediumPane.setVisible(true);

    }


    public void disableLightButtons(boolean isDisabled){
        firstCoffeeTitle.setDisable(isDisabled);
    }

    public void disableMediumButtons(boolean isDisabled){
        firstMediumCoffeeTitle.setDisable(isDisabled);
        secondMediumCoffeeTitle.setDisable(isDisabled);
        thirdMediumCoffeeTitle.setDisable(isDisabled);
        fourthMediumCoffeeTitle.setDisable(isDisabled);
        fifthMediumCoffeeTitle.setDisable(isDisabled);
        sixthMediumCoffeeTitle.setDisable(isDisabled);
    }


    public void showCoffee(ActionEvent actionEvent) {
        try {
            Button clickedButton = (Button) actionEvent.getSource();
            String buttonText = clickedButton.getText();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("views/coffee.fxml"));
            fxmlLoader.setController(new CoffeeController(this, buttonText));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.initStyle(StageStyle.TRANSPARENT);
            scene.setFill(Color.TRANSPARENT);
            stage.setScene(scene);
            stage.show();
            stage.setAlwaysOnTop(true);
            disableLightButtons(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showDarkCoffees(ActionEvent actionEvent) {
    }
}
