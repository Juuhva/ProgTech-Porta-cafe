package portacafe.database;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.sqlite.SQLiteConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public final class SqliteConnection {
    private static final String CONNECTION_STRING = "jdbc:sqlite:coffeeDB.sqlite";
    private static final Logger log = LogManager.getLogger(SqliteConnection.class);
    private static Connection connection = null;

    private SqliteConnection() {
    }

    public static Connection getConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            return connection;
        }
        try {
            connection = DriverManager.getConnection(CONNECTION_STRING, getConfigProperties());
            connection.setAutoCommit(false);
            log.log(Level.INFO, "Sikeres csatlakozás az adatbázishoz");
        } catch (SQLException ex) {
            log.log(Level.ERROR, "Nem sikerült csatlakozni az adatbázishoz!", ex);
            throw ex;
        }

        return connection;
    }

    private static Properties getConfigProperties() {
        SQLiteConfig config = new SQLiteConfig();
        config.enforceForeignKeys(true);

        return config.toProperties();
    }
}
