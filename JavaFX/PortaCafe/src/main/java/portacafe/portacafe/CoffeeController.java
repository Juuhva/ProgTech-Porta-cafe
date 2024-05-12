package portacafe.portacafe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import portacafe.core.coffees.roasts.light.BlondeEspressoCoffee;
import portacafe.database.commands.AddToCartCommand;
import portacafe.database.commands.SqliteInsertCommand;

public class CoffeeController {

    @FXML
    private Button backButton, addToCartButton;
    @FXML
    private Label coffeSelectionTitle;

    @FXML public void initialize() {
        backButton.setOnAction(event -> cancelSelection(event));
        coffeSelectionTitle.setText(buttonText);
    }

    private MainWindowController mainWindowController;
    private String buttonText;


    public CoffeeController(MainWindowController mainWindowController, String buttonText) {
        this.mainWindowController = mainWindowController;
        this.buttonText = buttonText;
    }

    public void enableAllButtons(){
        mainWindowController.disableLightButtons(false);
        mainWindowController.disableMediumButtons(false);
        mainWindowController.disableDarkButtons(false);
    }

    public void cancelSelection(ActionEvent actionEvent) {
        Stage stage = (Stage) backButton.getScene().getWindow();
        enableAllButtons();
        stage.close();
    }

    public void addToCart(ActionEvent actionEvent) {
    }

}
