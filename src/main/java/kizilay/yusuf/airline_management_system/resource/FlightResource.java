package kizilay.yusuf.airline_management_system.resource;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kizilay.yusuf.airline_management_system.entity.Flight;

import java.util.Date;

public class FlightResource extends BaseResource<Flight> {

    private static final String RESOURCE = "/airline_management_system/airline/%d/flight/%d";

    private int capacity;

    private Date flightDate;

    private int routeId;

    private RouteResource routeResource;

    private AirlineResource airlineResource;


    private double price;

    private double extendCapacity;

    public FlightResource() {
    }

    public FlightResource(Flight flight, double extendCapacity) {
        super(RESOURCE, flight.getAirline().getAirlineId(),flight.getFlightId());
        this.capacity = flight.getCapacity();
        this.flightDate = flight.getFlightDate();
        this.routeId = flight.getRoute().getRouteId();
        this.price = flight.getPrice();
        this.routeResource = flight.getRoute().toResource();
        this.airlineResource = flight.getAirline().toResource();
        if(extendCapacity!=0){
            this.extendCapacity=extendCapacity;
        }
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Date getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(Date flightDate) {
        this.flightDate = flightDate;
    }

    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public RouteResource getRouteResource() {
        return routeResource;
    }

    public void setRouteResource(RouteResource routeResource) {
        this.routeResource = routeResource;
    }

    public AirlineResource getAirlineResource() {
        return airlineResource;
    }

    public void setAirlineResource(AirlineResource airlineResource) {
        this.airlineResource = airlineResource;
    }

    public double getExtendCapacity() {
        return extendCapacity;
    }

    public void setExtendCapacity(double extendCapacity) {
        this.extendCapacity = extendCapacity;
    }

    @Override
    public Flight toEntity() {
        return new Flight(this.capacity, this.flightDate, this.price);
    }
}
