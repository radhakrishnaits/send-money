package com.altimetrik.wu.sendmoney.controller;

import com.altimetrik.wu.sendmoney.dto.request.CardRequest;
import com.altimetrik.wu.sendmoney.entity.Card;
import com.altimetrik.wu.sendmoney.repository.CardRepository;
import com.altimetrik.wu.sendmoney.service.CardService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CardControllerTest {

    @Autowired
    private CardService cardService;

    @MockBean
    private CardRepository cardRepository;

    @Test
    public void testSaveCard() throws Exception {
        Card card = new Card();
        card.setCardNumber("1234567890123456");
        card.setNameOnCard("Gokul R");
        card.setCardExpiry("12/25");
        CardRequest cardRequest = new CardRequest();

        when(cardRepository.save(Mockito.any(Card.class))).thenReturn(card);

        Card savedCard = cardService.saveCard(cardRequest);

        assertNotNull(savedCard);

        verify(cardRepository, times(1)).save(Mockito.any(Card.class));
    }

}