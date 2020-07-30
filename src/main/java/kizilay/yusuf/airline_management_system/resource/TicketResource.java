package kizilay.yusuf.airline_management_system.resource;

import kizilay.yusuf.airline_management_system.entity.Ticket;
import kizilay.yusuf.airline_management_system.entity.TicketStatus;

public class TicketResource extends BaseResource<Ticket> {

    private String passenger;

    private CreditCardResource creditCard;

    private TicketStatus ticketStatus;

    private FlightResource flightResource;


    public TicketResource() {
    }

    public TicketResource(String passenger, CreditCardResource creditCard, FlightResource flightResource,TicketStatus ticketStatus) {
        this.passenger = passenger;
        this.creditCard = creditCard;
        this.ticketStatus = ticketStatus;
        this.flightResource = flightResource;
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
