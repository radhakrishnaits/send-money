package com.altimetrik.wu.sendmoney.service;

import com.altimetrik.wu.sendmoney.entity.SenderAllowedCountry;
import javassist.NotFoundException;

import java.util.List;

public interface SenderAllowedCountryService {
    public List<SenderAllowedCountry> getSenderAllowedCountries(String countryCode) throws NotFoundException;
}
