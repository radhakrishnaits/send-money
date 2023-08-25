package com.altimetrik.wu.sendmoney.service.impl;

import com.altimetrik.wu.sendmoney.dto.ReponseDTO;
import com.altimetrik.wu.sendmoney.entity.ReceiverEntity;
import com.altimetrik.wu.sendmoney.service.ReceiverService;
import org.springframework.stereotype.Service;

@Service
public class ReceiverServiceImpl implements ReceiverService {

    @Override
    public ReponseDTO getReceiverAmount(double sendAmount) {
        ReceiverEntity receiverEntity =new ReceiverEntity();
        double receivedAmount= sendAmount*receiverEntity.getFxrate()+ receiverEntity.getCommission();
        ReponseDTO reponseDTO = new ReponseDTO();
        reponseDTO.setReceiverAmount(receivedAmount);
        reponseDTO.setCommission(receiverEntity.getCommission());
        reponseDTO.setFxrate(receiverEntity.getFxrate());
        return reponseDTO;
    }
}
