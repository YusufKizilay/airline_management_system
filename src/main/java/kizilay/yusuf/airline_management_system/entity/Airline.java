package kizilay.yusuf.airline_management_system.entity;

import kizilay.yusuf.airline_management_system.resource.AirlineResource;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "airline")
public class Airline extends BaseEntity<AirlineResource> {

  @Id @GeneratedValue
  @Column(name = "airline_id")
  private int airlineId;

  private String name;

  @Column(name = "establishment_date")
  private Date establishmentDate;

  @OneToMany(mappedBy = "airline", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private List<Flight> flights;

  public Airline() {
  }

  public Airline(String name, Date establishmentDate) {
    this.name = name;
    this.establishmentDate = establishmentDate;
  }

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

  public Date getEstablishmentDate() {
    return establishmentDate;
  }

  public void setEstablishmentDate(Date establishmentDate) {
    this.establishmentDate = establishmentDate;
  }

  public List<Flight> getFlights() {
    return flights;
  }

  public void setFlights(List<Flight> flights) {
    this.flights = flights;
  }

  @Override
  public AirlineResource toResource() {
    return new AirlineResource(this.name, this.establishmentDate);
  }
}
