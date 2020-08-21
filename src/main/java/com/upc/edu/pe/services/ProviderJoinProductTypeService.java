package com.upc.edu.pe.services;


import com.upc.edu.pe.models.ProviderJoinProductType;

public interface ProviderJoinProductTypeService {
    ProviderJoinProductType createRelationship (Long businessId, Long providerId, Long productId, ProviderJoinProductType providerJoinProductType);
}
