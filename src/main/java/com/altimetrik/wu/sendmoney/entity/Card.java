package com.altimetrik.wu.sendmoney.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user_cards")
public class Card {
    @Id
    @Column(name = "card_id")
    private int cardId;
    @Column(name = "user_id")
    private int userId;
    @Column(name = "card_number")
    private Long cardNumber;
    @Column(name = "card_expiry")
    private String cardExpiry;
    @Column(name = "name_on_card")
    private String nameOnCard;
    @Column(name = "status")
    private String status;
    @Column(name = "modifiedOn")
    private Date modified_on;
    @Column(name = "modifiedBy")
    private String modified_by;

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardExpiry() {
        return cardExpiry;
    }

    public void setCardExpiry(String cardExpiry) {
        this.cardExpiry = cardExpiry;
    }

    public String getNameOnCard() {
        return nameOnCard;
    }

    public void setNameOnCard(String nameOnCard) {
        this.nameOnCard = nameOnCard;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getModified_on() {
        return modified_on;
    }

    public void setModified_on(Date modified_on) {
        this.modified_on = modified_on;
    }

    public String getModified_by() {
        return modified_by;
    }

    public void setModified_by(String modified_by) {
        this.modified_by = modified_by;
    }

    @Override
    public String toString() {
        return "CardEntity{" +
                "cardId=" + cardId +
                ", userId=" + userId +
                ", cardNumber=" + cardNumber +
                ", cardExpiry='" + cardExpiry + '\'' +
                ", name_on_card='" + nameOnCard + '\'' +
                ", status='" + status + '\'' +
                ", modified_on=" + modified_on +
                ", modified_by='" + modified_by + '\'' +
                '}';
    }
}
