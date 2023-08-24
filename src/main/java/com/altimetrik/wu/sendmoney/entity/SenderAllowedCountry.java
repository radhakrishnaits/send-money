package com.altimetrik.wu.sendmoney.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sender_allowed_country")
public class SenderAllowedCountry {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "sender_allowed_currency_id")
    private Long senderAllowedCurrencyId;
    @Column(name = "country")
    private String country;
    @Column(name = "country_code")
    private String countryCode;
    @Column(name = "currency_code")
    private String currencyCode;

    @Column(name = "currency")
    private String currencyName;

    @OneToOne
    @JoinColumn(name = "currency_id")
    private Currency currency;

    public SenderAllowedCountry() {
    }

    public SenderAllowedCountry(String country, String countryCode, String currencyCode, String currencyName, Currency currency) {
        this.country = country;
        this.countryCode = countryCode;
        this.currencyCode = currencyCode;
        this.currencyName = currencyName;
        this.currency = currency;
    }

    public String getCountry() {
        return country;
    }

    public Long getSenderAllowedCurrencyId() {
        return senderAllowedCurrencyId;
    }

    public void setSenderAllowedCurrencyId(Long senderAllowedCurrencyId) {
        this.senderAllowedCurrencyId = senderAllowedCurrencyId;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "SenderAllowedCountry{" +
                "senderAllowedCurrencyId=" + senderAllowedCurrencyId +
                ", country='" + country + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", currencyCode='" + currencyCode + '\'' +
                ", currencyName='" + currencyName + '\'' +
                ", currency=" + currency +
                '}';
    }
}
