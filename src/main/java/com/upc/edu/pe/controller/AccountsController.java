package com.upc.edu.pe.controller;

import com.upc.edu.pe.models.Account;
import com.upc.edu.pe.models.BusinessProfile;
import com.upc.edu.pe.resource.AccountResource;
import com.upc.edu.pe.resource.BusinessProfileResource;
import com.upc.edu.pe.resource.save.SaveBusinessProfileResource;
import com.upc.edu.pe.services.AccountService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/accounts")
public class AccountsController {

   /* @Autowired
    private ModelMapper mapper;*/

    @Autowired
    private AccountService accountService;

    @GetMapping
    public List<Account> getAllAccounts(){
        // List<AccountResource> accountResources = accounts.stream().map(this::convertToResource).collect(Collectors.toList());
        return accountService.getAllAccounts();
    }

  /*  private AccountResource convertToResource(Account entity) {
        return mapper.map(entity, AccountResource.class);
    }*/
}
