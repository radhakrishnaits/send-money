package com.altimetrik.wu.sendmoney.controller;

import com.altimetrik.wu.sendmoney.dto.request.ReceiverRequest;
import com.altimetrik.wu.sendmoney.dto.response.ReceiverResponse;
import com.altimetrik.wu.sendmoney.service.ReceiverService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@SpringBootTest
@AutoConfigureMockMvc
public class ReceiverControllerTest {

    @InjectMocks
    private ReceiverController receiverController;

    @Mock
    private ReceiverService receiverService;

    private MockMvc mockMvc;

    public ReceiverControllerTest() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(receiverController).build();
    }

    @Test
    public void testCalculateReceiveAmount() throws Exception {
        String fromCurrency = "USD";
        String toCurrency = "EUR";
        double amount = 100.0;

        ReceiverRequest request = new ReceiverRequest();
        request.setFromCurrency(fromCurrency);
        request.setToCurrency(toCurrency);
        request.setAmount(amount);

        ReceiverResponse response = new ReceiverResponse();

        when(receiverService.getReceiverAmount(request)).thenReturn(response);

        MvcResult mvcResult = mockMvc.perform(get("/transaction/rates")
                        .param("fromCurrency", fromCurrency)
                        .param("toCurrency", toCurrency)
                        .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk()) // Expect HTTP status 200
                .andReturn();

        int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();
    }
}

