package portacafe.database.commands;

public interface SqliteInsertCommand<E> extends SqliteCommand {
    E getID();
}
