package kizilay.yusuf.airline_management_system.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kizilay.yusuf.airline_management_system.resource.FlightResource;

import javax.persistence.*;

@Entity
@Table(name = "flight")
public class Flight extends BaseEntity<FlightResource> {

  @Id @GeneratedValue
  @Column(name = "flight_id")
  private int flightId;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "airline_id")
  private Airline airline;

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

  @Override
  @JsonIgnore
  public int getId() {
    return this.flightId;
  }

  @Override
  public FlightResource toResource() {
    return null;
  }
}
