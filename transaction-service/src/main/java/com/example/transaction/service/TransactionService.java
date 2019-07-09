package com.example.transaction.service;

import com.example.transaction.domain.Transaction;
import org.springframework.stereotype.Service;

@Service
public interface TransactionService {

    public Transaction getTransactionById(int transactionId);

    public String withdrawlsAndDeposit(Transaction transaction);

    public String accountToAccountTransfer(Transaction transaction);

}
