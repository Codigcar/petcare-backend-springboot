package com.upc.edu.pe.services.impl;


import com.upc.edu.pe.exception.ResourceNotFoundException;
import com.upc.edu.pe.models.Account;
import com.upc.edu.pe.models.ProviderJoinProductType;
import com.upc.edu.pe.repositories.BusinessProfileRepository;
import com.upc.edu.pe.repositories.ProductTypeRepository;
import com.upc.edu.pe.repositories.ProviderJoinProductTypeRepository;
import com.upc.edu.pe.repositories.ProviderRepository;
import com.upc.edu.pe.services.ProviderJoinProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProviderJoinProductTypeServiceImpl implements ProviderJoinProductTypeService {
    @Autowired
    private ProviderRepository providerRepository;
    @Autowired
    private ProductTypeRepository productTypeRepository;
    @Autowired
    private ProviderJoinProductTypeRepository providerJoinProductTypeRepository;
    @Autowired
    private BusinessProfileRepository businessProfileRepository;

    @Override
    public ProviderJoinProductType createRelationship(Long businessId, Long providerId, Long productTypeId, ProviderJoinProductType providerJoinProductType) {
     /*   providerJoinProductType.setProvider(providerRepository.findById(providerId).orElse(null));
        providerJoinProductType.setProductType(productTypeRepository.findById(productId).orElse(null));

        return providerJoinProductTypeRepository.save(providerJoinProductType);*/

        if(!businessProfileRepository.existsById(businessId))
            throw new ResourceNotFoundException("BusinessProfile Not Found");

        return providerRepository.findById(providerId).map( providerBD -> {

            return productTypeRepository.findById(productTypeId).map( productTypeBD -> {

                providerJoinProductType.setProvider(providerBD);
                providerJoinProductType.setProductType(productTypeBD);

                return providerJoinProductTypeRepository.save(providerJoinProductType);

            }).orElseThrow(()->new ResourceNotFoundException(
                    "ProductType Not Found "));

        }).orElseThrow(()->new ResourceNotFoundException(
                "Provider Not Found "));
    }



}
