package kizilay.yusuf.airline_management_system.exception;

public class TicketNotFoundException extends BaseException {
    public TicketNotFoundException(String template, Object... args) {
        super(template, args);
    }
}
