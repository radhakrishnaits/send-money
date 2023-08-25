package com.altimetrik.wu.sendmoney.service;
import com.altimetrik.wu.sendmoney.dto.ReponseDTO;
import com.altimetrik.wu.sendmoney.dto.request.RequestDTO;
import com.altimetrik.wu.sendmoney.entity.TransferRate;

public interface ReceiverService {
    ReponseDTO getReceiverAmount(RequestDTO requestDTO);
    TransferRate getRates(String fromCurrency, String toCurrency);
}
