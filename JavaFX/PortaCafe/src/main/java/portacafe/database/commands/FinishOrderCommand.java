package portacafe.database.commands;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import portacafe.database.SqliteConnection;
import portacafe.database.exceptions.OrderAlreadyFinishedException;
import portacafe.database.exceptions.OrderNotFoundException;
import portacafe.dialogs.MessageDialog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FinishOrderCommand implements SqliteCommand {
    private static final Logger log = LogManager.getLogger(FinishOrderCommand.class);

    private int orderId;

    public FinishOrderCommand(int orderId) {
        this.orderId = orderId;
    }

    @Override
    public void execute(Connection connection) {
        try {
            PreparedStatement stmt;

            stmt = connection.prepareStatement(
                    "SELECT * FROM Orders WHERE ID=?;");
            stmt.setInt(1, orderId);
            ResultSet set = stmt.executeQuery();

            if(!set.next())
                throw new OrderNotFoundException();
            if(set.getBoolean("Completed"))
                throw new OrderAlreadyFinishedException();

            stmt = connection.prepareStatement(
                    "UPDATE Orders SET Completed=True WHERE ID=?;");
            stmt.setInt(1, orderId);
            stmt.execute();

            connection.commit();
            log.log(Level.INFO, String.format("A(z) %d ID-jű rendelés véglegesítve lett.",
                    orderId));
        }
        catch(SQLException ex) {
            log.log(Level.ERROR, ex.getLocalizedMessage());
            MessageDialog.showError("Nem sikerült véglegesíteni a rendelést.");
        }
    }

    public static void main(String[] args) throws SQLException {
        new FinishOrderCommand(0)
                .execute(SqliteConnection.getConnection());
    }
}
