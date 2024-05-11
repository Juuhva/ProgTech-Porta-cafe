package portacafe.database.commands;

import portacafe.database.SqliteConnection;

import java.sql.Connection;
import java.sql.SQLException;

public interface SqliteCommand {
    void execute(Connection connection);
}
