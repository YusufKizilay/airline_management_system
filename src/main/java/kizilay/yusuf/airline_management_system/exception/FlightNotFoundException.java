package kizilay.yusuf.airline_management_system.exception;

public class FlightNotFoundException extends BaseException{
    public FlightNotFoundException(String template, Object... args) {
        super(template, args);
    }
}
