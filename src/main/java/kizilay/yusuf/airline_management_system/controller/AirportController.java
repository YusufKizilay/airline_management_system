package kizilay.yusuf.airline_management_system.controller;

import kizilay.yusuf.airline_management_system.entity.Airport;
import kizilay.yusuf.airline_management_system.resource.AirportResource;
import kizilay.yusuf.airline_management_system.resource.Response;
import kizilay.yusuf.airline_management_system.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
public class AirportController extends BaseController {

    private AirportService airportService;

    @Autowired
    public AirportController(AirportService airportService) {
        this.airportService = airportService;
    }

    @PostMapping("/airport")
    public ResponseEntity<Response> addAirport(@RequestBody AirportResource airportResource) {
        Airport airportToAdd = Objects.nonNull(airportResource) ? airportResource.toEntity() : null;

        if (Objects.isNull(airportToAdd)) {
            return null;
        }

        int airportId = airportService.saveAirport(airportToAdd);

        return new ResponseEntity<>(new Response(airportId, AIRPORT_RESOURCE_PARTH), HttpStatus.CREATED);
    }

    @GetMapping("/airport/{airportId")
    public ResponseEntity<AirportResource> findAirport(@PathVariable String airportId) {
        if (Objects.isNull(airportId)) {
            return null;
        }

        Airport airport = airportService.findAirport(Integer.valueOf(airportId));

        return new ResponseEntity<>(airport.toResource(), HttpStatus.OK);

    }

}
