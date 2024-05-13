package portacafe.portacafe;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import portacafe.core.coffees.abstracts.AbstractCoffee;
import portacafe.core.factories.AbstractCoffeeFactory;
import portacafe.core.factories.AbstractToppingFactory;
import portacafe.core.factories.coffees.AllInOneCoffeeFactory;
import portacafe.core.factories.toppings.ToppingFactory;
import portacafe.core.kiosk.Kiosk;
import portacafe.database.SqliteConnection;
import portacafe.database.commands.ClearCartCommand;
import portacafe.database.commands.FinishOrderCommand;
import portacafe.database.commands.ListCartContentCommand;
import javafx.scene.control.TableColumn;
import portacafe.database.commands.MakeMyOrderCommand;
import portacafe.database.datastructures.OrderedCoffeeEntry;
import javafx.scene.control.TableView;
import portacafe.database.exceptions.CartIsEmptyException;
import portacafe.dialogs.MessageDialog;

import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class CartController implements Initializable {

    @FXML
    public Button backButton, orderButton;
    @FXML
    public TableView<AbstractCoffee> coffeeTable;
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
        coffeeTable.setPlaceholder(new Label("A kosár üres."));
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
            List<AbstractCoffee> coffees = new ArrayList<>();
            AbstractCoffeeFactory factory = new AllInOneCoffeeFactory();
            AbstractToppingFactory toppingFactory = new ToppingFactory();
            for (OrderedCoffeeEntry entry : command.getQueryResults()) {
                AbstractCoffee coffee = factory.createCoffee(entry.coffeeType);
                coffee.setOrderedCoffeeID(entry.orderedCoffeeId);
                for (Integer toppingType : entry.toppings.keySet()){
                    for (int i = 0; i < entry.toppings.get(toppingType); i++) {
                        coffee = toppingFactory.makeTopping(coffee, toppingType);
                    }
                }
                coffees.add(coffee);
            }
            ObservableList<AbstractCoffee> cartItems = FXCollections.observableArrayList(coffees);
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
        idColumn.setCellValueFactory(new PropertyValueFactory<>("orderedCoffeeID"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("coffeeName"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("totalPrice"));
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

    public void clearCart(ActionEvent actionEvent) throws SQLException {
        Connection c = SqliteConnection.getConnection();
        new ClearCartCommand().execute(c);
        loadData();
        c.close();
    }
    public void makeOrder(ActionEvent actionEvent) throws SQLException {
        Connection c = SqliteConnection.getConnection();
        if (isCartEmpty()) {
            MessageDialog.showEmptyCart("Előbb adjon hozzá egy kávét a kosarához!");
            return;
        }
        try {
            this.closeCart(actionEvent);
            MessageDialog.showMessage("Kérem várjon, amíg a rendelése elkészül!");
            Kiosk kiosk = new Kiosk();
            kiosk.brewAllCoffeesInOrder();
            new FinishOrderCommand(kiosk.getLastOrderID()).execute(c);
            MessageDialog.showCompletedOrder("Rendelését átveheti a kasszánál!");
            c.close();
        } catch (CartIsEmptyException | InterruptedException ex) {
            throw new CartIsEmptyException();
        }
        loadData();
    }

    private boolean isCartEmpty() {
        return coffeeTable.getItems().isEmpty();
    }
}
