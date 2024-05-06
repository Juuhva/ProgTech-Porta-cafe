package portacafe.portacafe;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Startcontroller {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}