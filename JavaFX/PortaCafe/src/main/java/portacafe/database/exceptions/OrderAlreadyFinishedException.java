package portacafe.database.exceptions;

public class OrderAlreadyFinishedException extends PortaCafeDBException {
    public OrderAlreadyFinishedException() {
        super("A rendelés már véglegesítve lett.");
    }
}
