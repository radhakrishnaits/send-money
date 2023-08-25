package com.altimetrik.wu.sendmoney.entity;


import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "transactions")
public class Transactions {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "txn_id")
    private Long transactionId;
    @Column(name = "sender_id")
    private Long senderId;
    @Column(name = "receiver_id")
    private Long receiverId;
    @Column(name = "txn_amount")
    private Float transactionAmount;
    @Column(name = "sender_payment_method")
    private String senderPaymentMethod;
    @Column(name = "sender_card_number")
    private Long senderCardNumber;
    @Column(name = "sender_card_expiry")
    private String senderCardExpiry;
    @Column(name = "sender_name_on_card")
    private String senderNameOnCard;
    @Column(name = "receiver_payment_method")
    private String receiverPaymentMethod;
    @Column(name = "receiver_account_number")
    private Long receiverAccountNumber;
    @Column(name = "receiver_iban")
    private String receiverIban;
    @Column(name = "txn_type")
    private String transactionType;
    @Column(name = "fx_rate")
    private String fxRate;
    @Column(name = "exchange_fee")
    private Float exchangeFee;
    @Column(name = "receiver_pay_out")
    private Float receiverPayout;
    @Column(name = "sender_currency")
    private String senderCurrency;
    @Column(name = "receiver_currency")
    private String receiverCurrency;
    @Column(name = "receiver_country_iso")
    private String receiverCountryIso;
    @Column(name = "mtcn")
    private Long mtcn;
    @Column(name = "txn_status")
    private String transactionStatus;
    @Column(name = "txn_date")
    private Timestamp transactionDate;
    @Column(name = "third_party_ref_id")
    private String thirdPartyRefId;
    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "created_on")
    private Timestamp createdOn;
    @Column(name = "modified_by")
    private String modifiedBy;
    @Column(name = "modified_on")
    private Timestamp modifiedOn;
    @Column(name = "settlement_ref_id")
    private String settlementRefId;
    @Column(name = "txn_settled_on")
    private Timestamp transactionSettledOn;
    @Column(name = "refund_reff_txn_id")
    private String refundRefId;
    @Column(name = "remarks")
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

    public Timestamp getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Timestamp transactionDate) {
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

    public Timestamp getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Timestamp createdOn) {
        this.createdOn = createdOn;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Timestamp getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(Timestamp modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    public String getSettlementRefId() {
        return settlementRefId;
    }

    public void setSettlementRefId(String settlementRefId) {
        this.settlementRefId = settlementRefId;
    }

    public Timestamp getTransactionSettledOn() {
        return transactionSettledOn;
    }

    public void setTransactionSettledOn(Timestamp transactionSettledOn) {
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
