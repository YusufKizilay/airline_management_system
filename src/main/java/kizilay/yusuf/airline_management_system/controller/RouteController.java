package kizilay.yusuf.airline_management_system.controller;

import kizilay.yusuf.airline_management_system.entity.Airline;
import kizilay.yusuf.airline_management_system.entity.Route;
import kizilay.yusuf.airline_management_system.resource.AirlineResource;
import kizilay.yusuf.airline_management_system.resource.Response;
import kizilay.yusuf.airline_management_system.resource.RouteResource;
import kizilay.yusuf.airline_management_system.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
public class RouteController extends BaseController {

    private RouteService routeService;

    @Autowired
    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @PostMapping("/route")
    public ResponseEntity<Response> addAirline(@RequestBody RouteResource routeResource) {
        Route routeToAdd = Objects.nonNull(routeResource) ? routeResource.toEntity() : null;

        if(Objects.isNull(routeToAdd)){
            return null;
        }

        int routeIdId=routeService.saveRoute(routeToAdd);

        return new ResponseEntity<>(new Response(routeIdId,ROUTE_RESOURCE_PARTH), HttpStatus.CREATED);

    }

    @GetMapping("/route/{routeId}")
    public ResponseEntity<RouteResource> findAirline(@PathVariable String routeId) {
        if(Objects.isNull(routeId)){
            return null;
        }

        Route route= routeService.findRoute(Integer.valueOf(routeId));

        return new ResponseEntity<>(route.toResource(), HttpStatus.OK);

    }
}
