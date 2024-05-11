package portacafe.database.commands;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import portacafe.database.SqliteConnection;
import portacafe.dialogs.MessageDialog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClearCartCommand implements SqliteCommand {
    private static final Logger log = LogManager.getLogger(ClearCartCommand.class);

    @Override
    public void execute(Connection connection) {
        try {
            PreparedStatement stmt;
            stmt = connection.prepareStatement(
                    "DELETE FROM OrderedCoffees WHERE ID IN (SELECT * FROM Cart);");
            stmt.execute();

            connection.commit();
            log.log(Level.INFO, "A kosár tartalmát kiürítették.");
        } catch(SQLException ex) {
            log.log(Level.ERROR, ex.getLocalizedMessage());
            //MessageDialog.showError("Nem sikerült kiüríteni a kosarat.");
        }
    }

    public static void main(String[] args) throws SQLException {
        new ClearCartCommand().execute(SqliteConnection.getConnection());
    }
}
