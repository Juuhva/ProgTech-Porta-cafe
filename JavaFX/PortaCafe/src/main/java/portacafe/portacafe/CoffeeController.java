package portacafe.portacafe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.sqlite.SQLiteConnection;
import portacafe.core.coffees.roasts.light.BlondeEspressoCoffee;
import portacafe.database.SqliteConnection;
import portacafe.database.commands.AddToCartCommand;
import portacafe.database.commands.SqliteCommand;
import portacafe.database.commands.SqliteInsertCommand;


import javax.swing.text.html.ImageView;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class CoffeeController {

    @FXML
    private Button backButton, addToCartButton;
    @FXML
    public Label coffeSelectionTitle;
    @FXML
    private Label sugarCounter, milkCounter, creamCounter, whippedCreamCounter;

    @FXML public void initialize() {
        backButton.setOnAction(event -> cancelSelection(event));
        addToCartButton.setOnAction(event -> addToCart(event));
        coffeSelectionTitle.setText(buttonText);
    }
    ArrayList<Integer> unsortedToppings = new ArrayList<>();
    private int sugarToppingCounter = 0;
    private int milkToppingCounter = 0;
    private int creamToppingCounter = 0;
    private int whippedCreamToppingCounter = 0;

    Connection c = SqliteConnection.getConnection();

    private MainWindowController mainWindowController;
    private String buttonText;


    public CoffeeController(MainWindowController mainWindowController, String buttonText) throws SQLException {
        this.mainWindowController = mainWindowController;
        this.buttonText = buttonText;
    }

    public void enableAllButtons(){
        mainWindowController.disableLightButtons(false);
        mainWindowController.disableMediumButtons(false);
        mainWindowController.disableDarkButtons(false);
    }


    public void addSugar(ActionEvent actionEvent){
        unsortedToppings.add(0);
        if(unsortedToppings.contains(0)){
            sugarToppingCounter++;
            sugarCounter.setText(String.valueOf(sugarToppingCounter));
        }
    }

    public void removeSugar(ActionEvent actionEvent) {

    }

    public void addMilk(ActionEvent actionEvent){
        unsortedToppings.add(1);
        if(unsortedToppings.contains(1)){
            milkToppingCounter++;
            milkCounter.setText(String.valueOf(milkToppingCounter));
        }
    }

    public void removeMilk(ActionEvent actionEvent) {

    }

    public void addCream(ActionEvent actionEvent){
        unsortedToppings.add(2);
        if(unsortedToppings.contains(2)){
            creamToppingCounter++;
            creamCounter.setText(String.valueOf(creamToppingCounter));
        }
    }
    public void removeCream(ActionEvent actionEvent) {

    }

    public void addWhippedCream(ActionEvent actionEvent){
        unsortedToppings.add(3);
        if(unsortedToppings.contains(3)){
            whippedCreamToppingCounter++;
            whippedCreamCounter.setText(String.valueOf(whippedCreamToppingCounter));
        }
    }

    public void removeWhippedCream(ActionEvent actionEvent) {

    }

    public void cancelSelection(ActionEvent actionEvent) {
        Stage stage = (Stage) backButton.getScene().getWindow();
        enableAllButtons();
        stage.close();
    }


    public void addToCart(ActionEvent actionEvent) {
        int[] intToppingsArray = unsortedToppings.stream().mapToInt(Integer::intValue).toArray();
        new AddToCartCommand(0,intToppingsArray).execute(c);
    }

}
