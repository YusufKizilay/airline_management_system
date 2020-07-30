package kizilay.yusuf.airline_management_system.exception;

public class ArgumentMissingException extends BaseException{
    public ArgumentMissingException(String template, Object... args) {
        super(template, args);
    }
}
