package com.example.bank.serviceImpl;

import com.example.bank.domain.Bank;
import com.example.bank.repository.BankRepository;
import com.example.bank.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class BankServiceImpl implements BankService {

    @Autowired
    BankRepository bankRepository;

    @Override
    public String getBankByID(int id) {
        String str = String.valueOf(bankRepository.getOne(id));
        return str;
    }

    @Override
    public Boolean saveBank(Bank bank) {
        return bankRepository.save(bank)!=null;
    }

    @Override
    public Bank getBankInfo(int id) {
        Bank bank = bankRepository.getOne(id);
        return bank;
    }

    @Override
    public void deleteBank(int bankId) {
         bankRepository.deleteById(bankId);
    }

    @Override
    public List<Bank> getAllBanks() {
        return (List<Bank>) bankRepository.findAll();
    }


}
