package com.altimetrik.wu.sendmoney.service;
import com.altimetrik.wu.sendmoney.dto.response.ReceiverResponse;
import com.altimetrik.wu.sendmoney.dto.request.ReceiverRequest;
import com.altimetrik.wu.sendmoney.entity.TransferRate;

import java.io.IOException;

public interface ReceiverService {
    ReceiverResponse getReceiverAmount(ReceiverRequest receiverRequest) throws IOException;
    TransferRate getRates(String fromCurrency, String toCurrency);
}
