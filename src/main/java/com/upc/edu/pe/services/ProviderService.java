package com.upc.edu.pe.services;

import com.upc.edu.pe.models.Provider;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProviderService {
    List<Provider> getAllProviders();
    Provider getProviderById(Long providerId);
    Provider createProvider(Long businessProfileId,Provider provider);
    Provider updateProvider(Long businessId,Long providerId,Provider providerRequest);
    ResponseEntity<?> deleteProvider(Long providerId);
}
