package com.altimetrik.wu.sendmoney.dto.response;

public class ReceiverReponse {
    private double senderAmount;
    private double receiverAmount;
    private double fxrate;
    private double commission;

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
}
