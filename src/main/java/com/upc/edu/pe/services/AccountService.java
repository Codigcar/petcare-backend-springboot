package com.upc.edu.pe.services;

import com.upc.edu.pe.models.Account;
import org.springframework.stereotype.Service;
import java.util.List;

public interface AccountService {

    List<Account> getAllAccounts();

}