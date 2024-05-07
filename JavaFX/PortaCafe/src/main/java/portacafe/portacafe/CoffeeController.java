package portacafe.portacafe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class CoffeeController {

    @FXML
    private Button backButton;

    MainWindowController mainWindowController = new MainWindowController();

    public void cancelSelection(ActionEvent actionEvent) {
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.setOnCloseRequest(event -> {
            mainWindowController.disableButtons(false);
            stage.close();
        });
        stage.close();
    }
}
