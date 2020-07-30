package kizilay.yusuf.airline_management_system.exception;

public class RouteNotFoundException extends BaseException {
    public RouteNotFoundException(String message, Object... args) {
        super(message, args);
    }
}
