package com.altimetrik.wu.sendmoney.service.impl;

import com.altimetrik.wu.sendmoney.entity.SenderAllowedCountry;
import com.altimetrik.wu.sendmoney.repository.SenderAllowedCurrencyRepository;
import com.altimetrik.wu.sendmoney.service.SenderAllowedCountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SenderAllowedCountryServiceImpl implements SenderAllowedCountryService {
    @Autowired
    private SenderAllowedCurrencyRepository senderAllowedCurrencyRepository;

    @Override
    public List<SenderAllowedCountry> gSenderAllowedCountries(String countryCode) {
        return  senderAllowedCurrencyRepository.getSenderAllowedCountryByCountryCode(countryCode);
    }
}
