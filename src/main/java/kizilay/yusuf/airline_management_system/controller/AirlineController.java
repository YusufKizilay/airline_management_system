package kizilay.yusuf.airline_management_system.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AirlineController {

  @PostMapping
  public void addAirline() {}

  @GetMapping("/{airlineId}")
  public void findAirline(String airlineId) {}

  @PostMapping("/{airlineId}/flight")
  public void addFlight() {}

  @GetMapping("/{airlineId}/flight/{flightId}")
  public void findFlight(String airlineId, String flightId) {}

  @PostMapping("/{airlineId}/flight/{flightId}/ticket")
  public void buyTicket(){

  }

  @GetMapping("/{airlineId}/flight/{flightId}/ticket/{ticketId}")
  public void findTicket(String airlineId, String flightId, String ticketId){

  }

  @PutMapping("/{airlineId}/flight/{flightId}/ticket/{ticketId}")
  public void cancelTicket(){

  }

}
