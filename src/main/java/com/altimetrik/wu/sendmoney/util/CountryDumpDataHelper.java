package com.altimetrik.wu.sendmoney.util;


import com.altimetrik.wu.sendmoney.entity.Currency;
import com.altimetrik.wu.sendmoney.entity.SenderAllowedCountry;
import com.altimetrik.wu.sendmoney.repository.CurrencyRepository;
import com.altimetrik.wu.sendmoney.repository.SenderAllowedCurrencyRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class CountryDumpDataHelper {
    @Autowired
    private CurrencyRepository currencyRepository;

    @Autowired
    private SenderAllowedCurrencyRepository senderAllowedCurrencyRepository;


    @PostConstruct
    public void init() throws IOException {
        List<Currency> currencies = currencyRepository.findAll();
        if (currencies.isEmpty()) {
            ObjectMapper mapper = new ObjectMapper();
            ClassLoader classLoader = getClass().getClassLoader();
            Currency[] response = mapper.readValue(new File(Objects.requireNonNull(classLoader.
                    getResource("availableCountry.json")).getFile()), Currency[].class);
            Arrays.stream(response).forEach(res -> {
                Currency currency = new Currency();
                currency.setCurrencyCode(res.getCurrencyCode());
                currency.setCountryCode(res.getCountryCode());
                currency.setCountry(res.getCountry());
                currency.setCurrency(res.getCurrency());
                System.out.println("Dump currency-- " + currency);
                currencyRepository.save(currency);
            });
        }
        currencies = currencyRepository.findAll();
        List<Currency> finalCurrencies = currencies;
        List<SenderAllowedCountry> senderAllowedCountries = finalCurrencies.stream().map((currency) -> {
                    Set<Currency> currency1 = new HashSet<>();
                    currency1.add(currency);
                    return new SenderAllowedCountry(currency.getCountry(), currency.getCountryCode(),
                            currency.getCurrencyCode(), currency.getCurrency(), currency1);
                }
        ).collect(Collectors.toList());
        System.out.println("sender list" + senderAllowedCountries);
        for (int i = 0; i < senderAllowedCountries.size() - 1; i++) {
            SenderAllowedCountry senderAllowedCountry = senderAllowedCountries.get(i);
            Set<Currency> currency = new HashSet<>();
            for (SenderAllowedCountry senderAllowedCountry1 : senderAllowedCountries) {
                currency.addAll(senderAllowedCountry1.getAllowedCountry());
                System.out.println("Country name: " + senderAllowedCountry);
            }
            senderAllowedCountry.setAllowedCountry(currency);
            senderAllowedCurrencyRepository.save(senderAllowedCountry);
        }
        System.out.println("data feed done...!!!");
    }
}
