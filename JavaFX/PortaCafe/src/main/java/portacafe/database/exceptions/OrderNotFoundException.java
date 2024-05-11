package portacafe.database.exceptions;

public class OrderNotFoundException extends PortaCafeDBException {
    public OrderNotFoundException() {
        super("Nem rendelkezik egy rendelés sem ilyen azonosítóval.");
    }
}
