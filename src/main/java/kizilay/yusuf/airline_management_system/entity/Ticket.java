package kizilay.yusuf.airline_management_system.entity;

import kizilay.yusuf.airline_management_system.resource.TicketResource;

import javax.persistence.*;

@Entity
@Table(name = "ticket")
public class Ticket extends BaseEntity<TicketResource> {
    @Id
    @GeneratedValue
    @Column(name = "ticket_id")
    private int ticketId;

    private String passenger;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "flight_id")
    private Flight flight;


    @Enumerated(EnumType.STRING)
    private TicketStatus ticketStatus;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "credit_card_id")
    private CreditCard creditCard;

    public Ticket() {
    }

    public Ticket(String passenger, CreditCard creditCard) {
        this.passenger = passenger;
        this.creditCard = creditCard;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public String getPassenger() {
        return passenger;
    }

    public void setPassenger(String passenger) {
        this.passenger = passenger;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public TicketStatus getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(TicketStatus ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    @Override
    public int getId() {
        return this.ticketId;
    }

    @Override
    public TicketResource toResource() {
        return new TicketResource(this.passenger, this.creditCard.toResource(), this.flight.toResource(), this.ticketStatus);
    }
}
