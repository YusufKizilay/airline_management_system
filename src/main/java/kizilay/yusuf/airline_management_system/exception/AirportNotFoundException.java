package kizilay.yusuf.airline_management_system.exception;

public class AirportNotFoundException extends BaseException {
    public AirportNotFoundException(String template, Object... args) {
        super(template, args);
    }
}
