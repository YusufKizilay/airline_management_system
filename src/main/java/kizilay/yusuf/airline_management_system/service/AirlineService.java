package kizilay.yusuf.airline_management_system.service;

import kizilay.yusuf.airline_management_system.entity.Airline;
import kizilay.yusuf.airline_management_system.entity.Flight;
import kizilay.yusuf.airline_management_system.entity.Ticket;
import kizilay.yusuf.airline_management_system.repository.AirlineRepository;
import kizilay.yusuf.airline_management_system.repository.FlightRepository;
import kizilay.yusuf.airline_management_system.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirlineService {

    private AirlineRepository airlineRepository;
    private FlightRepository flightRepository;
    private TicketRepository ticketRepository;

    @Autowired
    public AirlineService(AirlineRepository airlineRepository, FlightRepository flightRepository, TicketRepository ticketRepository) {
        this.airlineRepository = airlineRepository;
        this.flightRepository = flightRepository;
        this.ticketRepository = ticketRepository;
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

    public Flight findFlight(int flightId) {
        return this.flightRepository.find(flightId);
    }

    public Flight updateFlight(final Flight flight){
        return this.updateFlight(flight);
    }

    public int saveTicket(final Ticket ticket) {
        return this.ticketRepository.save(ticket);
    }

    public Ticket findTicket(int ticketId) {
        return this.ticketRepository.find(ticketId);
    }

    public int updateTicket(final Ticket ticket) {
        return this.ticketRepository.update(ticket);
    }
}
