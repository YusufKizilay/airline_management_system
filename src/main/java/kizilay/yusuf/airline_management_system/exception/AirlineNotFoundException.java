package kizilay.yusuf.airline_management_system.exception;

public class AirlineNotFoundException extends BaseException {
    public AirlineNotFoundException(String template, Object... args) {
        super(template, args);
    }
}
