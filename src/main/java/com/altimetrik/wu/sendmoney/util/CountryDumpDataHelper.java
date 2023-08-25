package com.altimetrik.wu.sendmoney.util;


import com.altimetrik.wu.sendmoney.entity.CardEntity;
import com.altimetrik.wu.sendmoney.entity.Currency;
import com.altimetrik.wu.sendmoney.entity.ReceiverEntity;
import com.altimetrik.wu.sendmoney.entity.SenderAllowedCountry;
import com.altimetrik.wu.sendmoney.repository.CardRepo;
import com.altimetrik.wu.sendmoney.repository.CurrencyRepository;
import com.altimetrik.wu.sendmoney.repository.ReceiverRepository;
import com.altimetrik.wu.sendmoney.repository.SenderAllowedCurrencyRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@Component
public class CountryDumpDataHelper {
    @Autowired
    private CurrencyRepository currencyRepository;

    @Autowired
    private CardRepo cardRepo;

    @Autowired
    private ReceiverRepository receiverRepository;

    @Autowired
    private SenderAllowedCurrencyRepository senderAllowedCurrencyRepository;
    ExecutorService executor = Executors.newFixedThreadPool(3);


    @PostConstruct
    public void init() throws IOException {
        List<Currency> currencies = currencyRepository.findAll();
        if (currencies.isEmpty()) {
            ObjectMapper mapper = new ObjectMapper();
            ClassLoader classLoader = getClass().getClassLoader();
            Currency[] response = mapper.readValue(new File(Objects.requireNonNull(classLoader.getResource("availableCountry.json")).getFile()), Currency[].class);
            Arrays.stream(response).forEach(res -> {
                Currency currency = new Currency();
                currency.setCurrencyCode(res.getCurrencyCode());
                currency.setCountryCode(res.getCountryCode());
                currency.setCountry(res.getCountry());
                currency.setCurrency(res.getCurrency());
                currencyRepository.save(currency);
            });

        }
        currencies = currencyRepository.findAll();
        List<Currency> finalCurrencies = currencies;
        executor.submit(() -> {
            List<SenderAllowedCountry> senderAllowedCountries = finalCurrencies.stream().map((currency) ->
                    new SenderAllowedCountry(currency.getCountry(), currency.getCountryCode(), currency.getCurrencyCode(), currency.getCurrency(), currency)
            ).collect(Collectors.toList());
            System.out.println("sender list" + senderAllowedCountries);
            senderAllowedCountries.forEach(senderAllowedCountry -> {
                int count = 0;
                for (SenderAllowedCountry senderAllowedCountry1 : senderAllowedCountries) {
                    count++;
                    senderAllowedCountry.setCurrency(senderAllowedCountry1.getCurrency());
                    System.out.println("Country name: " + senderAllowedCountry);
                    senderAllowedCurrencyRepository.save(senderAllowedCountry);
                    if (count == 5) break;

                }
            });
            System.out.println("Sender allowed county data filled");
            try {
                if (executor.awaitTermination(3, TimeUnit.SECONDS)) {
                    System.out.println("task completed");
                } else {
                    System.out.println("Forcing shutdown...");
                    executor.shutdownNow();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        System.out.println("data feed done...!!!");
    }

    @PostConstruct
    public void cardDataDump() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ClassLoader classLoader = getClass().getClassLoader();
        CardEntity[] response = mapper.readValue(new File(Objects.requireNonNull(classLoader.getResource("Card.json")).getFile()), CardEntity[].class);
        for (CardEntity cardEntity : response) {
            cardRepo.save(cardEntity);
        }
    }

    @PostConstruct
    public void receiverDataDump() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ClassLoader classLoader = getClass().getClassLoader();
        ReceiverEntity[] response = mapper.readValue(new File(Objects.requireNonNull(classLoader.getResource("transferRate.json")).getFile()), ReceiverEntity[].class);
        for (ReceiverEntity receiverEntity : response) {
            receiverRepository.save(receiverEntity);
        }
    }
}
