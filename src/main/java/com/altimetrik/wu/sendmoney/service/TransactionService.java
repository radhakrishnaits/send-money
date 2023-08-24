package com.altimetrik.wu.sendmoney.service;

import com.altimetrik.wu.sendmoney.dto.request.TransactionRequest;
import com.altimetrik.wu.sendmoney.entity.Transactions;

import java.util.List;

public interface TransactionService {

    List<Transactions> getAllTransaction();

    long saveTransaction(TransactionRequest transactionRequest);
}
