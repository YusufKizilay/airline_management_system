package kizilay.yusuf.airline_management_system.entity;

import javax.persistence.*;

@Entity
@Table(name = "flight")
public class Flight {

  @Id @GeneratedValue
  @Column(name = "flight_id")
  private int flightId;

  @ManyToOne(fetch = FetchType.LAZY)
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
}
