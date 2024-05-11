package portacafe.database;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.sqlite.SQLiteConfig;

import java.sql.*;
import java.util.Properties;

public final class SqliteConnection {
    private static final String CONNECTION_STRING = "jdbc:sqlite:coffeeDB.sqlite";

    private static final Logger log = LogManager.getLogger(SqliteConnection.class);
    private static Connection connection = null;

    public static Connection getConnection() throws SQLException {
        try {
            connection = DriverManager.getConnection(
                    CONNECTION_STRING,
                    getConfigProperties());
            connection.setAutoCommit(false);
            log.log(Level.INFO, "Sikeres csatlakozás az adatbázishoz");
        } catch(SQLException ex) {
            log.log(
                    Level.ERROR,
                    String.format("Nem sikerült csatlakozni az adatbázishoz! (%s: %s)",
                            ex.getErrorCode(), ex.getSQLState()));
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