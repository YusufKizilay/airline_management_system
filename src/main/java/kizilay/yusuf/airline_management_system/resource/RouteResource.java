package kizilay.yusuf.airline_management_system.resource;

import kizilay.yusuf.airline_management_system.entity.Airport;
import kizilay.yusuf.airline_management_system.entity.Route;

public class RouteResource extends  BaseResource<Route> {

    private Airport source;

    private Airport destination;

    public RouteResource() {
    }

    public RouteResource(Airport source, Airport destination) {
        this.source = source;
        this.destination = destination;
    }

    public Airport getSource() {
        return source;
    }

    public void setSource(Airport source) {
        this.source = source;
    }

    public Airport getDestination() {
        return destination;
    }

    public void setDestination(Airport destination) {
        this.destination = destination;
    }

    @Override
    public Route toEntity() {
        return new Route(this.source, this.destination);
    }
}
