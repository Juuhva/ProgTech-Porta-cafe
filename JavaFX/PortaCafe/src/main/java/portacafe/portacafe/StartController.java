package portacafe.portacafe;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class StartController {
    @FXML
    private Button startButton;

    @FXML
    private void initialize(){
        startScene();
    }


    private void startScene() {
        startButton.setOnAction(event -> {
            try {
                Stage thisStage = (Stage) startButton.getScene().getWindow();
                thisStage.close();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("views/mainWindow.fxml"));
                Parent root = fxmlLoader.load();
                Stage stage = new Stage();
                Scene scene = new Scene(root);
                stage.initStyle(StageStyle.TRANSPARENT);
                scene.setFill(Color.TRANSPARENT);
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}