package com.example.transaction.controller;

import com.example.transaction.domain.Transaction;
import com.example.transaction.serviceImpl.TransactionServiceImpl;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionServiceImpl transactionServiceImpl;

    @RequestMapping(value = "/withDrawOrDeposit", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public String withDrawAndDepositAmount(@RequestBody Transaction transaction){
        return transactionServiceImpl.withdrawlsAndDeposit(transaction);
    }

    @RequestMapping(value = "/transferMoney",method = RequestMethod.POST,headers = "Accept=application/json")
    @ResponseBody
    public String transferMoney(@RequestBody Transaction transaction){
        return transactionServiceImpl.accountToAccountTransfer(transaction);
    }

    @RequestMapping(value = "/getTransactionById/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Transaction getTransactionById(@PathVariable Integer id){
        return transactionServiceImpl.getTransactionById(id);
    }
}
