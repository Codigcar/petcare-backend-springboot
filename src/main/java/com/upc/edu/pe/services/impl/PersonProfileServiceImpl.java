package com.upc.edu.pe.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.upc.edu.pe.exception.ResourceNotFoundException;
import com.upc.edu.pe.models.Account;
import com.upc.edu.pe.models.PersonProfile;
import com.upc.edu.pe.repositories.AccountRepository;
import com.upc.edu.pe.repositories.PersonProfileRepository;
import com.upc.edu.pe.repositories.RolRepository;
import com.upc.edu.pe.repositories.SubscriptionPlanRepository;
import com.upc.edu.pe.services.PersonProfileService;

import java.util.List;

@Service
public class PersonProfileServiceImpl implements PersonProfileService {

    @Autowired
    private PersonProfileRepository personProfileRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private SubscriptionPlanRepository subscriptionPlanRepository;
    
    @Override
    public List<PersonProfile> getAllPersons() {
        return personProfileRepository.findAll();
    }

    @Override
    public PersonProfile getPersonById(Long personId) {
        return personProfileRepository.findById(personId)
                .orElseThrow(()->new ResourceNotFoundException("Person Not Found"));
    }

    @Override
    public PersonProfile createPerson(PersonProfile personProfile)
    {
         
    	return rolRepository.findById((long) 1).map( rolBD -> {
        
        	  return subscriptionPlanRepository.findById((long) 1).map( subscriptionBD -> {
        		  
        		  	Account account = new Account();       
        	        account.setUser(personProfile.getEmail());
        	        account.setPassword(personProfile.getPassword());
        	        account.setRol(rolBD);
        	        account.setSubscriptionPlan(subscriptionBD);
        	        accountRepository.save(account);
        	        personProfile.setAccount(account);
        	        
        	        return personProfileRepository.save(personProfile);
        	        
        	  }).orElseThrow(()->new ResourceNotFoundException(
                      "PlanSubscriptions Not Found "));
        	 
          }).orElseThrow(()->new ResourceNotFoundException(
                  "Roles and PlanSubscriptions Not Found "));
          
       
    }

    @Override
    public PersonProfile updatePerson(Long personId, PersonProfile personProfileRequest) {

      return personProfileRepository.findById(personId).map(personProfileBD -> {
            personProfileBD.setName(personProfileRequest.getName());
            personProfileBD.setLastName(personProfileRequest.getLastName());
            personProfileBD.setDocument(personProfileRequest.getDocument());
            personProfileBD.setEmail(personProfileRequest.getEmail());
            personProfileBD.setPhone(personProfileRequest.getPhone());
            personProfileBD.setAge(personProfileRequest.getAge());
            personProfileBD.setPhoto(personProfileRequest.getPhoto());

            return personProfileRepository.save(personProfileBD);

        }).orElseThrow(()->new ResourceNotFoundException("Person Not Found"));
    }

    @Override
    public ResponseEntity<?> deletePerson(Long personId) {

        return personProfileRepository.findById(personId).map(personBD -> {
            personProfileRepository.delete(personBD);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Person Not Found"));
    }

}
