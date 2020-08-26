package com.upc.edu.pe.services.impl;

import com.upc.edu.pe.exception.ResourceNotFoundException;
import com.upc.edu.pe.models.PersonRequest;
import com.upc.edu.pe.repositories.*;
import com.upc.edu.pe.services.PersonRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class PersonRequestServiceImpl implements PersonRequestService {

    @Autowired
    private PersonRequestRepository personRequestRepository;

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private ProviderRepository providerRepository;

    @Autowired
    private ProductTypeRepository productTypeRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private PersonProfileRepository personProfileRepository;


    @Override
    public PersonRequest create(Long personId, Long petId, Long providerId, Long productTypeId, Long productId, PersonRequest personRequest) {

        if (!providerRepository.existsById(providerId))
            throw new ResourceNotFoundException("Provider Not Found");

        if (!productTypeRepository.existsById(productTypeId))
            throw new ResourceNotFoundException("product type Not Found");

        return personProfileRepository.findById(personId).map(personBD -> {
            return petRepository.findById(personId).map(petBD -> {
                return providerRepository.findById(providerId).map(providerBD -> {
                    return productTypeRepository.findById(productTypeId).map(productTypeBD -> {
                        return productRepository.findById(productId).map(productBD -> {

                            personRequest.setPet(petBD);
                            personRequest.setProduct(productBD);
                            personRequest.setVeterinaryName(providerBD.getBusinessName());
                            personRequest.setProductTypeName(productTypeBD.getName());
                            personRequest.setPersonName(personBD.getName());
                            return personRequestRepository.save(personRequest);


                        }).orElseThrow(() ->
                                new ResourceNotFoundException("Product Not Found"));
                    }).orElseThrow(() ->
                            new ResourceNotFoundException("ProductType Not Found"));
                }).orElseThrow(() ->
                        new ResourceNotFoundException("Provider Not Found"));
            }).orElseThrow(() ->
                    new ResourceNotFoundException("Pet Not Found"));
        }).orElseThrow(() ->
                new ResourceNotFoundException("Person Profile Not Found"));

    }

    @Override
    public List<PersonRequest> getAllByProductId(Long productId) {
        return personRequestRepository.getAllByProductId(productId);
    }
}
