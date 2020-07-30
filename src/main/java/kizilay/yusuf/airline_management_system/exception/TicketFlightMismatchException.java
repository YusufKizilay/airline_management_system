package kizilay.yusuf.airline_management_system.exception;

public class TicketFlightMismatchException extends BaseException {
    public TicketFlightMismatchException(String template, Object... args) {
        super(template, args);
    }
}
