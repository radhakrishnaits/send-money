package com.altimetrik.wu.sendmoney.service.impl;

import com.altimetrik.wu.sendmoney.dto.request.ReceiverRequest;
import com.altimetrik.wu.sendmoney.dto.response.ReceiverResponse;
import com.altimetrik.wu.sendmoney.entity.Receiver;
import com.altimetrik.wu.sendmoney.entity.TransferRate;
import com.altimetrik.wu.sendmoney.repository.TransferRateRepository;
import com.altimetrik.wu.sendmoney.service.ReceiverService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ReceiverServiceImpl implements ReceiverService {
    @Autowired
    public TransferRateRepository transferRateRepository;

    @Override
    public ReceiverResponse getReceiverAmount(ReceiverRequest receiverRequest) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ClassLoader classLoader = getClass().getClassLoader();
        ReceiverResponse receiverResponse = new ReceiverResponse();
        Receiver[] response = mapper.readValue(new File(Objects.requireNonNull(classLoader.getResource("transferRate.json")).getFile()), Receiver[].class);
        List<Receiver> receivers = Arrays.stream(response).filter(receiver -> receiver.getFromCurrency().equals(receiverRequest.getFromCurrency()) && receiver.getToCurrency().equals(receiverRequest.getToCurrency())).collect(Collectors.toList());
        if (!receivers.isEmpty()) {
            Receiver receiver = receivers.get(0);
            double receivedAmount = (receiverRequest.getAmount() * receiver.getFxRate() - receiver.getCommission());
            receiverResponse.setReceiverAmount(String.valueOf(receivedAmount));
            receiverResponse.setCommission(receiver.getCommission());
            receiverResponse.setFxrate(receiver.getFxRate());
            receiverResponse.setSenderAmount(String.valueOf(receiverRequest.getAmount()));

        }

        return receiverResponse;
    }

    @Override
    public TransferRate getRates(String fromCurrency, String toCurrency) {
        return transferRateRepository.getRatebyCurency(fromCurrency, toCurrency);
    }
}
