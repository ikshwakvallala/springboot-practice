package com.example.bank.controller;

import com.example.bank.domain.Bank;
import com.example.bank.serviceImpl.BankServiceImpl;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bank")
public class BankController {

    @Autowired
    BankServiceImpl bankServiceImpl;

    @RequestMapping(value = "/getBank/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public String getBankById(@PathVariable Integer id){
        return  bankServiceImpl.getBankByID(id);
    }

    @RequestMapping(value = "/insertBank", method = RequestMethod.POST )
    public HttpStatus insertBank(@RequestBody Bank bank){
         Boolean insertStatus = bankServiceImpl.saveBank(bank);
         return insertStatus ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
    }

    @RequestMapping(value =  "/getBankInfo/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Bank getBankInfo(@PathVariable Integer id){
        return bankServiceImpl.getBankInfo(id);
    }

    @RequestMapping(value = "/deleteBank/{bankId}", method = RequestMethod.DELETE)
    public HttpStatus deleteBank(@PathVariable Integer bankId){
         bankServiceImpl.deleteBank(bankId);
         return HttpStatus.NO_CONTENT;
    }

    @RequestMapping(value = "/updateBank/{id}", method = RequestMethod.PUT)
    public HttpStatus updateBank(@RequestBody Bank bank){
        return bankServiceImpl.saveBank(bank)? HttpStatus.LOCKED : HttpStatus.BAD_REQUEST;
    }

    @RequestMapping(value ="/getAllBanks" , method = RequestMethod.GET)
    public List<Bank> getAllBanks(){
        return bankServiceImpl.getAllBanks();
    }
}
