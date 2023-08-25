package com.altimetrik.wu.sendmoney.controller;

import com.altimetrik.wu.sendmoney.dto.request.TransactionRequest;
import com.altimetrik.wu.sendmoney.entity.Transactions;
import com.altimetrik.wu.sendmoney.service.impl.TransactionServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TransactionController.class)
@SpringBootTest
public class TransactionControllerTest {

    private MockMvc mockMvc;

    @Mock
    private TransactionServiceImpl transactionService;

    @InjectMocks
    private TransactionController TransactionController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(TransactionController).build();
    }

    @Test
    public void getAllTransaction() throws Exception {
        List<Transactions> txnList = getTransactions();
        when(transactionService.getAllTransaction()).thenReturn(txnList);
        this.mockMvc.perform(get("/transaction").content(txnList.toString())
                .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

    @Test
    public void getAllTransactionNotFound() throws Exception {
        List<Transactions> txnList = getTransactions();
        when(transactionService.getAllTransaction()).thenReturn(txnList);
        this.mockMvc.perform(get("/transaction/abc/IN").content(txnList.toString())
                .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isNotFound());
    }

    @Test
    public void saveTransactionTest() throws Exception {
        TransactionRequest request = new TransactionRequest();
        when(transactionService.saveTransaction(request)).thenReturn(12345L);
        this.mockMvc.perform(post("/transaction/save").content(new ObjectMapper().writeValueAsString(request))
                .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

    @Test
    public void saveTransactionTestNotFound() throws Exception {
        TransactionRequest request = new TransactionRequest();
        when(transactionService.saveTransaction(request)).thenReturn(12345L);
        this.mockMvc.perform(post("/transaction/save/132").content(new ObjectMapper().writeValueAsString(request))
                .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isNotFound());
    }

    private static List<Transactions> getTransactions() {
        List<Transactions> txnList = new ArrayList<>();
        Transactions txn = new Transactions();
        txn.setSenderId(123L);
        txn.setSenderCurrency("INR");
        txn.setSenderCardNumber(458745687989L);
        txn.setSenderNameOnCard("Adam Smith");
        txn.setSenderCardExpiry("03/26");
        txn.setReceiverId(3213L);
        txn.setReceiverCurrency("USD");
        txn.setExchangeFee(70.00F);
        txn.setFxRate("70");
        txn.setReceiverAccountNumber(45659798656L);
        txn.setReceiverCountryIso("HDFC123");
        txn.setReceiverIban("HDFC234");
        txn.setReceiverPayout(100F);
        txn.setTransactionAmount(70000F);
        txn.setTransactionStatus("Initiated");
        txn.setCreatedBy("admin");

        Transactions txn1 = new Transactions();
        txn1.setSenderId(123L);
        txn1.setSenderCurrency("INR");
        txn1.setSenderCardNumber(458745687989L);
        txn1.setSenderNameOnCard("Adam Smith");
        txn1.setSenderCardExpiry("03/26");
        txn1.setReceiverId(6987L);
        txn1.setReceiverCurrency("USD");
        txn1.setExchangeFee(70.00F);
        txn1.setFxRate("70");
        txn1.setReceiverAccountNumber(2005521475L);
        txn1.setReceiverCountryIso("HDFC123");
        txn1.setReceiverIban("HDFC234");
        txn1.setReceiverPayout(100F);
        txn1.setTransactionAmount(70000F);
        txn1.setTransactionStatus("Initiated");
        txn1.setCreatedBy("user");
        txnList.add(txn);
        txnList.add(txn1);
        return txnList;
    }
}
