package portacafe.portacafe;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import portacafe.core.coffees.abstracts.AbstractCoffee;
import portacafe.database.SqliteConnection;
import portacafe.database.commands.ListCartContentCommand;
import portacafe.database.datastructures.OrderEntry;
import javafx.scene.control.TableColumn;
import portacafe.database.datastructures.OrderedCoffeeEntry;
import javafx.scene.control.TableView;

import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class CartController implements Initializable {

    @FXML
    private Button backButton;
    @FXML
    public TableView coffeeTable;
    @FXML
    public TableColumn<AbstractCoffee, Integer> idColumn, priceColumn, sugarColumn, milkColumn, creamColumn, whippedCreamColumn;
    @FXML
    public TableColumn<AbstractCoffee, String> nameColumn;


    private MainWindowController mainWindowController;

    public CartController(MainWindowController mainWindowController) {
        this.mainWindowController = mainWindowController;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        backButton.setOnAction(this::closeCart);
        mainWindowController.viewCartButton.setDisable(true);
        initTableColumns();
        loadData();
    }

    private void loadData() {
        Connection connection = null;
        try {
            connection = SqliteConnection.getConnection();
            ListCartContentCommand command = new ListCartContentCommand();
            command.execute(connection);
            ObservableList<OrderedCoffeeEntry> cartItems = FXCollections.observableArrayList(command.getQueryResults());
            coffeeTable.setItems(cartItems);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void initTableColumns() {
        //idColumn.setCellValueFactory(new PropertyValueFactory<>("orderedCoffeeId"));
        //nameColumn.setCellValueFactory(new PropertyValueFactory<>("coffeeName"));
        //priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        //sugarColumn.setCellValueFactory(new PropertyValueFactory<>("sugar"));
        //milkColumn.setCellValueFactory(new PropertyValueFactory<>("milk"));
        //creamColumn.setCellValueFactory(new PropertyValueFactory<>("cream"));
        //whippedCreamColumn.setCellValueFactory(new PropertyValueFactory<>("whippedCream"));
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
