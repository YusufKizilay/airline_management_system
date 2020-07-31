package kizilay.yusuf.airline_management_system.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kizilay.yusuf.airline_management_system.resource.FlightResource;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "flight")
public class Flight extends BaseEntity<FlightResource> {

  @Id @GeneratedValue
  @Column(name = "flight_id")
  private int flightId;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "airline_id")
  private Airline airline;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "route_id")
  private Route route;

  private int capacity;

  private Date flightDate;

  private double price;

  public Flight() {
  }

  public Flight(int capacity, Date flightDate, double price) {
    this.capacity = capacity;
    this.flightDate = flightDate;
    this.price = price;
  }

  public void extendCapacity(double rate){
    int extension= (int) (this.capacity * rate)/100;
    this.capacity= this.capacity + extension;

    this.price = this.price+ (int)(this.price*rate)/100;
  }

  public int getFlightId() {
    return flightId;
  }

  public void setFlightId(int flightId) {
    this.flightId = flightId;
  }

  public Airline getAirline() {
    return airline;
  }

  public void setAirline(Airline airline) {
    this.airline = airline;
  }

  public int getCapacity() {
    return capacity;
  }

  public void setCapacity(int capacity) {
    this.capacity = capacity;
  }

  public Route getRoute() {
    return route;
  }

  public void setRoute(Route route) {
    this.route = route;
  }

  public Date getFlightDate() {
    return flightDate;
  }

  public void setFlightDate(Date flightDate) {
    this.flightDate = flightDate;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  @Override
  @JsonIgnore
  public int getId() {
    return this.flightId;
  }

  @Override
  public FlightResource toResource() {
    return new FlightResource(this,0);
  }

  public FlightResource toResource(double extendCapacity) {
    return new FlightResource(this,extendCapacity);
  }
}
