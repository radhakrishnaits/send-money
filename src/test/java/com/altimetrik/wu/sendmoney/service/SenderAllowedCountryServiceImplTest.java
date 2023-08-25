package com.altimetrik.wu.sendmoney.service;

import com.altimetrik.wu.sendmoney.entity.Currency;
import com.altimetrik.wu.sendmoney.entity.SenderAllowedCountry;
import com.altimetrik.wu.sendmoney.repository.SenderAllowedCurrencyRepository;
import com.altimetrik.wu.sendmoney.service.impl.SenderAllowedCountryServiceImpl;
import javassist.NotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
public class SenderAllowedCountryServiceImplTest {

    @Mock
    private SenderAllowedCurrencyRepository senderAllowedCurrencyRepository;

    @InjectMocks
    private SenderAllowedCountryServiceImpl senderAllowedCountryService;


    @Test
    public void testSenderAllowedCurrencyReturnAllowedCurrencyList() throws NotFoundException {
        String countryCode = "IN";
        List<SenderAllowedCountry> givenSenderAllowedCountries = getSenderAllowedCountries();
        when(senderAllowedCurrencyRepository.getSenderAllowedCountryByCountryCode(countryCode)).thenReturn(givenSenderAllowedCountries);
        List<SenderAllowedCountry> expectedSenderAllowedCountries = senderAllowedCountryService.getSenderAllowedCountries(countryCode);
        assertNotNull(expectedSenderAllowedCountries);
        assertEquals(expectedSenderAllowedCountries, givenSenderAllowedCountries);
    }

    private static List<SenderAllowedCountry> getSenderAllowedCountries() {
        Set<Currency> currencies = new HashSet<>();
        List<SenderAllowedCountry> senderAllowedCountries = new ArrayList<>();
        Currency currency = new Currency();
        currency.setCurrency("Indian Rupee");
        currency.setCurrencyCode("INR");
        currency.setCountry("India");
        currency.setCountryCode("IN");
        Currency currency1 = new Currency();
        currency.setCurrency("East Caribbean Dollar");
        currency.setCurrencyCode("XCD");
        currency.setCountry("Antigua and Barbuda");
        currency.setCountryCode("AG");
        currencies.add(currency);
        currencies.add(currency1);
        SenderAllowedCountry senderAllowedCountry = new SenderAllowedCountry();
        senderAllowedCountry.setCountry("India");
        senderAllowedCountry.setCountryCode("IN");
        senderAllowedCountry.setCurrencyCode("INR");
        senderAllowedCountry.setCurrencyName("Indian Rupee");
        senderAllowedCountry.setAllowedCountry(currencies);
        senderAllowedCountries.add(senderAllowedCountry);
        return senderAllowedCountries;
    }

}
