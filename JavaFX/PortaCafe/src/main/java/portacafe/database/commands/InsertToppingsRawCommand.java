package portacafe.database.commands;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;

class InsertToppingsRawCommand implements SqliteCommand {
    private static final Logger log = LogManager.getLogger(InsertToppingsRawCommand.class);

    private SQLException thrownException = null;
    private int orderedCoffeeId;
    private int[] toppings;

    public InsertToppingsRawCommand(int orderedCoffeeId, int[] unsortedToppings) {
        this.orderedCoffeeId = orderedCoffeeId;

        if(unsortedToppings.length == 0)
            throw new IllegalArgumentException("A feltétek tömbje nem lehet üres.");

        this.toppings = Arrays.stream(unsortedToppings).sorted().toArray();
    }

    public void receiveErrorIfAny() throws SQLException {
        if(thrownException != null)
            throw thrownException;
    }

    @Override
    public void execute(Connection connection) {
        try {
            int currentTopping = toppings[0];
            int toppingCount = 1;
            for (int i = 1; i < toppings.length; i++) {
                if(toppings[i] == currentTopping) {
                    toppingCount++;
                    continue;
                }

                insertTopping(connection, currentTopping, toppingCount);
                currentTopping = toppings[i];
                toppingCount = 1;
            }
            insertTopping(connection, currentTopping, toppingCount);

        } catch(SQLException ex) {
            thrownException = ex;
        }
    }
    private void insertTopping(Connection connection, int toppingType, int count)
            throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(
                "INSERT INTO ToppingsOnOrderedCoffee VALUES (?, ?, ?);");
        stmt.setInt(1, orderedCoffeeId);
        stmt.setInt(2, toppingType);
        stmt.setInt(3, count);

        stmt.execute();

        log.log(Level.INFO, String.format("A(z) %d. ID-jű kávéhoz %d adagnyi, %d ID-jű feltét került.",
                orderedCoffeeId, count, toppingType));
    }
}
