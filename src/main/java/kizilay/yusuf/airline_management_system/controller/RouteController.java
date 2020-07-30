package kizilay.yusuf.airline_management_system.controller;

import kizilay.yusuf.airline_management_system.entity.Airport;
import kizilay.yusuf.airline_management_system.entity.Route;
import kizilay.yusuf.airline_management_system.exception.AirportNotFoundException;
import kizilay.yusuf.airline_management_system.exception.ArgumentMissingException;
import kizilay.yusuf.airline_management_system.resource.Response;
import kizilay.yusuf.airline_management_system.resource.RouteResource;
import kizilay.yusuf.airline_management_system.service.AirportService;
import kizilay.yusuf.airline_management_system.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
public class RouteController extends BaseController {

    private RouteService routeService;

    private AirportService airportService;

    @Autowired
    public RouteController(RouteService routeService, AirportService airportService) {
        this.routeService = routeService;
        this.airportService = airportService;
    }

    @PostMapping("/route")
    public ResponseEntity<Response> addAirline(@RequestBody RouteResource routeResource) {
        int sourceAirportId = routeResource.getSourceAirportId();
        int destinationAirportId = routeResource.getDestinationAirportId();

        if (Objects.isNull(sourceAirportId) || Objects.isNull(destinationAirportId)) {
            throw new ArgumentMissingException("sourceAirportId = %d and destinationAirportId = %d should be provided ", sourceAirportId, destinationAirportId);
        }

        Airport sourceAirport = airportService.findAirport(sourceAirportId);
        Airport destinationAirport = airportService.findAirport(destinationAirportId);

        if (Objects.isNull(sourceAirport) || Objects.isNull(destinationAirport)) {
            throw new AirportNotFoundException("Source and destination airports should be provided. Missing airport : %s ",
                    Objects.isNull(sourceAirport) ? "source airport" : "destination airport");
        }

        int routeId = routeService.saveRoute(new Route(sourceAirport, destinationAirport));

        return new ResponseEntity<>(new Response(routeId, createPath(ROUTE_RESOURCE_PATH,routeId)), HttpStatus.CREATED);

    }

    @GetMapping("/route/{routeId}")
    public ResponseEntity<RouteResource> findAirline(@PathVariable int routeId) {
        Route route = routeService.findRoute(routeId);

        if(Objects.isNull(route)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(route.toResource(), HttpStatus.OK);

    }
}
