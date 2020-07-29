package kizilay.yusuf.airline_management_system.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "airline")
public class Airline {

  @Id @GeneratedValue
  @Column(name = "airline_id")
  private int airlineId;

  private String name;

  @OneToMany(mappedBy = "airline", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private List<Flight> flights;

  public int getAirlineId() {
    return airlineId;
  }

  public void setAirlineId(int airlineId) {
    this.airlineId = airlineId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Flight> getFlights() {
    return flights;
  }

  public void setFlights(List<Flight> flights) {
    this.flights = flights;
  }
}
