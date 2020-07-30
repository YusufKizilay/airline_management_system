package kizilay.yusuf.airline_management_system.service;

import kizilay.yusuf.airline_management_system.entity.Airport;
import kizilay.yusuf.airline_management_system.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirportService {

    private AirportRepository airportRepository;

    @Autowired
    public AirportService(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    public int saveAirport(final Airport airport){
        return this.airportRepository.save(airport);
    }

    public Airport findAirport(final int airportId){
        return this.airportRepository.find(airportId);
    }
}
