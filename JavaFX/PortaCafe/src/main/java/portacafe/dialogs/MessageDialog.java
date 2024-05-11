package portacafe.dialogs;

import javafx.scene.control.Alert;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class MessageDialog {
    private static final Logger log = LogManager.getLogger(MessageDialog.class);

    public static void showError(String message) {
        try {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Hiba!");
            alert.setContentText(message);
        }
        catch(ExceptionInInitializerError ex) {
            log.log(Level.WARN, "Nem sikerült dialógust létrehozni; JavaFX nincs inicializálva.");
        }
    }
}
