package com.altimetrik.wu.sendmoney.service.impl;

import com.altimetrik.wu.sendmoney.dto.request.CardRequest;
import com.altimetrik.wu.sendmoney.entity.Card;
import com.altimetrik.wu.sendmoney.repository.CardRepository;
import com.altimetrik.wu.sendmoney.service.CardService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardServiceImpl implements CardService {
    @Autowired
    private CardRepository cardRepository;


    public Card saveCard(CardRequest cardRequest) {
        Card card = new Card();
        BeanUtils.copyProperties(cardRequest, card);
        return cardRepository.save(card);
    }
}


//    @Override
//    public Card saveCard(ReceiverRequest receiverRequest) {
//        if(receiverRequest.getFromCurrency()!=null && receiverRequest.getToCurrency() && receiverRequest.getAmount()>0{
//            throw  new BadHttpRequest("Bad request")
//        }
//        Card card= new Card();
//        card.se
//        return cardRepository.save();
//    }
//}

