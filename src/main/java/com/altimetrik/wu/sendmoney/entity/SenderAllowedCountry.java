package com.altimetrik.wu.sendmoney.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

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

    @ManyToMany(cascade = CascadeType.DETACH, targetEntity = Currency.class)
    @JoinColumn(name = "currency_id")
    private Set<Currency> allowedCountry = new HashSet<>();

    public SenderAllowedCountry() {
    }

    public SenderAllowedCountry(String country, String countryCode, String currencyCode, String currencyName, Set<Currency> allowedCountry) {
        this.country = country;
        this.countryCode = countryCode;
        this.currencyCode = currencyCode;
        this.currencyName = currencyName;
        this.allowedCountry = allowedCountry;
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

    public Set<Currency> getAllowedCountry() {
        return allowedCountry;
    }

    public void setAllowedCountry(Set<Currency> allowedCountry) {
        this.allowedCountry = allowedCountry;
    }

    @Override
    public String toString() {
        return "SenderAllowedCountry{" +
                "senderAllowedCurrencyId=" + senderAllowedCurrencyId +
                ", country='" + country + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", currencyCode='" + currencyCode + '\'' +
                ", currencyName='" + currencyName + '\'' +
                ", allowedCountry=" + allowedCountry +
                '}';
    }
}
