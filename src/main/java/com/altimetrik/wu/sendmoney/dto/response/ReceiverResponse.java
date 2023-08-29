package com.altimetrik.wu.sendmoney.dto.response;

public class ReceiverResponse {
    private String senderAmount;
    private String receiverAmount;
    private double fxrate;
    private double commission;

    public String getSenderAmount() {
        return senderAmount;
    }

    public void setSenderAmount(String senderAmount) {
        this.senderAmount = senderAmount;
    }

    public String getReceiverAmount() {
        return receiverAmount;
    }

    public void setReceiverAmount(String receiverAmount) {
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
