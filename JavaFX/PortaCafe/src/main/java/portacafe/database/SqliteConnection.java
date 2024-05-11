package portacafe.database;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class SqliteConnection {
    private static final String CONNECTION_STRING = "jdbc:sqlite:coffeeDB.sqlite";

    private static Logger logger = Logger.getLogger(SqliteConnection.class.getName());
    private static Connection connection = null;

    public static Connection getConnection() throws SQLException {
        try {
            connection = DriverManager.getConnection(CONNECTION_STRING);
            logger.log(Level.INFO, "Sikeres csatlakozás az adatbázishoz");
        } catch(SQLException ex) {
            logger.log(
                    Level.SEVERE,
                    String.format("Nem sikerült csatlakozni az adatbázishoz! (%s: %s)", ex.getErrorCode(), ex.getSQLState()));
            throw ex;
        }

        return connection;
    }
}