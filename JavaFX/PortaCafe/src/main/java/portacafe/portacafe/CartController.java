package portacafe.portacafe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import portacafe.core.coffees.abstracts.AbstractCoffee;
import portacafe.database.datastructures.OrderEntry;
import javafx.scene.control.TableColumn;

import javax.swing.text.TableView;
import java.net.URL;
import java.util.ResourceBundle;


public class CartController implements Initializable {

    @FXML
    private Button backButton;
    @FXML
    TableView cartTable;
    @FXML
    private TableColumn<AbstractCoffee, Integer> idColumn, priceColumn, sugarColumn, milkColumn, creamColumn, whippedCreamColumn;
    @FXML
    private TableColumn<AbstractCoffee, String> nameColumn;


    private MainWindowController mainWindowController;

    public CartController(MainWindowController mainWindowController) {
        this.mainWindowController = mainWindowController;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        backButton.setOnAction(this::closeCart);
        mainWindowController.viewCartButton.setDisable(true);
        loadData();
    }

    private void loadData() {
    }

    public void closeCart(ActionEvent actionEvent) {
        Stage stage = (Stage) backButton.getScene().getWindow();
        mainWindowController.disableLightButtons(false);
        mainWindowController.disableMediumButtons(false);
        mainWindowController.disableDarkButtons(false);
        mainWindowController.disableRoastButtons(false);
        mainWindowController.viewCartButton.setDisable(false);
        stage.close();
    }
}
