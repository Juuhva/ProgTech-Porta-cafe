package portacafe.database;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.util.concurrent.atomic.AtomicReference;

class SqliteConnectionTest {
    @Test
    void onGetConnection_noExceptionIsThrown() {
        Assertions.assertDoesNotThrow(
                ()->SqliteConnection.getConnection().close());
    }

    @Test
    void onGetDebugConnection_noExceptionIsThrown() {
        Assertions.assertDoesNotThrow(
                ()->SqliteConnection.getDebugConnection().close());
    }
}