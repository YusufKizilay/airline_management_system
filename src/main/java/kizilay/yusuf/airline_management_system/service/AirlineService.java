package kizilay.yusuf.airline_management_system.service;

import kizilay.yusuf.airline_management_system.entity.Airline;
import kizilay.yusuf.airline_management_system.repository.AirlineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirlineService {

    private AirlineRepository airlineRepository;

    @Autowired
    public AirlineService(AirlineRepository airlineRepository) {
        this.airlineRepository = airlineRepository;
    }

    public int saveAirline(final Airline airline) {
        return this.airlineRepository.saveAirline(airline);
    }

    public  Airline findAirline(final int airlineId){
        return this.airlineRepository.findAirline(airlineId);
    }
}
