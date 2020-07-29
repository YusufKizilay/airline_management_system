package kizilay.yusuf.airline_management_system.service;

import kizilay.yusuf.airline_management_system.entity.Airline;
import kizilay.yusuf.airline_management_system.entity.Flight;
import kizilay.yusuf.airline_management_system.repository.AirlineRepository;
import kizilay.yusuf.airline_management_system.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirlineService {

    private AirlineRepository airlineRepository;
    private FlightRepository flightRepository;

    @Autowired
    public AirlineService(AirlineRepository airlineRepository, FlightRepository flightRepository) {
        this.airlineRepository = airlineRepository;
        this.flightRepository = flightRepository;
    }

    public int saveAirline(final Airline airline) {
        return this.airlineRepository.save(airline);
    }

    public Airline findAirline(final int airlineId) {
        return this.airlineRepository.find(airlineId);
    }

    public int saveFlight(final Flight flight) {
        return this.flightRepository.save(flight);
    }

    public Flight findFlight(int flightId){
        return  this.flightRepository.find(flightId);
    }
}
