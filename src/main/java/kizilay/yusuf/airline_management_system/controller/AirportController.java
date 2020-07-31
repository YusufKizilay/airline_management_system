package kizilay.yusuf.airline_management_system.controller;

import kizilay.yusuf.airline_management_system.entity.Airport;
import kizilay.yusuf.airline_management_system.resource.AirportResource;
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
    public ResponseEntity<AirportResource> addAirport(@RequestBody AirportResource airportResource) {
        Airport airportToAdd = airportResource.toEntity();

        airportService.saveAirport(airportToAdd);

        return new ResponseEntity<>(airportToAdd.toResource(), HttpStatus.CREATED);
    }

    @GetMapping("/airport/{airportId}")
    public ResponseEntity<AirportResource> findAirport(@PathVariable int airportId) {
        Airport airport = airportService.findAirport(Integer.valueOf(airportId));

        if(Objects.isNull(airport)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(airport.toResource(), HttpStatus.OK);
    }

}
