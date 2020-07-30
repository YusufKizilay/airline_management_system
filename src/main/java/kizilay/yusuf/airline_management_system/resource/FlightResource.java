package kizilay.yusuf.airline_management_system.resource;

import kizilay.yusuf.airline_management_system.entity.Flight;
import kizilay.yusuf.airline_management_system.entity.Route;

import java.util.Date;

public class FlightResource extends BaseResource<Flight> {

    private int capacity;

    private Date flightDate;

    private int routeId;

    private double price;

    private String routeResource;

    private String airlineResource;

    public FlightResource() {
    }

    public FlightResource(int capacity, Date flightDate, int routeId, double price, int airlineId ) {
        this.capacity = capacity;
        this.flightDate = flightDate;
        this.routeId = routeId;
        this.price = price;
        this.routeResource = "/airline_management_system/route/" + routeId ;
        this.airlineResource="/airline_management_system/airline/"+ airlineId;
    }

    public FlightResource(Flight flight) {
        this.capacity = flight.getCapacity();
        this.flightDate = flight.getFlightDate();
        this.routeId = flight.getRoute().getRouteId();
        this.price = flight.getPrice();
        this.routeResource = "/airline_management_system/route/" + this.routeId ;
        this.airlineResource="/airline_management_system/airline/"+ flight.getAirline().getAirlineId();
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

    public String getRouteResource() {
        return routeResource;
    }

    public void setRouteResource(String routeResource) {
        this.routeResource = routeResource;
    }

    public String getAirlineResource() {
        return airlineResource;
    }

    public void setAirlineResource(String airlineResource) {
        this.airlineResource = airlineResource;
    }

    @Override
    public Flight toEntity() {
        return new Flight(this.capacity, this.flightDate, this.price);
    }
}
