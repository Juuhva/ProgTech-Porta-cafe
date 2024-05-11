package portacafe.database.commands;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import portacafe.database.SqliteConnection;
import portacafe.database.exceptions.ItemNotFoundInCartException;
import portacafe.dialogs.MessageDialog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RemoveFromCartCommand implements SqliteCommand {
    private static final Logger log = LogManager.getLogger(RemoveFromCartCommand.class);

    private int orderedCoffeeId;

    public RemoveFromCartCommand(int orderedCoffeeId) {
        this.orderedCoffeeId = orderedCoffeeId;
    }

    @Override
    public void execute(Connection connection) {
        try {
            PreparedStatement stmt;

            stmt = connection.prepareStatement(
                    "SELECT COUNT(*) FROM Cart WHERE OrderedCoffeeID = ?;");
            stmt.setInt(1, orderedCoffeeId);
            int count = stmt.executeQuery().getInt(1);
            if(count == 0)
                throw new ItemNotFoundInCartException();

            stmt = connection.prepareStatement(
                    "DELETE FROM OrderedCoffees WHERE ID = ?");
            stmt.setInt(1, orderedCoffeeId);
            stmt.execute();

            connection.commit();
            log.log(Level.INFO, String.format("A(z) %d ID-jű kávé törölve lett a kosárból.",
                    orderedCoffeeId));
        }
        catch(SQLException ex) {
            log.log(Level.ERROR, ex.getLocalizedMessage());
            MessageDialog.showError("Nem sikerült törölni a kávét a kosárból.");
        }
    }
}
