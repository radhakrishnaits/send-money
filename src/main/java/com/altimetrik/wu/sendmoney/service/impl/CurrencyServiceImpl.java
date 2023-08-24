package com.altimetrik.wu.sendmoney.service.impl;

import com.altimetrik.wu.sendmoney.dto.request.CurrencyRequest;
import com.altimetrik.wu.sendmoney.entity.Currency;
import com.altimetrik.wu.sendmoney.repository.CurrencyRepository;
import com.altimetrik.wu.sendmoney.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
public class CurrencyServiceImpl implements CurrencyService {
    @Autowired
    private CurrencyRepository currencyRepository;

    @Override
    @Transactional
    public void addCurrency(List<CurrencyRequest> currencyRequests) {
        if (!currencyRequests.isEmpty()) {
            currencyRequests.forEach(currencyRequest -> {
                Currency currency = new Currency();
                currency.setCurrencyCode(currencyRequest.getCurrencyCode());
                currency.setCountryCode(currencyRequest.getCountryCode());
                currency.setCountry(currencyRequest.getCountryName());
                currency.setCurrency(currencyRequest.getCurrency());
                currencyRepository.save(currency);
            });
        }
    }

    @Override
    public void updateCurrency(List<CurrencyRequest> currencyRequests) {

    }

    @Override
    public void deleteCurrency(List<String> countryNames) {

    }

    @Override
    public List<Currency> getCurrency() {
        return (List<Currency>) currencyRepository.findAll();
    }

    @Override
    public Currency getCurrencyByCountryName(String country) {
        return null;
    }
}
