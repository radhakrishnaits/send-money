package com.altimetrik.wu.sendmoney.service;
import com.altimetrik.wu.sendmoney.dto.ReponseDTO;

public interface ReceiverService {
    ReponseDTO getReceiverAmount(double sendAmount);
}
