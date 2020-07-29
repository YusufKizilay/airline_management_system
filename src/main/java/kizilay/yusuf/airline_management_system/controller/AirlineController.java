package kizilay.yusuf.airline_management_system.controller;

import kizilay.yusuf.airline_management_system.entity.Airline;
import kizilay.yusuf.airline_management_system.entity.Flight;
import kizilay.yusuf.airline_management_system.resource.AirlineResource;
import kizilay.yusuf.airline_management_system.resource.FlightResource;
import kizilay.yusuf.airline_management_system.resource.Response;
import kizilay.yusuf.airline_management_system.service.AirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
public class AirlineController extends BaseController {

    private AirlineService airlineService;

    @Autowired
    public AirlineController(AirlineService airlineService) {
        this.airlineService = airlineService;
    }

    @PostMapping("/airline")
    public ResponseEntity<Response> addAirline(@RequestBody AirlineResource airlineResource) {
        Airline airlineToAdd = Objects.nonNull(airlineResource) ? airlineResource.toEntity() : null;

        if (Objects.isNull(airlineToAdd)) {
            return null;
        }

        int airlineId = airlineService.saveAirline(airlineToAdd);

        return new ResponseEntity<>(new Response(airlineId, AIRLINE_RESOURCE_PATH), HttpStatus.CREATED);

    }

    @GetMapping("/airline/{airlineId}")
    public ResponseEntity<AirlineResource> findAirline(@PathVariable String airlineId) {
        if (Objects.isNull(airlineId)) {
            return null;
        }

        Airline airline = airlineService.findAirline(Integer.valueOf(airlineId));

        return new ResponseEntity<>(airline.toResource(), HttpStatus.OK);

    }

    @PostMapping("/airline/{airlineId}/flight")
    public ResponseEntity<Response> addFlight(@PathVariable String airlineId, @RequestBody FlightResource flightResource) {
        Flight flightToAdd = Objects.nonNull(flightResource) ? flightResource.toEntity() : null;

        if (Objects.isNull(airlineId) || Objects.isNull(flightResource)) {
            return null;
        }

        Airline airline = airlineService.findAirline(Integer.valueOf(airlineId));
        flightToAdd.setAirline(airline);

        int flightId = airlineService.saveFlight(flightToAdd);

        return new ResponseEntity<>(new Response(flightId, FLIGHT_RESOURCE_PATH), HttpStatus.OK);
    }

    @GetMapping("/airline/{airlineId}/flight/{flightId}")
    public ResponseEntity<FlightResource> findFlight(@PathVariable String airlineId, @PathVariable String flightId) {
        if (Objects.isNull(airlineId) || Objects.isNull(flightId)) {
            return null;
        }

        Flight flight=  airlineService.findFlight(Integer.valueOf(flightId));

        return new ResponseEntity<>(flight.toResource(), HttpStatus.OK);
    }

    @PostMapping("/airline/{airlineId}/flight/{flightId}/ticket")
    public void buyTicket() {

    }

    @GetMapping("/airline/{airlineId}/flight/{flightId}/ticket/{ticketId}")
    public void findTicket(String airlineId, String flightId, String ticketId) {

    }

    @PutMapping("/airline/{airlineId}/flight/{flightId}/ticket/{ticketId}")
    public void cancelTicket() {

    }

}
