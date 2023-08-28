package com.altimetrik.wu.sendmoney.controller;

import com.altimetrik.wu.sendmoney.entity.Card;
import com.altimetrik.wu.sendmoney.repository.CardRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CardController.class)
public class CardControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private CardRepository cardRepository;
    @Test
    public void testSaveCard() throws Exception{
        Card card = new Card();
        card.setCardNumber(1234567890123456L);
        card.setNameOnCard("Gokul R");
        card.setCardExpiry("12/25");
        card.setStatus("Active");

        when(cardRepository.save(Mockito.any(Card.class))).thenReturn(card);
        mockMvc.perform(post("/api/card")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(card)))
                .andExpect(status().isOk());
    }
}
