package com.upc.edu.pe.services.impl;


import com.upc.edu.pe.exception.ResourceNotFoundException;
import com.upc.edu.pe.models.Provider;
import com.upc.edu.pe.repositories.BusinessProfileRepository;
import com.upc.edu.pe.repositories.ProviderRepository;
import com.upc.edu.pe.services.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProviderServiceImpl implements ProviderService {
    @Autowired
    private ProviderRepository providerRepository;

    @Autowired
    private BusinessProfileRepository businessProfileRepository;

    @Override
    public List<Provider> getAllProviders() {
        return providerRepository.findAll();
    }

    @Override
    public Provider getProviderById(Long providerId) {
        return providerRepository.findById(providerId)
                .orElseThrow(()->new ResourceNotFoundException("Provider Not Found"));
    }

    @Override
    public Provider createProvider(Long businessProfileId, Provider provider) {

        return businessProfileRepository.findById(businessProfileId).map(businessProfileBD -> {
            provider.setBusinessProfile(businessProfileBD);
            return providerRepository.save(provider);
        }).orElseThrow(()->new ResourceNotFoundException(
                "BusinessProfile Not Found"));
    }

    @Override
    public Provider updateProvider(Long businessId,Long providerId, Provider providerRequest) {

        if(!businessProfileRepository.existsById(businessId))
            throw new ResourceNotFoundException("BusinessProfile Not Found");

        return providerRepository.findById(providerId).map(providerBD -> {
            providerBD.setBusinessName(providerRequest.getBusinessName());
            providerBD.setRegion(providerRequest.getRegion());
            providerBD.setAddress(providerRequest.getAddress());
            providerBD.setField(providerRequest.getField());
            providerBD.setEmail(providerRequest.getEmail());
            providerBD.setDescription(providerRequest.getDescription());
            providerBD.setSubscriptionPlan(providerRequest.getSubscriptionPlan());
            providerBD.setPhoto(providerRequest.getPhoto());
            return providerRepository.save(providerBD);

        }).orElseThrow(()->new ResourceNotFoundException("Provider Not Found"));
    }

    @Override
    public ResponseEntity<?> deleteProvider(Long providerId) {
        Provider provider=providerRepository.findById(providerId)
                .orElseThrow(()->new ResourceNotFoundException("Provider Not Found"));
        providerRepository.delete(provider);
        return ResponseEntity.ok().build();
    }
}
