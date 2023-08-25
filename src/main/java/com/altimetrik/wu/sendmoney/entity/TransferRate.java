package com.altimetrik.wu.sendmoney.entity;

import javax.persistence.*;

@Entity
@Table(name="transfer_rate")
public class TransferRate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "txn_id")
    private String transferId;
    @Column(name = "sender_country_code")
    private String senderCountryCode;
    @Column(name = "receiver_country_code")
    private String receiverCountryCode;
    @Column(name = "from_currency")
    private String fromCurrency;
    @Column(name = "to_currency")
    private String toCurrency;
    @Column(name = "fx_rate")
    private String fxRate;
    @Column(name = "commission")
    private String  Commission;

    public String getTransferId() {
        return transferId;
    }

    public void setTransferId(String transferId) {
        this.transferId = transferId;
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

    public String getFxRate() {
        return fxRate;
    }

    public void setFxRate(String fxRate) {
        this.fxRate = fxRate;
    }

    public String getCommission() {
        return Commission;
    }

    public void setCommission(String commission) {
        Commission = commission;
    }

    @Override
    public String toString() {
        return "TransferRate{" +
                "transferId='" + transferId + '\'' +
                ", senderCountryCode='" + senderCountryCode + '\'' +
                ", receiverCountryCode='" + receiverCountryCode + '\'' +
                ", fromCurrency='" + fromCurrency + '\'' +
                ", toCurrency='" + toCurrency + '\'' +
                ", fxRate='" + fxRate + '\'' +
                ", Commission='" + Commission + '\'' +
                '}';
    }
}
