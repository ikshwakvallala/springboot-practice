package com.example.account.serviceImpl;

import com.example.account.domain.Account;
import com.example.account.repository.AccountRepo;
import com.example.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepo accountRepo;

//    @Autowired
//    private Account account;

    @Override
    public String saveAccount(Account account) {
        String status="";
        String s= String.valueOf(accountRepo.findExistingAccountType(account.getCustomer().getCustomerId()));

        if(!s.contains(account.getType())){
            accountRepo.save(account);
            status= "success";
        }else{
            System.out.println("Account type for the customer already exists in the same branch..");
        }
        System.out.println(s);
        return status;
    }

    @Override
    public String getAccountById(int id) {
        return String.valueOf(accountRepo.getOne(id));
    }

    @Override
    public Account getAccountInfo(int id) {
        return accountRepo.getOne(id);
    }

    @Override
    public void deleteAccount(int accountId) {
        accountRepo.deleteById(accountId);
    }

    @Override
    public List<Account> getAllAccounts() {
        return accountRepo.findAll();
    }
}
