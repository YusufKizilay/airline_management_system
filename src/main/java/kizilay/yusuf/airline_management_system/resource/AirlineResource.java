package kizilay.yusuf.airline_management_system.resource;

import kizilay.yusuf.airline_management_system.entity.Airline;

import java.util.Date;

public class AirlineResource extends BaseResource<Airline>{
    private static final String RESOURCE="/airline_management_system/airline/%d";

    private String airlineName;

    private Date establishmentDate;


    public AirlineResource() {
    }

    public AirlineResource(final Airline airline) {
        super(RESOURCE,airline.getAirlineId());
        this.airlineName = airline.getName();
        this.establishmentDate = airline.getEstablishmentDate();
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public Date getEstablishmentDate() {
        return establishmentDate;
    }

    public void setEstablishmentDate(Date establishmentDate) {
        this.establishmentDate = establishmentDate;
    }

    @Override
    public Airline toEntity() {
        return new Airline(airlineName,establishmentDate);
    }

}
