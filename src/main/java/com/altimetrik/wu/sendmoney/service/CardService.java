package com.altimetrik.wu.sendmoney.service;

import com.altimetrik.wu.sendmoney.dto.request.CardRequest;
import com.altimetrik.wu.sendmoney.dto.request.ReceiverRequest;
import com.altimetrik.wu.sendmoney.entity.Card;

public interface CardService {
    public Card saveCard(CardRequest cardRequest);
}
