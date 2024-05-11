package portacafe.database.commands;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import portacafe.database.SqliteConnection;
import portacafe.dialogs.MessageDialog;

import java.sql.*;

public class AddToCartCommand implements SqliteInsertCommand<Integer> {
    private static final Logger log = LogManager.getLogger(AddToCartCommand.class);

    private int coffeeType;
    private int[] unsortedToppings;

    private int orderedCoffeeId = -1;

    public AddToCartCommand(int coffeeType, int[] unsortedToppings) {
        this.coffeeType = coffeeType;
        this.unsortedToppings = unsortedToppings;
    }

    @Override
    public void execute(Connection connection) {
        try {
            PreparedStatement stmt;

            stmt = connection.prepareStatement(
                    "INSERT INTO OrderedCoffees(CoffeeType) VALUES(?);",
                        Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, coffeeType);
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            orderedCoffeeId = rs.getInt(1);

            InsertToppingsRawCommand insertToppings =
                    new InsertToppingsRawCommand(orderedCoffeeId, unsortedToppings);
            insertToppings.execute(connection);
            insertToppings.receiveErrorIfAny();

            stmt = connection.prepareStatement(
                    "INSERT INTO Cart VALUES(?)");
            stmt.setInt(1, orderedCoffeeId);
            stmt.execute();

            connection.commit();
            log.log(Level.INFO, String.format("A(z) %d. ID-jű kávé hozzá lett adva a kosárhoz.",
                    orderedCoffeeId));
        } catch(SQLException ex) {
            log.log(Level.ERROR, ex.getLocalizedMessage());
            MessageDialog.showError("Nem sikerült hozzáadni a kávét a kosárhoz");
            orderedCoffeeId = -1;
        }
    }

    @Override
    public Integer getID() {
        return orderedCoffeeId;
    }
}
