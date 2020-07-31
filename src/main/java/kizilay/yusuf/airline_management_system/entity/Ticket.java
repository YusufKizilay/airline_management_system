package kizilay.yusuf.airline_management_system.entity;

import kizilay.yusuf.airline_management_system.resource.TicketResource;

import javax.persistence.*;

@Entity
@Table(name = "ticket")
public class Ticket extends BaseEntity<TicketResource> {
    private static final String NON_NUMERIC_REGEX="[^\\d.]";
    private static final String EMPTY_STR="";
    private static final String MASK_STR="*";

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

    public void maskCreditCardNo(){
        String cardNo = this.creditCard.getCardNo();
        cardNo = cardNo.replaceAll(NON_NUMERIC_REGEX, EMPTY_STR);

        int size = cardNo.length();

        String preMaskString = cardNo.substring(0, 6);
        String postMaskString = cardNo.substring(size - 4, size);

        int countToBeMasked = size - 10;

        StringBuilder builder = new StringBuilder(preMaskString);

        for (int i = 0; i < countToBeMasked - 1; i++) {
            builder.append(MASK_STR);
        }

        builder.append(postMaskString);

        String masked = builder.toString();

        this.creditCard.setCardNo(masked);
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
        return new TicketResource(this);
    }
}
