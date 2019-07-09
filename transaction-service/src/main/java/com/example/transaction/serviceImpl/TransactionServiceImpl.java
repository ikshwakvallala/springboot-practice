package com.example.transaction.serviceImpl;

import com.example.transaction.domain.Account;
import com.example.transaction.domain.Transaction;
import com.example.transaction.repository.AccountRepository;
import com.example.transaction.repository.TransactionRepository;
import com.example.transaction.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Transaction getTransactionById(int transactionId) {
        return transactionRepository.getOne(transactionId);
    }

    @Override
    public String withdrawlsAndDeposit(Transaction transaction) {
        String status=null;
        String transactionDescription=null;
        if(transaction!=null){
        double transactionAmount = transaction.getTransactionAmount();
            Account account=accountRepository.getOne(transaction.getAccount().getAccountId());
            if(account!=null){
                double balanceAmount = account.getBalance();
                String transactionType = transaction.getTransactionType();
                if(transactionType.toUpperCase().equalsIgnoreCase("WITHDRAWL")){
                    if(balanceAmount>transactionAmount){
                        balanceAmount= balanceAmount-transactionAmount;
                        account.setBalance(balanceAmount);
                        accountRepository.save(account);
                        transactionDescription="WithDrawl of "+ transactionAmount + "is success and current balance is" + balanceAmount;
                        status="Successfull";
                    }else {
                        transactionDescription=" Transaction failed because of insufficient balance ";
                        status="Failed";
                    }
                }else if( transactionType.toUpperCase().equalsIgnoreCase("Deposit")){
                    balanceAmount=balanceAmount+transactionAmount;
                    account.setBalance(balanceAmount);
                    accountRepository.save(account);
                    transactionDescription="Deposit of " + transactionAmount + " is done and current balance is " + balanceAmount;
                    status="Successfull";

                }
            }else {
                transactionDescription= "Invalid AccountId transaction failed";
                status= "Failed";
            }
        }
        transaction.setTransactionDescription(transactionDescription);
        transaction.setTransactionStatus(status);
        if(!status.contains("Failed")){
            transactionRepository.save(transaction);
        }
        return transactionDescription;
    }

    @Override
    public String accountToAccountTransfer(Transaction transaction) {
        String status=null;
        String transactionDescription=null;
        if(transaction!=null){
        double transactionAmount = transaction.getTransactionAmount();
        Account fromAccount=  accountRepository.getOne(transaction.getAccount().getAccountId());
        Account toAccount = accountRepository.getOne(transaction.getToAccount());
        double fromAccountBalance =fromAccount.getBalance();
        if(fromAccountBalance>transactionAmount){
        fromAccount.setBalance(fromAccountBalance-transactionAmount);
        accountRepository.save(fromAccount);
        toAccount.setBalance(toAccount.getBalance()+transactionAmount);
        accountRepository.save(toAccount);
        transactionDescription = "Transaction with ACC_ID: " + transaction.getToAccount() + " had successfully " +
                    "completed and current balance is :" + fromAccount.getBalance();
        status = "Successful";
        } else {
            transactionDescription = "Transaction failed due to insufficient funds";
            status = "Failed";
        }
        } else {
            transactionDescription = "Insufficient transaction details..";
            status = "Failed";
        }
        transaction.setTransactionDescription(transactionDescription);
        transaction.setTransactionStatus(status);
        if (!status.toLowerCase().contains("failed")) {
            transactionRepository.save(transaction);
        }
        return transactionDescription;
    }
}
