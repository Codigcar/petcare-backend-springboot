package com.upc.edu.pe.services.impl;


import com.upc.edu.pe.exception.ResourceNotFoundException;
import com.upc.edu.pe.models.ProductType;
import com.upc.edu.pe.repositories.ProductTypeRepository;
import com.upc.edu.pe.services.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {
    @Autowired
    ProductTypeRepository productTypeRepository;

    @Override
    public List<ProductType> getAllProductsTypes() {
        return productTypeRepository.findAll();
    }

    @Override
    public ProductType getServiceTypeById(Long serviceTypeId) {
        return productTypeRepository.findById(serviceTypeId)
                .orElseThrow(()->new ResourceNotFoundException("ServiceType","Id",serviceTypeId));
    }

    @Override
    public ProductType createServiceType(ProductType productType) {
        return productTypeRepository.save(productType);
    }

    @Override
    public ProductType updateServiceType(Long serviceTypeId, ProductType productTypeRequest) {
        ProductType productType = productTypeRepository.findById(serviceTypeId)
                .orElseThrow(()->new ResourceNotFoundException("ServiceType","Id",serviceTypeId));
        productType.setName(productTypeRequest.getName());

        return productTypeRepository.save(productType);
    }

    @Override
    public ResponseEntity<?> deleteServiceType(Long serviceTypeId) {
        ProductType productType = productTypeRepository.findById(serviceTypeId)
                .orElseThrow(()->new ResourceNotFoundException("ServiceType","Id",serviceTypeId));
        productTypeRepository.delete(productType);

        return ResponseEntity.ok().build();
    }
}
