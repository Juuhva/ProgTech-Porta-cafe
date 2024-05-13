package portacafe.database.commands;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import portacafe.database.SqliteConnection;
import portacafe.database.datastructures.OrderedCoffeeEntry;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class AddToCartCommandTest {
    static Connection connection;

    @BeforeAll
    static void initializeDatabase() throws SQLException {
        connection = SqliteConnection.getDebugConnection();
    }
    @AfterAll
    static void closeDatabase() throws SQLException {
        connection.close();
    }


    @Test
    void on_addToCart_newOrderedCoffeeShowsUpIn_ListCartContentCommand() {
        int orderedCoffeeId = createNewOrderedCoffee();

        SqliteQueryCommand<OrderedCoffeeEntry> cmd = new ListCartContentCommand();
        cmd.execute(connection);

        OrderedCoffeeEntry expectedEntry = new OrderedCoffeeEntry();
        expectedEntry.orderedCoffeeId = orderedCoffeeId;

        assertTrue(cmd.getQueryResults().contains(expectedEntry));
    }
    int createNewOrderedCoffee() {
        SqliteInsertCommand<Integer> cmd = new AddToCartCommand(0, new int[]{0});
        cmd.execute(connection);

        return cmd.getID();
    }
}