package portacafe.core.exceptions;

import portacafe.database.exceptions.PortaCafeDBException;

public class CantBrewCoffeeException extends PortaCafeException {
    public CantBrewCoffeeException() {
        super("Can't brew coffee");
    }
}
