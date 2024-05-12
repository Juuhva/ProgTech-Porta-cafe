package portacafe.core.exceptions;

public class CantAddToppingException extends PortaCafeException {
    public CantAddToppingException() {
        super("Can't add topping");
    }
}
