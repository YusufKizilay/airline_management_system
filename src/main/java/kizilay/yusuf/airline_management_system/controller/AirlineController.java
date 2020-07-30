package kizilay.yusuf.airline_management_system.controller;

import kizilay.yusuf.airline_management_system.entity.*;
import kizilay.yusuf.airline_management_system.exception.*;
import kizilay.yusuf.airline_management_system.resource.AirlineResource;
import kizilay.yusuf.airline_management_system.resource.FlightResource;
import kizilay.yusuf.airline_management_system.resource.Response;
import kizilay.yusuf.airline_management_system.resource.TicketResource;
import kizilay.yusuf.airline_management_system.service.AirlineService;
import kizilay.yusuf.airline_management_system.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
public class AirlineController extends BaseController {

    private AirlineService airlineService;

    private RouteService routeService;

    @Autowired
    public AirlineController(AirlineService airlineService, RouteService routeService) {
        this.airlineService = airlineService;
        this.routeService = routeService;
    }

    @PostMapping("/airline")
    public ResponseEntity<Response> addAirline(@RequestBody AirlineResource airlineResource) {
        Airline airlineToAdd = airlineResource.toEntity();

        int airlineId = airlineService.saveAirline(airlineToAdd);

        return new ResponseEntity<>(new Response(airlineId, createPath(AIRLINE_RESOURCE_PATH, airlineId)), HttpStatus.CREATED);
    }

    @GetMapping("/airline/{airlineId}")
    public ResponseEntity<AirlineResource> findAirline(@PathVariable Integer airlineId) {
        Airline airline = airlineService.findAirline(Integer.valueOf(airlineId));

        if(Objects.isNull(airline)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(airline.toResource(), HttpStatus.OK);

    }

    @PostMapping("/airline/{airlineId}/flight")
    public ResponseEntity<Response> addFlight(@PathVariable Integer airlineId, @RequestBody FlightResource flightResource) {

        Flight flightToAdd = flightResource.toEntity();
        int routeId = flightResource.getRouteId();

        Route route = routeService.findRoute(routeId);

        if (Objects.isNull(route)) {
            throw new RouteNotFoundException("No route is found for identifier %d . Flight can not be added.",routeId);
        }

        flightToAdd.setRoute(route);
        Airline airline = airlineService.findAirline(airlineId);
        airline.addFlight(flightToAdd);

        int flightId = airlineService.saveFlight(flightToAdd);


        return new ResponseEntity<>(new Response(flightId, createPath(FLIGHT_RESOURCE_PATH, airlineId,flightId)), HttpStatus.CREATED);
    }

    @GetMapping("/airline/{airlineId}/flight/{flightId}")
    public ResponseEntity<FlightResource> findFlight(@PathVariable int airlineId, @PathVariable int flightId) {
        Airline airline = airlineService.findAirline(airlineId);

        Flight flight = airline.getFlights().stream().filter(f -> f.getFlightId() == flightId).findFirst().orElse(null);


        if(Objects.isNull(flight)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(flight.toResource(), HttpStatus.OK);
    }

    @PutMapping("/airline/{airlineId}/flight/{flightId}")
    public ResponseEntity<FlightResource> extendCapacity(@PathVariable int airlineId, @PathVariable int flightId, @RequestParam double extendCapacity) {
        Airline airline = airlineService.findAirline(airlineId);

        Flight flight = airline.getFlights().stream().filter(f -> f.getFlightId() == flightId).findFirst().orElse(null);

        if (Objects.isNull(flight)) {
            throw new FlightNotFoundException("No flight is found for airline id : %d and flight id : %d", airline,flightId);
        }

        flight.extendCapacity(extendCapacity);

        airlineService.updateFlight(flight);

        return new ResponseEntity<>(flight.toResource(), HttpStatus.OK);
    }

    @PostMapping("/airline/{airlineId}/flight/{flightId}/ticket")
    public ResponseEntity<Response> buyTicket(@PathVariable int airlineId, @PathVariable int flightId, @RequestBody TicketResource ticketResource) {

        Airline airline = airlineService.findAirline(airlineId);

        Flight flight = airline.getFlights().stream().filter(f -> f.getFlightId() == flightId).findFirst().orElse(null);

        if (Objects.isNull(flight)) {
            throw new FlightNotFoundException("No flight is found for airline id : %d and flight id : %d", airline,flightId);
        }

        Ticket ticket = ticketResource.toEntity();

        ticket.setFlight(flight);

        ticket.setTicketStatus(TicketStatus.ACTIVE);

        int ticketId = airlineService.saveTicket(ticket);

        return new ResponseEntity<>(new Response(ticketId, createPath(TICKET_RESOURCE_PATH, airlineId,flightId,ticketId)), HttpStatus.CREATED);
    }

    @GetMapping("/airline/{airlineId}/flight/{flightId}/ticket/{ticketId}")
    public ResponseEntity<TicketResource> findTicket(@PathVariable Integer airlineId, @PathVariable Integer flightId, @PathVariable Integer ticketId) {

        Airline airline = airlineService.findAirline(airlineId);

        Flight flight = airline.getFlights().stream().filter(f -> f.getFlightId() == flightId).findFirst().orElse(null);

        if (Objects.isNull(flight)) {
            throw new FlightNotFoundException("No flight is found for airline id : %d and flight id : %d", airline,flightId);
        }

        Ticket ticket = airlineService.findTicket(ticketId);

        if(Objects.isNull(ticket)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        if (ticket.getFlight().getFlightId() != flightId) {

            throw new TicketFlightMismatchException("Given %d flight does not match the %d ticket!",flightId,ticketId);
        }


        return new ResponseEntity<>(ticket.toResource(), HttpStatus.OK);
    }

    @PutMapping("/airline/{airlineId}/flight/{flightId}/ticket/{ticketId}")
    public ResponseEntity<TicketResource>  cancelTicket(@PathVariable Integer airlineId, @PathVariable Integer flightId, @PathVariable Integer ticketId, @RequestParam String operation) {
        if (!operation.equalsIgnoreCase(TicketStatus.CANCEL.name())) {
           throw new OperationNotSupportedException("This endpoint supports only ticket cancellation operation");
        }

        Airline airline = airlineService.findAirline(airlineId);

        Flight flight = airline.getFlights().stream().filter(f -> f.getFlightId() == flightId).findFirst().orElse(null);

        if (Objects.isNull(flight)) {
            throw new FlightNotFoundException("No flight is found for airline id : %d and flight id : %d", airline,flightId);
        }

        Ticket ticket = airlineService.findTicket(ticketId);

        if(Objects.isNull(ticket)){
            throw new TicketNotFoundException("No ticket is found for airline id : %d and flight id : %d and ticket id: %d", airline,flightId,ticketId);
        }

        if (ticket.getFlight().getFlightId() != flightId) {

            throw new TicketFlightMismatchException("Given %d flight does not match the %d ticket!",flightId,ticketId);
        }

        ticket.setTicketStatus(TicketStatus.CANCEL);

        airlineService.updateTicket(ticket);

        return new ResponseEntity<>(ticket.toResource(), HttpStatus.OK);
    }

}
