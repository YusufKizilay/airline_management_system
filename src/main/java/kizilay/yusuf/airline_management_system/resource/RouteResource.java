package kizilay.yusuf.airline_management_system.resource;

import kizilay.yusuf.airline_management_system.entity.Route;

public class RouteResource extends BaseResource<Route>{
    private static final String RESOURCE="/airline_management_system/route/%d";

    private int sourceAirportId;

    private int destinationAirportId;

    private AirportResource source;

    private AirportResource destination;

    public RouteResource() {
    }

    public RouteResource(final Route route) {
        super(RESOURCE,route.getRouteId());
        this.sourceAirportId=route.getSource().getAirportId();
        this.destinationAirportId=route.getDestination().getAirportId();
        this.source= route.getSource().toResource();
        this.destination=route.getDestination().toResource();
    }

    public int getSourceAirportId() {
        return sourceAirportId;
    }

    public void setSourceAirportId(int sourceAirportId) {
        this.sourceAirportId = sourceAirportId;
    }

    public int getDestinationAirportId() {
        return destinationAirportId;
    }

    public void setDestinationAirportId(int destinationAirportId) {
        this.destinationAirportId = destinationAirportId;
    }

    public AirportResource getSource() {
        return source;
    }

    public void setSource(AirportResource source) {
        this.source = source;
    }

    public AirportResource getDestination() {
        return destination;
    }

    public void setDestination(AirportResource destination) {
        this.destination = destination;
    }

    @Override
    public Route toEntity() {
        return null;
    }
}
