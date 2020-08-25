package com.upc.edu.pe.services.impl;

import com.upc.edu.pe.models.PersonRequest;
import com.upc.edu.pe.repositories.PersonProfileRepository;
import com.upc.edu.pe.repositories.PersonRequestRepository;
import com.upc.edu.pe.repositories.ProductRepository;
import com.upc.edu.pe.services.PersonRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonRequestServiceImpl implements PersonRequestService {

    @Autowired
    private PersonRequestRepository personRequestRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private PersonProfileRepository personProfileRepository;


    @Override
    public PersonRequest create(Long peopleId, Long petId, Long providerId, Long servicesId, PersonRequest personRequest) {

        personRequest.setPersonProfile(personProfileRepository.findById(peopleId).orElse(null));
        personRequest.setProduct(productRepository.findById(servicesId).orElse(null));

        return personRequestRepository.save(personRequest);
    }

    @Override
    public List<PersonRequest> getAllByProductId(Long productId) {
        return personRequestRepository.getAllByProductId(productId);
    }
}
