package com.altimetrik.wu.sendmoney.service.impl;

import com.altimetrik.wu.sendmoney.dto.request.TransactionRequest;
import com.altimetrik.wu.sendmoney.entity.Transactions;
import com.altimetrik.wu.sendmoney.repository.TransactionRepository;
import com.altimetrik.wu.sendmoney.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Override
    public List<Transactions> getAllTransaction() {
        return transactionRepository.findAll();
    }

    @Override
    public long saveTransaction(TransactionRequest transactionRequest) {
        Transactions txn = new Transactions();
        txn.setSenderId(transactionRequest.getSenderId());
        txn.setSenderCurrency(transactionRequest.getSenderCurrency());
        txn.setSenderCardNumber(transactionRequest.getSenderCardNumber());
        txn.setSenderNameOnCard(transactionRequest.getSenderNameOnCard());
        txn.setSenderCardExpiry(transactionRequest.getSenderCardExpiry());
        txn.setReceiverId(transactionRequest.getReceiverId());
        txn.setReceiverCurrency(transactionRequest.getReceiverCurrency());
        txn.setExchangeFee(transactionRequest.getExchangeFee());
        txn.setFxRate(transactionRequest.getFxRate());
        txn.setReceiverAccountNumber(transactionRequest.getReceiverAccountNumber());
        txn.setReceiverCountryIso(transactionRequest.getReceiverCountryIso());
        txn.setReceiverIban(transactionRequest.getReceiverIban());
        txn.setReceiverPayout(transactionRequest.getReceiverPayout());
        txn.setTransactionAmount(transactionRequest.getTransactionAmount());
        txn.setTransactionStatus("Initiated");
        txn.setCreatedBy(transactionRequest.getCreatedBy());

        txn = transactionRepository.save(txn);
        return txn.getMtcn();
    }
}
