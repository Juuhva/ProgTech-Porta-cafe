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
            alert.showAndWait();
        }
        catch(ExceptionInInitializerError ex) {
            log.log(Level.WARN, "Nem sikerült dialógust létrehozni; JavaFX nincs inicializálva.");
        }
    }

    public static void showMessage(String message) {
        try {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Sikeres megrendelés!");
            alert.setContentText(message);
            alert.showAndWait();
        }
        catch(ExceptionInInitializerError ex) {
            log.log(Level.WARN, "Nem sikerült megrendelni a terméket!");
        }
    }
    public static void showCart(String message) {
        try {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Sikeres hozzáadás!");
            alert.setContentText(message);
            alert.showAndWait();
        }
        catch(ExceptionInInitializerError ex) {
            log.log(Level.WARN, "Nem sikerült megrendelni a terméket!");
        }
    }
}
