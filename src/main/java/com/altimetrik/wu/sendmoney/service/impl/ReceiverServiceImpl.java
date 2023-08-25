package com.altimetrik.wu.sendmoney.service.impl;

import com.altimetrik.wu.sendmoney.dto.ReponseDTO;
import com.altimetrik.wu.sendmoney.dto.request.RequestDTO;
import com.altimetrik.wu.sendmoney.entity.ReceiverEntity;
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
    public ReponseDTO getReceiverAmount(RequestDTO requestDTO) {
        TransferRate transferRate = transferRateRepository.getRatebyCurency(requestDTO.getFromCurrency(), requestDTO.getToCurrency());

        ReceiverEntity receiverEntity =new ReceiverEntity();
        double receivedAmount= requestDTO.getAmount()*receiverEntity.getFxrate()+ receiverEntity.getCommission();
        ReponseDTO reponseDTO = new ReponseDTO();
        reponseDTO.setReceiverAmount(receivedAmount);
        reponseDTO.setCommission(receiverEntity.getCommission());
        reponseDTO.setFxrate(receiverEntity.getFxrate());
        return reponseDTO;
    }

    @Override
    public TransferRate getRates(String fromCurrency, String toCurrency) {
        return transferRateRepository.getRatebyCurency(fromCurrency, toCurrency);
    }
}
