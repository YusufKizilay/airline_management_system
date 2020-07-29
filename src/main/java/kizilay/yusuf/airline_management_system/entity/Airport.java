package kizilay.yusuf.airline_management_system.entity;

import kizilay.yusuf.airline_management_system.resource.AirportResource;

import javax.persistence.*;

@Entity
@Table(name = "airport")
public class Airport extends BaseEntity<AirportResource> {

    @Id
    @GeneratedValue
    @Column(name = "airport_id")
    private int airportId;

    private String name;

    private String country;

    private String city;

    public Airport() {
    }

    public Airport(String name, String country, String city) {
        this.name = name;
        this.country = country;
        this.city = city;
    }

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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public AirportResource toResource() {
        return new AirportResource(this.name, this.city, this.country);
    }
}
