package kizilay.yusuf.airline_management_system.resource;

import org.apache.commons.lang3.exception.ExceptionUtils;

import java.util.Objects;

public class Error {

    private String message;


    public Error(Exception ex) {
        this.message= Objects.nonNull(ex.getMessage()) ? ex.getMessage() : ExceptionUtils.getMessage(ex);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
