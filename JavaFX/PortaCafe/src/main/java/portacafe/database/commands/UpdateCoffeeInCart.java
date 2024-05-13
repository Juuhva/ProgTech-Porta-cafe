package portacafe.database.commands;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.Message;
import portacafe.database.SqliteConnection;
import portacafe.database.exceptions.ItemNotFoundInCartException;
import portacafe.dialogs.MessageDialog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateCoffeeInCart implements SqliteCommand {
    private static final Logger log = LogManager.getLogger(UpdateCoffeeInCart.class);

    int orderedCoffeeId;
    int[] unsortedToppings;

    public UpdateCoffeeInCart(int orderedCoffeeId, int[] unsortedToppings) {
        this.orderedCoffeeId = orderedCoffeeId;
        this.unsortedToppings = unsortedToppings;
    }

    @Override
    public void execute(Connection connection) {
        try {
            PreparedStatement stmt;

            stmt = connection.prepareStatement(
                    "SELECT COUNT(*) FROM Cart WHERE OrderedCoffeeID = ?;");
            stmt.setInt(1, orderedCoffeeId);
            int count = stmt.executeQuery().getInt(1);
            if(count == 0)
                throw new ItemNotFoundInCartException();

            stmt = connection.prepareStatement(
                    "DELETE FROM ToppingsOnOrderedCoffee Where OrderedCoffeeID = ?");
            stmt.setInt(1, orderedCoffeeId);
            stmt.execute();
            log.log(Level.INFO, String.format("A(z) %d. ID-jű kávé feltétei ürítve lettek.",
                    orderedCoffeeId));

            if(unsortedToppings.length > 0) {
                InsertToppingsRawCommand insertToppings =
                        new InsertToppingsRawCommand(orderedCoffeeId, unsortedToppings);
                insertToppings.execute(connection);
                insertToppings.receiveErrorIfAny();
            }

            connection.commit();
            log.log(Level.INFO, String.format("A(z) %d. ID-jű kávé módosítva lett a kosárban.",
                    orderedCoffeeId));
        } catch(SQLException ex) {
            log.log(Level.ERROR, ex.getLocalizedMessage());
            MessageDialog.showError("Nem sikerült módosítani a kávé tartalmát.");
        }
    }
}
