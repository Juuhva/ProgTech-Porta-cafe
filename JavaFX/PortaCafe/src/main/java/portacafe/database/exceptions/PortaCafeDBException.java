package portacafe.database.exceptions;

public class PortaCafeDBException extends RuntimeException {
    public PortaCafeDBException() {
    }

    public PortaCafeDBException(String message) {
        super(message);
    }

    public PortaCafeDBException(String message, Throwable cause) {
        super(message, cause);
    }

    public PortaCafeDBException(Throwable cause) {
        super(cause);
    }

    public PortaCafeDBException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
