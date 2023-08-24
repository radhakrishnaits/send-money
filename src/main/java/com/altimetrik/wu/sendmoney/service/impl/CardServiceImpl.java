package com.altimetrik.wu.sendmoney.service.impl;

import com.altimetrik.wu.sendmoney.entity.CardEntity;
import com.altimetrik.wu.sendmoney.repository.CardRepo;
import org.springframework.stereotype.Service;

@Service
public class CardServiceImpl {
    private final CardRepo cardRepo;

    public CardServiceImpl(CardRepo cardRepo) {
        this.cardRepo = cardRepo;
    }

    public CardEntity saveCard(CardEntity cardEntity){
        return cardRepo.save(cardEntity);
    }
}

