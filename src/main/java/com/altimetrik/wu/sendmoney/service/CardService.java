package com.altimetrik.wu.sendmoney.service;

import com.altimetrik.wu.sendmoney.dto.request.RequestDTO;
import com.altimetrik.wu.sendmoney.entity.CardEntity;

public interface CardService {
    public CardEntity saveCard(RequestDTO cardEntity);
}
