package com.upc.edu.pe.services.impl;


import com.upc.edu.pe.exception.ResourceNotFoundException;
import com.upc.edu.pe.models.Account;
import com.upc.edu.pe.models.BusinessProfile;
import com.upc.edu.pe.models.Provider;
import com.upc.edu.pe.repositories.*;
import com.upc.edu.pe.services.BusinessProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessProfileServiceImpl implements BusinessProfileService {

    @Autowired
    private BusinessProfileRepository businessProfileRepository;

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private SubscriptionPlanRepository subscriptionPlanRepository;


    @Override
    public BusinessProfile create(BusinessProfile businessProfile) {

        return rolRepository.findById((long) 2).map( rolBD -> {

            return subscriptionPlanRepository.findById((long) 2).map( subscriptionBD -> {

                Account account = new Account();
                account.setUser(businessProfile.getEmail());
                account.setPassword(businessProfile.getPassword());
                account.setRol(rolBD);
                account.setSubscriptionPlan(subscriptionBD);
                accountRepository.save(account);
                businessProfile.setAccount(account);

                return businessProfileRepository.save(businessProfile);

            }).orElseThrow(()->new ResourceNotFoundException(
                    "PlanSubscriptions Not Found "));

        }).orElseThrow(()->new ResourceNotFoundException(
                "Roles and PlanSubscriptions Not Found "));


    }

    @Override
    public List<BusinessProfile> getAllBusiness() {
        return businessProfileRepository.findAll();
    }

    @Override
    public BusinessProfile getBusinessById(Long businessId) {
        return businessProfileRepository.findById(businessId).orElse(null);
    }
}
