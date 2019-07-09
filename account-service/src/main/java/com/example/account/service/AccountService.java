package com.example.account.service;

import com.example.account.domain.Account;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccountService {

    public abstract String saveAccount(Account account);

    public abstract String getAccountById(int id);

    public abstract Account getAccountInfo(int id);


    public abstract void deleteAccount(int accountId);

    public abstract List<Account> getAllAccounts();
}
