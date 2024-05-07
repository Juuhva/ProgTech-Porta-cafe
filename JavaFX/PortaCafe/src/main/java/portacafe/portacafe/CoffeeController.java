package portacafe.portacafe;

import com.sun.tools.javac.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import static portacafe.portacafe.MainWindowController.*;

public class CoffeeController {

    @FXML
    private Button backButton;
    @FXML public void initialize() {
        backButton.setOnAction(event -> cancelSelection(event));

    }

    private MainWindowController mainWindowController;

    public CoffeeController(MainWindowController mainWindowController) {
        this.mainWindowController = mainWindowController;
    }


    public void cancelSelection(ActionEvent actionEvent) {
        Stage stage = (Stage) backButton.getScene().getWindow();
        mainWindowController.disableButtons(false);
        stage.close();
    }

}
