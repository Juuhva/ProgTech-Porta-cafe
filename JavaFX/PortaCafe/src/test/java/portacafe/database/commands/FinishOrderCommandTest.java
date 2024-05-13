package portacafe.database.commands;

import org.junit.jupiter.api.*;
import portacafe.database.SqliteConnection;
import portacafe.database.datastructures.OrderEntry;
import portacafe.database.exceptions.OrderAlreadyFinishedException;
import portacafe.database.exceptions.OrderNotFoundException;

import java.lang.reflect.Executable;
import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
class FinishOrderCommandTest {
    static Connection connection;

    @BeforeAll
    static void initializeDatabase() throws SQLException {
        connection = SqliteConnection.getDebugConnection();
    }
    @AfterAll
    static void closeDatabase() throws SQLException {
        connection.close();
    }

    int createNewOrder() {
        SqliteCommand cartCmd = new AddToCartCommand(0, new int[] {0});
        cartCmd.execute(connection);

        SqliteInsertCommand<Integer> orderCmd = new MakeMyOrderCommand();
        orderCmd.execute(connection);
        return orderCmd.getID();
    }

    @Test
    void on_nonexistentOrder_throw_OrderNotFoundException() {
        SqliteCommand cmd = new FinishOrderCommand(-1);

        Class<? extends Throwable> expected = OrderNotFoundException.class;
        Assertions.assertThrowsExactly(expected,
                ()->cmd.execute(connection));
    }

    @Test
    void on_alreadyFinishedOrder_throw_OrderAlreadyFinishedException() {
        int orderId = createNewOrder();
        SqliteCommand cmd = new FinishOrderCommand(orderId);
        cmd.execute(connection);

        Class<? extends Throwable> expected = OrderAlreadyFinishedException.class;
        Assertions.assertThrowsExactly(expected,
                ()->cmd.execute(connection));
    }

    @Test
    void on_creatingNewOrder_newOrderShowsUpIn_ListOrdersCommand() {
        int orderId = createNewOrder();
        SqliteQueryCommand<OrderEntry> cmd = new ListOrdersCommand();
        cmd.execute(connection);

        OrderEntry expectedEntry = new OrderEntry();
        expectedEntry.orderId = orderId;

        Assertions.assertTrue(
                cmd.getQueryResults().contains(expectedEntry));
    }
}