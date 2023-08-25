package com.altimetrik.wu.sendmoney.dto.request;


public class TransactionRequest {
    
    private Long transactionId;
    private Long senderId;
    private Long receiverId;
    private Float transactionAmount;
    private String senderPaymentMethod;
    private Long senderCardNumber;
    private String senderCardExpiry;
    private String senderNameOnCard;
    private String receiverPaymentMethod;
    private Long receiverAccountNumber;
    private String receiverIban;
    private String transactionType;
    private String fxRate;
    private Float exchangeFee;
    private Float receiverPayout;
    private String senderCurrency;
    private String receiverCurrency;
    private String receiverCountryIso;
    private Long mtcn;
    private String transactionStatus;
    private String transactionDate;
    private String thirdPartyRefId;
    private String createdBy;
    private String createdOn;
    private String modifiedBy;
    private String modifiedOn;
    private String settlementRefId;
    private String transactionSettledOn;
    private String refundRefId;
    private String remarks;

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public Long getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Long receiverId) {
        this.receiverId = receiverId;
    }

    public Float getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(Float transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public String getSenderPaymentMethod() {
        return senderPaymentMethod;
    }

    public void setSenderPaymentMethod(String senderPaymentMethod) {
        this.senderPaymentMethod = senderPaymentMethod;
    }

    public Long getSenderCardNumber() {
        return senderCardNumber;
    }

    public void setSenderCardNumber(Long senderCardNumber) {
        this.senderCardNumber = senderCardNumber;
    }

    public String getSenderCardExpiry() {
        return senderCardExpiry;
    }

    public void setSenderCardExpiry(String senderCardExpiry) {
        this.senderCardExpiry = senderCardExpiry;
    }

    public String getSenderNameOnCard() {
        return senderNameOnCard;
    }

    public void setSenderNameOnCard(String senderNameOnCard) {
        this.senderNameOnCard = senderNameOnCard;
    }

    public String getReceiverPaymentMethod() {
        return receiverPaymentMethod;
    }

    public void setReceiverPaymentMethod(String receiverPaymentMethod) {
        this.receiverPaymentMethod = receiverPaymentMethod;
    }

    public Long getReceiverAccountNumber() {
        return receiverAccountNumber;
    }

    public void setReceiverAccountNumber(Long receiverAccountNumber) {
        this.receiverAccountNumber = receiverAccountNumber;
    }

    public String getReceiverIban() {
        return receiverIban;
    }

    public void setReceiverIban(String receiverIban) {
        this.receiverIban = receiverIban;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getFxRate() {
        return fxRate;
    }

    public void setFxRate(String fxRate) {
        this.fxRate = fxRate;
    }

    public Float getExchangeFee() {
        return exchangeFee;
    }

    public void setExchangeFee(Float exchangeFee) {
        this.exchangeFee = exchangeFee;
    }

    public Float getReceiverPayout() {
        return receiverPayout;
    }

    public void setReceiverPayout(Float receiverPayout) {
        this.receiverPayout = receiverPayout;
    }

    public String getSenderCurrency() {
        return senderCurrency;
    }

    public void setSenderCurrency(String senderCurrency) {
        this.senderCurrency = senderCurrency;
    }

    public String getReceiverCurrency() {
        return receiverCurrency;
    }

    public void setReceiverCurrency(String receiverCurrency) {
        this.receiverCurrency = receiverCurrency;
    }

    public String getReceiverCountryIso() {
        return receiverCountryIso;
    }

    public void setReceiverCountryIso(String receiverCountryIso) {
        this.receiverCountryIso = receiverCountryIso;
    }

    public Long getMtcn() {
        return mtcn;
    }

    public void setMtcn(Long mtcn) {
        this.mtcn = mtcn;
    }

    public String getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(String transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getThirdPartyRefId() {
        return thirdPartyRefId;
    }

    public void setThirdPartyRefId(String thirdPartyRefId) {
        this.thirdPartyRefId = thirdPartyRefId;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public String getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(String modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    public String getSettlementRefId() {
        return settlementRefId;
    }

    public void setSettlementRefId(String settlementRefId) {
        this.settlementRefId = settlementRefId;
    }

    public String getTransactionSettledOn() {
        return transactionSettledOn;
    }

    public void setTransactionSettledOn(String transactionSettledOn) {
        this.transactionSettledOn = transactionSettledOn;
    }

    public String getRefundRefId() {
        return refundRefId;
    }

    public void setRefundRefId(String refundRefId) {
        this.refundRefId = refundRefId;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
