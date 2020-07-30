package kizilay.yusuf.airline_management_system.exception;

public abstract class BaseException extends RuntimeException {

    public BaseException(String message) {
        super(message);
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseException(String template, Object... args) {
        super(String.format(template, args));
    }
}
