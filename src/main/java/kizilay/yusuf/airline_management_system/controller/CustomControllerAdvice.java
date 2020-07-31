package kizilay.yusuf.airline_management_system.controller;

import kizilay.yusuf.airline_management_system.exception.*;
import kizilay.yusuf.airline_management_system.resource.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class CustomControllerAdvice {

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<Error> handleCustomException(BaseException ex, WebRequest request) {

        if (ex instanceof RouteNotFoundException || ex instanceof FlightNotFoundException ||
                ex instanceof TicketFlightMismatchException || ex instanceof OperationNotSupportedException ||
                ex instanceof AirportNotFoundException || ex instanceof AirlineNotFoundException) {
            return new ResponseEntity<Error>(new Error(ex), HttpStatus.BAD_REQUEST);
        } else if (ex instanceof DatabaseOperationException) {
            return new ResponseEntity<Error>(new Error(ex), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Error>(new Error(ex), HttpStatus.INTERNAL_SERVER_ERROR);


    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<Error> handleGenericException(Exception ex, WebRequest request) {
        return new ResponseEntity<Error>(new Error(ex), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
