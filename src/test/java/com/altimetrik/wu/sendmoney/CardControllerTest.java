package com.altimetrik.wu.sendmoney;

import com.altimetrik.wu.sendmoney.controller.CardController;
import com.altimetrik.wu.sendmoney.entity.CardEntity;
import com.altimetrik.wu.sendmoney.repo.CardRepo;
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
    private CardRepo cardRepo;
    @Test
    public void testSaveCard() throws Exception{
        CardEntity cardEntity = new CardEntity();
        cardEntity.setCardNumber("1234567890123456");
        cardEntity.setCardHolderName("Gokul R");
        cardEntity.setExpirationDate("12/25");
        cardEntity.setCvv("000");

        when(cardRepo.save(Mockito.any(CardEntity.class))).thenReturn(cardEntity);
        mockMvc.perform(post("/api/card")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(cardEntity)))
                .andExpect(status().isOk());
    }
}
