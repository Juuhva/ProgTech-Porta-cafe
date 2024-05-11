package portacafe.database.commands;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import portacafe.database.SqliteConnection;
import portacafe.database.datastructures.OrderedCoffeeEntry;
import portacafe.dialogs.MessageDialog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ListCartContentCommand implements SqliteQueryCommand<OrderedCoffeeEntry> {
    private static final Logger log = LogManager.getLogger(ListCartContentCommand.class);

    private List<OrderedCoffeeEntry> results = new ArrayList<>();

    @Override
    public List<OrderedCoffeeEntry> getQueryResults() {
        return results;
    }
    @Override
    public void execute(Connection connection) {
        try {
            results.clear();

            PreparedStatement stmt = connection.prepareStatement(
                    "SELECT * FROM Cart;");
            ResultSet set = stmt.executeQuery();
            while(set.next()) {
                GetOrderedCoffeeEntryRawCommand cmd =
                        new GetOrderedCoffeeEntryRawCommand(set.getInt("OrderedCoffeeID"));
                cmd.execute(connection);
                results.add(cmd.getResult());
            }
        } catch(SQLException ex) {
            log.log(Level.ERROR, ex.getLocalizedMessage());
            MessageDialog.showError("Nem sikerült kilistázni a kosarat.");
        }
    }

    public static void main(String[] args) throws SQLException {
        ListCartContentCommand cmd =
                new ListCartContentCommand();
        cmd.execute(SqliteConnection.getConnection());
        List<OrderedCoffeeEntry> entries = cmd.getQueryResults();

        for (int i = 0; i < entries.size(); i++) {
            OrderedCoffeeEntry entry = entries.get(i);
            log.log(Level.INFO, String.format("------%d------",
                    entry.orderedCoffeeId));

            for(Integer type : entry.toppings.keySet()) {
                log.log(Level.INFO, String.format("type %d: %d db",
                        type, entry.toppings.get(type)));
            }
        }
    }
}
