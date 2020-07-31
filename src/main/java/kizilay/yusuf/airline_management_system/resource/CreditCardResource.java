package kizilay.yusuf.airline_management_system.resource;

import kizilay.yusuf.airline_management_system.entity.CreditCard;

import java.util.Date;

public class CreditCardResource extends BaseResource<CreditCard> {

    private String ownerName;

    private String cardNo;

    private Date expirationDate;

    private String securityCode;

    public CreditCardResource() {
    }

    public CreditCardResource(final CreditCard  creditCard) {
        super(null,null);
        this.ownerName=creditCard.getOwnerName();
        this.cardNo=creditCard.getCardNo();
        this.expirationDate=creditCard.getExpirationDate();
        this.securityCode= creditCard.getSecurityCode();
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
    public CreditCard toEntity() {
        return new CreditCard(this.ownerName, this.cardNo, this.expirationDate,this.securityCode);
    }
}
