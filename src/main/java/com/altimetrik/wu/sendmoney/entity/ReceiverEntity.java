package com.altimetrik.wu.sendmoney.entity;

import javax.persistence.*;

@Entity
@Table(name="receiver")
public class ReceiverEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="receiver_id")
    private int receiverId;
    @Column(name="sender_amount")
    private double senderAmount;
    @Column(name="receiver_amount")
    private double receiverAmount;
    @Column(name="fx_rate")
    private double fxrate;
    @Column(name="commission")
    private double commission;

    public int getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(int receiverId) {
        this.receiverId = receiverId;
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
                "receiverId=" + receiverId +
                ", senderAmount=" + senderAmount +
                ", receiverAmount=" + receiverAmount +
                ", fxrate=" + fxrate +
                ", commission=" + commission +
                '}';
    }
}
