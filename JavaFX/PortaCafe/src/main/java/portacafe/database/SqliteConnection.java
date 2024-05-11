package portacafe.database;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public final class SqliteConnection {
    private static final String CONNECTION_STRING = "jdbc:sqlite:coffeeDB.sqlite";
    private static final Logger LOGGER = LogManager.getLogger(SqliteConnection.class);

    private static Connection connection = null;

    public static Connection getConnection() throws SQLException {
        try {
            connection = DriverManager.getConnection(CONNECTION_STRING);
            LOGGER.log(Level.INFO, "Sikeres csatlakozás az adatbázishoz");
        } catch(SQLException ex) {
            LOGGER.log(
                    Level.ERROR,
                    String.format("Nem sikerült csatlakozni az adatbázishoz! (%s: %s)", ex.getErrorCode(), ex.getSQLState()));
            throw ex;
        }

        return connection;
    }
}