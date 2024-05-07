package portacafe.portacafe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
    Button firstCoffeeTitle, secondCoffeeTitle, thirdCoffeeTitle, fourthCoffeeTitle, fifthCoffeeTitle, sixthCoffeeTitle;
    @FXML
    Label firstCoffeeDesc, secondCoffeeDesc, thirdCoffeeDesc, fourthCoffeeDesc, fifthCoffeeDesc, sixthCoffeeDesc;

    @FXML
    public void initialize() {
        disableButtons(true);
    }

    public void showLightCoffees(javafx.event.ActionEvent actionEvent) {
        firstCoffeeDesc.setDisable(false);
        firstCoffeeTitle.setText("Blonde Espresso Roast | Lágy és édes");
        firstCoffeeTitle.setDisable(false);
        firstCoffeeDesc.setText("Hihetetlenül sima és finoman édes," +
                " krémes szájízt hagyva maga után. Ez a világosabb " +
                "pörkölés egyedi ízt kölcsönöz eszpresszóinknak. Ezt " +
                "az egyedülálló keveréket oly módon személyre szabtuk, " +
                "hogy kiemelje az eszpresszó világosabb oldalát, hogy krémes" +
                " testet és édes citrusos jegyeket kaphass.");
    }

    public void disableButtons(boolean isDisabled){
        firstCoffeeTitle.setDisable(isDisabled);
        secondCoffeeTitle.setDisable(isDisabled);
        thirdCoffeeTitle.setDisable(isDisabled);
        fourthCoffeeTitle.setDisable(isDisabled);
        fifthCoffeeTitle.setDisable(isDisabled);
        sixthCoffeeTitle.setDisable(isDisabled);
    }


    public void showFirstCoffee(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("views/coffee.fxml"));
            fxmlLoader.setController(new CoffeeController(this)); // Pass "this" as argument
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.initStyle(StageStyle.TRANSPARENT);
            scene.setFill(Color.TRANSPARENT);
            stage.setScene(scene);
            stage.show();

            stage.setAlwaysOnTop(true);
            disableButtons(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
