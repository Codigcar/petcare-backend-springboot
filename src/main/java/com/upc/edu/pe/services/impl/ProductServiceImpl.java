package com.upc.edu.pe.services.impl;


import com.upc.edu.pe.exception.ResourceNotFoundException;
import com.upc.edu.pe.models.Product;
import com.upc.edu.pe.repositories.BusinessProfileRepository;
import com.upc.edu.pe.repositories.ProductRepository;
import com.upc.edu.pe.repositories.ProviderJoinProductTypeRepository;
import com.upc.edu.pe.repositories.ProviderRepository;
import com.upc.edu.pe.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProviderJoinProductTypeRepository providerJoinProductTypeRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private BusinessProfileRepository businessProfileRepository;
    @Autowired
    private ProviderRepository providerRepository;

    @Override
    public Page<Product> getAllByProviderJoinTypeProductId(Long providerJoinTypeProductId, Pageable pageable) {
        return productRepository.findAllByProviderJoinProductTypeId(providerJoinTypeProductId,pageable);
    }

    @Override
    public Product createProduct(Long businessId, Long providerId, Long providerJoinTypeProductId, Product product) {
        if(!businessProfileRepository.existsById(businessId))
            throw new ResourceNotFoundException("BusinessProfile Not Found");

        if(!providerRepository.existsById(providerId))
            throw new ResourceNotFoundException("Provider Not Found");

        return providerJoinProductTypeRepository.findById(providerJoinTypeProductId).map(providerJoinTypeProduct -> {
            product.setProviderJoinProductType(providerJoinTypeProduct);
            return productRepository.save(product);
        }).orElseThrow(()->new ResourceNotFoundException(
                "Provider Join TypeProduct Not Found"));
    }

    /* @Override
    public Product createProduct(Long businessId,Long providerId, Long productTypeId,Product product) {
       return providerJoinProductTypeRepository.findById(joinId).map(providerJoinTypeProduct -> {
            product.setProviderJoinProductType(providerJoinTypeProduct);
            return productRepository.save(product);
        }).orElseThrow(()->new ResourceNotFoundException(
                "Provider Join TypeProduct" + "Id" + joinId));
    }
    */

    @Override
    public Product updateProduct(Long providerJoinTypeProductId,Long productId, Product productDetails) {
        if(!providerJoinProductTypeRepository.existsById(providerJoinTypeProductId))
            throw new ResourceNotFoundException("ProviderJoinProduct","Id",providerJoinTypeProductId);

        return productRepository.findById(productId).map(product -> {
            product.setName(productDetails.getName());
            product.setDescription(productDetails.getDescription());
            return productRepository.save(product);
        }).orElseThrow(()->new ResourceNotFoundException("Product","Id",productId));
    }

    @Override
    public ResponseEntity<?> deleteProduct(Long providerJoinTypeProductId,Long productId) {
        return productRepository.findByIdAndProviderJoinProductTypeId(providerJoinTypeProductId,productId).map(product -> {
            productRepository.delete(product);
            return ResponseEntity.ok().build();
        }).orElseThrow(()->new ResourceNotFoundException(
                "Product not found with Id"+productId+"and ProviderJoinProductId"+providerJoinTypeProductId));
    }


    @Override
    public List<Product> getAllProductsByProviderJoinProductTypeId(Long providerJoinProductTypeId) {
        return productRepository.findAllByProviderJoinProductTypeId(providerJoinProductTypeId);
    }
}
