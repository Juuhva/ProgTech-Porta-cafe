package portacafe.database.commands;

import java.util.List;

public interface SqliteQueryCommand<E> extends SqliteCommand{
    List<E> getQueryResults();
}
