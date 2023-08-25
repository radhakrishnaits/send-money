package com.altimetrik.wu.sendmoney.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class ReceiverEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private double senderAmount;
    private double receiverAmount;
    private double fxrate;
    private double commission;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getSenderAmount() {
        return senderAmount;
    }

    public void setSenderAmount(double senderAmount) {
        this.senderAmount = senderAmount;
    }

    public double getReceiverAmount() {
        return receiverAmount;
    }

    public void setReceiverAmount(double receiverAmount) {
        this.receiverAmount = receiverAmount;
    }

    public double getFxrate() {
        return fxrate;
    }

    public void setFxrate(double fxrate) {
        this.fxrate = fxrate;
    }

    public double getCommission() {
        return commission;
    }

    public void setCommission(double commission) {
        this.commission = commission;
    }

    @Override
    public String toString() {
        return "ReceiverEntity{" +
                "id=" + id +
                ", senderAmount=" + senderAmount +
                ", receiverAmount=" + receiverAmount +
                ", fxrate=" + fxrate +
                ", commission=" + commission +
                '}';
    }
}
