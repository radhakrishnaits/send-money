package com.altimetrik.wu.sendmoney.service;
import com.altimetrik.wu.sendmoney.dto.request.ReceiverRequest;
import com.altimetrik.wu.sendmoney.dto.response.ReceiverResponse;
import com.altimetrik.wu.sendmoney.entity.Receiver;
import com.altimetrik.wu.sendmoney.repository.TransferRateRepository;
import com.altimetrik.wu.sendmoney.service.impl.ReceiverServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReceiverServiceTest {

    @InjectMocks
    private ReceiverServiceImpl receiverService;

    @Mock
    private TransferRateRepository transferRateRepository;

    public ReceiverServiceTest() {
        MockitoAnnotations.initMocks(this);
    }

    @BeforeEach
    public void setUp() {
    }

    @Test
    public void testGetReceiverAmount() throws IOException {
        ReceiverRequest receiverRequest = new ReceiverRequest();
        receiverRequest.setFromCurrency("INR");
        receiverRequest.setToCurrency("EUR");
        receiverRequest.setAmount(100.0);

        ObjectMapper mapper = new ObjectMapper();
        ClassLoader classLoader = getClass().getClassLoader();
        Receiver[] response = mapper.readValue(new File(Objects.requireNonNull(classLoader.getResource("transferRate.json")).getFile()), Receiver[].class);

        ReceiverResponse receiverResponse = receiverService.getReceiverAmount(receiverRequest);
        String expectedReceiverAmount="0.5999999999999999";
        double expectedCommission =0.5;
        double expectedFxRate = 0.011;

        assertEquals(expectedReceiverAmount, receiverResponse.getReceiverAmount());
        assertEquals(expectedCommission, receiverResponse.getCommission());
        assertEquals(expectedFxRate, receiverResponse.getFxrate());
        assertEquals(String.valueOf(receiverRequest.getAmount()), receiverResponse.getSenderAmount());
    }
}
