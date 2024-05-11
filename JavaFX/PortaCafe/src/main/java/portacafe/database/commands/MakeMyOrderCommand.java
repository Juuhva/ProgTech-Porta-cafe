package portacafe.database.commands;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import portacafe.database.SqliteConnection;
import portacafe.database.exceptions.CartIsEmptyException;
import portacafe.database.exceptions.ItemNotFoundInCartException;
import portacafe.dialogs.MessageDialog;

import javax.xml.transform.Result;
import java.sql.*;

public class MakeMyOrderCommand implements SqliteInsertCommand<Integer> {
    private static final Logger log = LogManager.getLogger(MakeMyOrderCommand.class);

    private int orderId = -1;

    @Override
    public Integer getID() {
        return orderId;
    }
    @Override
    public void execute(Connection connection) {
        try {
            PreparedStatement stmt;

            stmt = connection.prepareStatement(
                    "SELECT COUNT(*) FROM Cart;");
            int count = stmt.executeQuery().getInt(1);
            if(count == 0)
                throw new CartIsEmptyException();

            stmt = connection.prepareStatement(
                    "INSERT INTO Orders(Completed) VALUES (False)",
                    PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            orderId = rs.getInt(1);

            log.log(Level.INFO, String.format("Rendelés inicializálva (rendelés kódja: %d)",
                    orderId));

            insertCoffeesIntoOrder(connection);

            stmt = connection.prepareStatement(
                    "DELETE FROM Cart;");
            stmt.execute();
            log.log(Level.INFO, "A kosár tartalma kiürítve.");

            connection.commit();
            log.log(Level.INFO, String.format("Rendelés létrehozva (rendelés kódja: %d)",
                    orderId));
        } catch(SQLException ex) {
            log.log(Level.ERROR, ex.getLocalizedMessage());
            MessageDialog.showError("Nem sikerült elkészíteni a rendelést.");
            orderId = -1;
        }
    }
    private void insertCoffeesIntoOrder(Connection connection) throws SQLException {
        PreparedStatement stmt;
        stmt = connection.prepareStatement(
                "SELECT * FROM Cart;");
        ResultSet cartContent = stmt.executeQuery();

        while(cartContent.next()) {
            int orderedCoffeeId = cartContent.getInt("OrderedCoffeeID");

            stmt = connection.prepareStatement(
                    "INSERT INTO CoffeesInOrder VALUES(?, ?);");
            stmt.setInt(1, orderId);
            stmt.setInt(2, orderedCoffeeId);

            stmt.execute();
            log.log(Level.INFO, String.format("A(z) %d ID-jű rendelésbe belekerült a(z) %d ID-jű kávé.",
                    orderId, orderedCoffeeId));
        }
    }

    public static void main(String[] args) throws SQLException {
        SqliteInsertCommand<Integer> cmd =
                new MakeMyOrderCommand();
        cmd.execute(SqliteConnection.getConnection());
        log.log(Level.INFO, cmd.getID());
    }
}
