package portacafe.database.exceptions;

public class ItemNotFoundInCartException extends PortaCafeDBException {
    public ItemNotFoundInCartException() {
        super("A kosár nem tartalmazza ezt az elemet.");
    }
}
