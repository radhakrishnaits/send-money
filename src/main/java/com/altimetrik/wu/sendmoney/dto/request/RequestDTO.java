package com.altimetrik.wu.sendmoney.dto.request;

public class RequestDTO {
    private double fromCurrency;
    private double toCurrency;
    private double amount;

    public double getSendAmount() {
        return fromCurrency;
    }

    public void setSendAmount(double sendAmount) {
        this.fromCurrency = sendAmount;
    }

    public double getReceiveAmount() {
        return toCurrency;
    }

    public void setReceiveAmount(double receiveAmount) {
        this.toCurrency = receiveAmount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
