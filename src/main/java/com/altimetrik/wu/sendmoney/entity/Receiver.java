package com.altimetrik.wu.sendmoney.entity;

import javax.persistence.*;

@Entity
@Table(name="receiver")
public class Receiver {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="receiver_id")
    private int receiverId;
    @Column(name="sender_amount")
    private double senderAmount;
    @Column(name="receiver_amount")
    private double receiverAmount;
    @Column(name="fx_rate")
    private double fxRate;
    @Column(name="commission")
    private double commission;
    @Column(name="sender_country_code")
    private String senderCountryCode;
    @Column(name="receiver_country_code")
    private String receiverCountryCode;
    @Column(name = "from_currency")
    private String fromCurrency;
    @Column(name = "to_currency")
    private String toCurrency;

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

    public double getFxRate() {
        return fxRate;
    }

    public void setFxRate(double fxRate) {
        this.fxRate = fxRate;
    }

    public double getCommission() {
        return commission;
    }

    public void setCommission(double commission) {
        this.commission = commission;
    }

    public String getSenderCountryCode() {
        return senderCountryCode;
    }

    public void setSenderCountryCode(String senderCountryCode) {
        this.senderCountryCode = senderCountryCode;
    }

    public String getReceiverCountryCode() {
        return receiverCountryCode;
    }

    public void setReceiverCountryCode(String receiverCountryCode) {
        this.receiverCountryCode = receiverCountryCode;
    }

    public String getFromCurrency() {
        return fromCurrency;
    }

    public void setFromCurrency(String fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    public String getToCurrency() {
        return toCurrency;
    }

    public void setToCurrency(String toCurrency) {
        this.toCurrency = toCurrency;
    }

    @Override
    public String toString() {
        return "Receiver{" +
                "receiverId=" + receiverId +
                ", senderAmount=" + senderAmount +
                ", receiverAmount=" + receiverAmount +
                ", fxrate=" + fxRate +
                ", commission=" + commission +
                ", senderCountryCode='" + senderCountryCode + '\'' +
                ", receiverCountryCode='" + receiverCountryCode + '\'' +
                ", fromCurrency='" + fromCurrency + '\'' +
                ", toCurrency='" + toCurrency + '\'' +
                '}';
    }
}
