package portacafe.database.commands;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import portacafe.database.SqliteConnection;
import portacafe.database.datastructures.OrderEntry;
import portacafe.database.datastructures.OrderedCoffeeEntry;
import portacafe.dialogs.MessageDialog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ListOrdersCommand implements SqliteQueryCommand<OrderEntry>{
    private static final Logger log = LogManager.getLogger(ListOrdersCommand.class);

    private List<OrderEntry> orders = new ArrayList<>();

    @Override
    public List<OrderEntry> getQueryResults() {
        return orders;
    }
    @Override
    public void execute(Connection connection) {
        try {
            PreparedStatement stmt;

            stmt = connection.prepareStatement(
                    "SELECT * FROM Orders;");
            ResultSet ordersSet = stmt.executeQuery();

            while(ordersSet.next()) {
                OrderEntry entry = new OrderEntry();
                entry.orderId = ordersSet.getInt("ID");
                entry.orderedAt = ordersSet.getTimestamp("OrderedAt");
                entry.completed = ordersSet.getBoolean("Completed");

                addOrderedCoffeesIntoOrder(connection, entry);

                orders.add(entry);
            }

            ordersSet.close();

        } catch(SQLException ex) {
            log.log(Level.ERROR, ex.getLocalizedMessage());
            MessageDialog.showError("Nem sikerült kilistázni a rendeléseket.");
            throw new RuntimeException(ex);
        }
    }
    private void addOrderedCoffeesIntoOrder(Connection connection, OrderEntry entry)
        throws SQLException {
        PreparedStatement stmt;

        stmt = connection.prepareStatement(
                "SELECT OrderedCoffeeID FROM CoffeesInOrder WHERE OrderID=?;");
        stmt.setInt(1, entry.orderId);
        ResultSet orderedCoffeesSet = stmt.executeQuery();

        while(orderedCoffeesSet.next()) {
            int orderedCoffee = orderedCoffeesSet.getInt("OrderedCoffeeID");
            GetOrderedCoffeeEntryRawCommand cmd =
                    new GetOrderedCoffeeEntryRawCommand(orderedCoffee);
            cmd.execute(connection);
            entry.orderedCoffees.add(cmd.getResult());
        }
    }
}
