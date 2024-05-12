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
import java.sql.SQLException;

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
    Button firstMediumCoffee, secondMediumCoffee,
            thirdMediumCoffee, fourthMediumCoffee,
            fifthMediumCoffee, sixthMediumCoffee;
    @FXML
    Button firstDarkCoffee, secondDarkCoffee, thirdDarkCoffee;
    @FXML
    Pane lightPane, mediumPane, darkPane;
    @FXML
    Button viewCartButton;

    @FXML
    public void initialize() {
    }

    public void showLightCoffees(javafx.event.ActionEvent actionEvent) {
        lightCoffeeButton.setDisable(true);
        mediumCoffeeButton.setDisable(false);
        darkCoffeeButton.setDisable(false);
        lightPane.setVisible(true);
        mediumPane.setVisible(false);
        darkPane.setVisible(false);
    }

    public void showMediumCoffees(javafx.event.ActionEvent actionEvent) {
        mediumCoffeeButton.setDisable(true);
        lightCoffeeButton.setDisable(false);
        darkCoffeeButton.setDisable(false);
        lightPane.setVisible(false);
        mediumPane.setVisible(true);
        darkPane.setVisible(false);
    }

    public void showDarkCoffees(ActionEvent actionEvent) {
        darkCoffeeButton.setDisable(true);
        lightCoffeeButton.setDisable(false);
        mediumCoffeeButton.setDisable(false);
        darkPane.setVisible(true);
        lightPane.setVisible(false);
        mediumPane.setVisible(false);
    }


    public void disableLightButtons(boolean isDisabled){
        firstCoffeeTitle.setDisable(isDisabled);
    }

    public void disableMediumButtons(boolean isDisabled){
        firstMediumCoffee.setDisable(isDisabled);
        secondMediumCoffee.setDisable(isDisabled);
        thirdMediumCoffee.setDisable(isDisabled);
        fourthMediumCoffee.setDisable(isDisabled);
        fifthMediumCoffee.setDisable(isDisabled);
        sixthMediumCoffee.setDisable(isDisabled);
    }
    public void disableDarkButtons(boolean isDisabled){
        firstDarkCoffee.setDisable(isDisabled);
        secondDarkCoffee.setDisable(isDisabled);
        thirdDarkCoffee.setDisable(isDisabled);
    }

    public void disableRoastButtons(boolean isDisabled){
    darkCoffeeButton.setDisable(isDisabled);
    mediumCoffeeButton.setDisable(isDisabled);
    lightCoffeeButton.setDisable(isDisabled);
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
            disableMediumButtons(true);
            disableDarkButtons(true);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void showCartItems(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("views/cart.fxml"));
            CartController cartController = new CartController(this);
            fxmlLoader.setController(cartController);
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.initStyle(StageStyle.TRANSPARENT);
            scene.setFill(Color.TRANSPARENT);
            stage.setScene(scene);
            stage.show();
            stage.setAlwaysOnTop(true);
            disableRoastButtons(true);
            disableLightButtons(true);
            disableMediumButtons(true);
            disableDarkButtons(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
