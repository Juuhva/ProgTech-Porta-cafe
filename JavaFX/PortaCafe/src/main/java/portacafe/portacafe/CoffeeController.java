package portacafe.portacafe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class CoffeeController {

    @FXML
    private Button backButton;
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


    public void cancelSelection(ActionEvent actionEvent) {
        Stage stage = (Stage) backButton.getScene().getWindow();
        mainWindowController.disableLightButtons(false);
        stage.close();
    }

}
