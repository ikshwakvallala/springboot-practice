package com.example.account.controller;

import com.example.account.domain.Account;
import com.example.account.repository.AccountRepo;
import com.example.account.serviceImpl.AccountServiceImpl;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountServiceImpl accountServiceImpl;

    @RequestMapping(value = "/getAccountById/{customerId}", method = RequestMethod.GET,headers = "Accepts = application/json")
    @ResponseBody
    public String getAccountStatus(@PathVariable Integer customerId){
        return accountServiceImpl.getAccountById(customerId);
    }

    @RequestMapping(value = "/getAccountInfo/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Account getAccountInfo(@PathVariable Integer id) {
        Account account = accountServiceImpl.getAccountInfo(id);
        return account;
    }

    @RequestMapping(value = "/getAllAccounts", method = RequestMethod.GET)
    public List<Account> getAllAccounts() {
        return accountServiceImpl.getAllAccounts();
    }

    @RequestMapping(value = "/insertAccount",method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public String insertAccount(@RequestBody Account account){
//        String str= accountServiceImpl.saveAccount(account);
       return accountServiceImpl.saveAccount(account);

    }

    @RequestMapping(value = "/updateAccount", method = RequestMethod.PUT)
    public String updateAccount(@RequestBody Account account) {
       return accountServiceImpl.saveAccount(account);
    }

    @RequestMapping(value = "/deleteAccountById/{id}", method = RequestMethod.DELETE)
    public HttpStatus deleteAccount(@PathVariable Integer id) {
        accountServiceImpl.deleteAccount(id);
        return HttpStatus.NO_CONTENT;
    }
}
