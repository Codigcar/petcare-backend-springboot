package com.upc.edu.pe.services;


import com.upc.edu.pe.models.ProductType;
import com.upc.edu.pe.models.ProviderJoinProductType;

import java.util.List;

public interface ProviderJoinProductTypeService {
    ProviderJoinProductType createRelationship (Long businessId, Long providerId, Long productId, ProviderJoinProductType providerJoinProductType);
    List<ProductType> getProductTypesByProviderId(Long ProviderId);
}
