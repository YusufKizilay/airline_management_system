package kizilay.yusuf.airline_management_system.resource;

import kizilay.yusuf.airline_management_system.entity.Ticket;
import kizilay.yusuf.airline_management_system.entity.TicketStatus;

public class TicketResource extends BaseResource<Ticket> {

    private static final String RESOURCE="/airline_management_system/airline/%d/flight/%d/ticket/%d";

    private String passenger;

    private CreditCardResource creditCard;

    private TicketStatus ticketStatus;

    private FlightResource flightResource;


    public TicketResource() {
    }

    public TicketResource(final Ticket ticket){
        super(RESOURCE, ticket.getFlight().getAirline().getAirlineId(), ticket.getFlight().getFlightId(), ticket.getTicketId());
        this.passenger = ticket.getPassenger();
        this.creditCard = ticket.getCreditCard().toResource();
        this.ticketStatus = ticket.getTicketStatus();
        this.flightResource = ticket.getFlight().toResource();
    }



    public String getPassenger() {
        return passenger;
    }

    public void setPassenger(String passenger) {
        this.passenger = passenger;
    }

    public CreditCardResource getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCardResource creditCard) {
        this.creditCard = creditCard;
    }

    public TicketStatus getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(TicketStatus ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public FlightResource getFlightResource() {
        return flightResource;
    }

    public void setFlightResource(FlightResource flightResource) {
        this.flightResource = flightResource;
    }


    @Override
    public Ticket toEntity() {
        return new Ticket(this.passenger, this.creditCard.toEntity());
    }
}
