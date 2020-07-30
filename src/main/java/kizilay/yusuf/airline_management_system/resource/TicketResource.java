package kizilay.yusuf.airline_management_system.resource;

import kizilay.yusuf.airline_management_system.entity.Ticket;

public class TicketResource extends BaseResource<Ticket> {

    private String passenger;

    private CreditCardResource creditCard;

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

    @Override
    public Ticket toEntity() {
        return new Ticket(this.passenger);
    }
}
