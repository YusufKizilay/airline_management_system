package kizilay.yusuf.airline_management_system.resource;

import kizilay.yusuf.airline_management_system.entity.Airport;

public class AirportResource extends BaseResource<Airport> {

    private String name;

    private String city;

    private String country;

    public AirportResource() {
    }

    public AirportResource(String name, String city, String country) {
        this.name = name;
        this.city = city;
        this.country = country;
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
    public Airport toEntity() {
        return new Airport(this.name, this.country, this.city);
    }
}
