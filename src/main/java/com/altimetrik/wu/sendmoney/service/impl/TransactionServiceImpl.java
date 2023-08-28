package com.altimetrik.wu.sendmoney.service.impl;

import com.altimetrik.wu.sendmoney.dto.request.TransactionRequest;
import com.altimetrik.wu.sendmoney.entity.Transactions;
import com.altimetrik.wu.sendmoney.repository.TransactionRepository;
import com.altimetrik.wu.sendmoney.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

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
        txn.setMtcn(Long.valueOf(generateMtcn("56")));

        txn = transactionRepository.save(txn);
        return txn.getMtcn();
    }

    private int getCheckDigit(String number) {
        int sum = 0;
        for (int i = 0; i < number.length(); i++) {

            int digit = Integer.parseInt(number.substring(i, (i + 1)));

            if ((i % 2) == 0) {
                digit = digit * 2;
                if (digit > 9) {
                    digit = (digit / 10) + (digit % 10);
                }
            }
            sum += digit;
        }

        int mod = sum % 10;
        return ((mod == 0) ? 0 : 10 - mod);
    }

    private String generateMtcn(String startWith) {
        Random random = new Random(System.currentTimeMillis());
        //int randomNumberLength = 16 - ("23037700041".length() + 1);
        int randomNumberLength = 16 - (startWith.length() + 1);

        StringBuilder builder = new StringBuilder(startWith);
        for (int i = 0; i < randomNumberLength; i++) {
            int digit = random.nextInt(10);
            builder.append(digit);
        }

        int checkDigit = this.getCheckDigit(builder.toString());
        builder.append(checkDigit);
        return builder.toString();
    }
}
