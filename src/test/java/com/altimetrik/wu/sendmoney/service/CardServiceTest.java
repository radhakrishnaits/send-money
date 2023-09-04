package com.altimetrik.wu.sendmoney.service;

import com.altimetrik.wu.sendmoney.dto.request.CardRequest;
import com.altimetrik.wu.sendmoney.entity.Card;
import com.altimetrik.wu.sendmoney.repository.CardRepository;
import com.altimetrik.wu.sendmoney.service.impl.CardServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CardServiceTest {

    @InjectMocks
    private CardServiceImpl cardService;

    @Mock
    private CardRepository cardRepository;

    public CardServiceTest() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSaveCard() {
        CardRequest cardRequest = new CardRequest();
        cardRequest.setCardNumber("1234567890123456");
        cardRequest.setNameOnCard("Gokul R");
        cardRequest.setCardExpiry("12/25");

        Card card = new Card();

        when(cardRepository.save(any(Card.class))).thenReturn(card);

        Card savedCard = cardService.saveCard(cardRequest);

        assertEquals(card.getCardNumber(), savedCard.getCardNumber());
        assertEquals(card.getNameOnCard(), savedCard.getNameOnCard());
        assertEquals(card.getCardExpiry(), savedCard.getCardExpiry());
    }
}

