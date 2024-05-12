package portacafe.core.exceptions;

public class PortaCafeException extends RuntimeException {
    public PortaCafeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public PortaCafeException(Throwable cause) {
        super(cause);
    }

    public PortaCafeException(String message, Throwable cause) {
        super(message, cause);
    }

    public PortaCafeException(String message) {
        super(message);
    }

    public PortaCafeException() {
    }
}
