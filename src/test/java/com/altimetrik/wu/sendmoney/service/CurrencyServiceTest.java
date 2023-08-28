package com.altimetrik.wu.sendmoney.service;

import com.altimetrik.wu.sendmoney.entity.Currency;
import com.altimetrik.wu.sendmoney.repository.CurrencyRepository;
import com.altimetrik.wu.sendmoney.service.impl.CurrencyServiceImpl;
import javassist.NotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
public class CurrencyServiceTest {
    @Mock
    private CurrencyRepository currencyRepository;
    @InjectMocks
    private CurrencyServiceImpl currencyService;

    @Test
    public void testCurrencies() throws NotFoundException {
        List<Currency> currencies = new ArrayList<>();
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
        when(currencyRepository.findAll()).thenReturn(currencies);
        List<Currency> receivedCurrencies = currencyService.getCurrency();
        assertNotNull(receivedCurrencies);
        assertEquals(currencies, receivedCurrencies);
    }

    @Test
    public void testEmptyCurrencies() throws NotFoundException {
        List<Currency> currencies = new ArrayList<>();
        when(currencyRepository.findAll()).thenReturn(currencies);
        List<Currency> receivedCurrencies = currencyService.getCurrency();
        assertNotNull(receivedCurrencies);
        assertEquals(currencies, receivedCurrencies);
    }
}
