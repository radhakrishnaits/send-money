package com.altimetrik.wu.sendmoney.service;

import com.altimetrik.wu.sendmoney.entity.Transactions;
import com.altimetrik.wu.sendmoney.repository.TransactionRepository;
import com.altimetrik.wu.sendmoney.service.impl.TransactionServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
public class TransactionServiceTest {
    @Mock
    private TransactionRepository transactionRepository;
    @InjectMocks
    private TransactionServiceImpl transactionService;

    @Test
    public void getAllTransactionTest() {
        List<Transactions> txnList = getTransactions();
        when(transactionRepository.findAll()).thenReturn(txnList);
        List<Transactions> response = transactionService.getAllTransaction();
        assertNotNull(txnList);
        assertEquals(txnList, response);
    }

    @Test
    public void getAllTransactionNull() {
        List<Transactions> txnList = new ArrayList<>();
        when(transactionRepository.findAll()).thenReturn(txnList);
        List<Transactions> response = transactionService.getAllTransaction();
        assertNotNull(response);
        assertEquals(txnList, response);
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
