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

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "flight_id")
    private Flight flight;


    private TicketStatus ticketStatus;

    public Ticket() {
    }

    public Ticket(String passenger) {
        this.passenger = passenger;
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

    @Override
    public int getId() {
        return this.ticketId;
    }

    @Override
    public TicketResource toResource() {
        return null;
    }
}
