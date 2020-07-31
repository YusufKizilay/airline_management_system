package kizilay.yusuf.airline_management_system.entity;

import kizilay.yusuf.airline_management_system.resource.CreditCardResource;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "credit_card")
public class CreditCard extends BaseEntity<CreditCardResource> {

    @Id
    @GeneratedValue
    @Column(name = "credit_card_id")
    private int creditCardId;

    private String ownerName;

    private String cardNo;

    private Date expirationDate;

    private String securityCode;

    public CreditCard() {
    }

    public CreditCard(String ownerName, String cardNo, Date expirationDate, String securityCode) {
        this.ownerName = ownerName;
        this.cardNo = cardNo;
        this.expirationDate = expirationDate;
        this.securityCode = securityCode;
    }

    public int getCreditCardId() {
        return creditCardId;
    }

    public void setCreditCardId(int creditCardId) {
        this.creditCardId = creditCardId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }

    @Override
    public int getId() {
        return this.getCreditCardId();
    }


    @Override
    public CreditCardResource toResource() {
        return new CreditCardResource(this);
    }
}
