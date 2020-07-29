package kizilay.yusuf.airline_management_system.entity;

import javax.persistence.*;

@Entity
@Table(name = "airport")
public class Airport {

    @Id
    @GeneratedValue
    @Column(name = "airport_id")
    private int airportId;

    private String name;

    private String city;

    public int getAirportId() {
        return airportId;
    }

    public void setAirportId(int airportId) {
        this.airportId = airportId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
