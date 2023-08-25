package com.altimetrik.wu.sendmoney.service.impl;

import com.altimetrik.wu.sendmoney.dto.request.RequestDTO;
import com.altimetrik.wu.sendmoney.entity.CardEntity;
import com.altimetrik.wu.sendmoney.repository.CardRepo;
import com.altimetrik.wu.sendmoney.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardServiceImpl implements CardService {
    @Autowired
    private final CardRepo cardRepo;

    public CardServiceImpl(CardRepo cardRepo) {
        this.cardRepo = cardRepo;
    }

    public CardEntity saveCard(CardEntity cardEntity) {
        return cardRepo.save(cardEntity);
    }

    @Override
    public CardEntity saveCard(RequestDTO cardEntity) {
        return null;
    }
}

