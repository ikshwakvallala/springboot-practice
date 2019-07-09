package com.example.bank.service;

import com.example.bank.domain.Bank;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BankService {

    public abstract String getBankByID(int id);

    public abstract Boolean saveBank(Bank bank);

    public abstract Bank getBankInfo(int id);

    public abstract void deleteBank(int bank);

    public abstract List<Bank> getAllBanks();
}
