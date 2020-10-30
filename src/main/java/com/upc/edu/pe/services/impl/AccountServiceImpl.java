package com.upc.edu.pe.services.impl;

import com.upc.edu.pe.models.Account;
import com.upc.edu.pe.repositories.AccountRepository;
import com.upc.edu.pe.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    //
    @Autowired
    private AccountRepository accountRepository;


    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }


}
