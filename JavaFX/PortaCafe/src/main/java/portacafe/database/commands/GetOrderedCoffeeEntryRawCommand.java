package portacafe.database.commands;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import portacafe.database.datastructures.OrderedCoffeeEntry;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class GetOrderedCoffeeEntryRawCommand implements SqliteCommand {
    private static final Logger log = LogManager.getLogger(GetOrderedCoffeeEntryRawCommand.class);


    private int orderedCoffeeId;
    private SQLException thrownException = null;
    private OrderedCoffeeEntry result;

    public GetOrderedCoffeeEntryRawCommand(int orderedCoffeeId) {
        this.orderedCoffeeId = orderedCoffeeId;
    }

    public OrderedCoffeeEntry getResult() throws SQLException {
        if(thrownException != null)
            throw thrownException;

        return result;
    }

    @Override
    public void execute(Connection connection) {
        try {
            OrderedCoffeeEntry entry = new OrderedCoffeeEntry();
            entry.orderedCoffeeId = orderedCoffeeId;

            PreparedStatement stmt = connection.prepareStatement(
                    "SELECT ToppingTypeID, ToppingCount FROM ToppingsOnOrderedCoffee WHERE OrderedCoffeeID=?");
            stmt.setInt(1, orderedCoffeeId);

            ResultSet set = stmt.executeQuery();
            while(set.next()) {
                int toppingType = set.getInt("ToppingTypeID");
                int count = set.getInt("ToppingCount");
                entry.toppings.put(toppingType, count);
            }
            set.close();

            result = entry;
        } catch(SQLException ex) {
            thrownException = ex;
        }
    }
}
