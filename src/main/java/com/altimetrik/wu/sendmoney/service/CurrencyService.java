package com.altimetrik.wu.sendmoney.service;

import com.altimetrik.wu.sendmoney.dto.request.CurrencyRequest;
import com.altimetrik.wu.sendmoney.entity.Currency;

import java.util.List;

public interface CurrencyService {
    void addCurrency(List<CurrencyRequest> currencyRequests);

    void updateCurrency(List<CurrencyRequest> currencyRequests);

    void deleteCurrency(List<String> countryNames);

    List<Currency> getCurrency();

    Currency getCurrencyByCountryName(String country);
}
