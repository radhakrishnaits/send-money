package com.altimetrik.wu.sendmoney.service.impl;

import com.altimetrik.wu.sendmoney.dto.response.ReceiverReponse;
import com.altimetrik.wu.sendmoney.dto.request.ReceiverRequest;
import com.altimetrik.wu.sendmoney.entity.Receiver;
import com.altimetrik.wu.sendmoney.entity.TransferRate;
import com.altimetrik.wu.sendmoney.repository.TransferRateRepository;
import com.altimetrik.wu.sendmoney.service.ReceiverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReceiverServiceImpl implements ReceiverService {
    @Autowired
    public TransferRateRepository transferRateRepository;

    @Override
    public ReceiverReponse getReceiverAmount(ReceiverRequest receiverRequest) {
        TransferRate transferRate = transferRateRepository.getRatebyCurency(receiverRequest.getFromCurrency(), receiverRequest.getToCurrency());

        Receiver receiver =new Receiver();
        double receivedAmount= receiverRequest.getAmount()* receiver.getFxRate()+ receiver.getCommission();
        ReceiverReponse receiverReponse = new ReceiverReponse();
        receiverReponse.setReceiverAmount(receivedAmount);
        receiverReponse.setCommission(receiver.getCommission());
        receiverReponse.setFxrate(receiver.getFxRate());
        return receiverReponse;
    }

    @Override
    public TransferRate getRates(String fromCurrency, String toCurrency) {
        return transferRateRepository.getRatebyCurency(fromCurrency, toCurrency);
    }
}
