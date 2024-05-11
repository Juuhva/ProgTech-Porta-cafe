package portacafe.database.exceptions;

public class CartIsEmptyException extends PortaCafeDBException {
    public CartIsEmptyException() {
        super("A kosár üres; nem lehet a műveletet végrehajtani.");
    }
}
