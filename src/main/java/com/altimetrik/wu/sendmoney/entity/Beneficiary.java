package com.altimetrik.wu.sendmoney.entity;


import javax.persistence.*;

@Entity
@Table(name = "user_beneficiary")
public class Beneficiary {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "beneficiary_id")
    private Long beneficiaryID;
    @Column(name = "user_id")
    private Long senderID;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "country")
    private String country;
    @Column(name = "bank_account_number")
    private String accountNumber;
    @Column(name = "iban")
    private String ifscCode;
    @Column(name = "status")
    private String status;

    public Long getBeneficiaryID() {
        return beneficiaryID;
    }

    public void setBeneficiaryID(Long beneficiaryID) {
        this.beneficiaryID = beneficiaryID;
    }

    public Long getSenderID() {
        return senderID;
    }

    public void setSenderID(Long senderID) {
        this.senderID = senderID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Beneficiary{" +
                "beneficiaryID=" + beneficiaryID +
                ", senderID=" + senderID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", country='" + country + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", ifscCode='" + ifscCode + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
