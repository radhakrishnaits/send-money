package com.altimetrik.wu.sendmoney.controller;

import com.altimetrik.wu.sendmoney.entity.Currency;
import com.altimetrik.wu.sendmoney.entity.SenderAllowedCountry;
import com.altimetrik.wu.sendmoney.service.impl.CurrencyServiceImpl;
import com.altimetrik.wu.sendmoney.service.impl.SenderAllowedCountryServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CurrencyController.class)
@SpringBootTest
public class CurrencyControllerTest {

    private MockMvc mockMvc;

    @Mock
    private CurrencyServiceImpl currencyService;

    @InjectMocks
    private CurrencyController currencyController;

    @Mock
    private SenderAllowedCountryServiceImpl senderAllowedCountryService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(currencyController).build();
    }

    @Test
    public void getCurrencyShouldReturnCurrency() throws Exception {
        List<Currency> currencies = getCurrencies();

        when(currencyService.getCurrency()).thenReturn(currencies);
        this.mockMvc.perform(get("/country").
                content(currencies.toString()).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

    }


    @Test
    public void getSenderAvailableCurrencyShouldReturnCountryList() throws Exception {
        List<SenderAllowedCountry> senderAllowedCountries = getSenderAllowedCountries();
        when(senderAllowedCountryService.gSenderAllowedCountries("IN")).thenReturn(senderAllowedCountries);
        this.mockMvc.perform(get("/country/IN").
                content(senderAllowedCountries.toString()).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

    }

    @Test
    public void getSenderAvailableCurrencyShouldReturnNotFound() throws Exception {
        List<SenderAllowedCountry> senderAllowedCountries = getSenderAllowedCountries();
        when(senderAllowedCountryService.gSenderAllowedCountries("IN")).thenReturn(senderAllowedCountries);
        this.mockMvc.perform(get("/country/abc/IN").
                content(senderAllowedCountries.toString()).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isNotFound());

    }


    @Test
    public void getCurrencyShouldReturnNotFound() throws Exception {
        List<Currency> currencies = new ArrayList<>();
        Currency currency = new Currency();
        currency.setCurrency("Indian Rupee");
        currency.setCurrencyCode("INR");
        currency.setCountry("India");
        currency.setCountryCode("IN");
        currencies.add(currency);

        when(currencyService.getCurrency()).thenReturn(currencies);
        this.mockMvc.perform(get("/countryer").
                content(currencies.toString()).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isNotFound());

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

    private static List<Currency> getCurrencies() {
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
        return currencies;
    }
}
