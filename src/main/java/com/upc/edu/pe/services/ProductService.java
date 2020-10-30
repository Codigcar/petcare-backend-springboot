package com.upc.edu.pe.services;

import com.upc.edu.pe.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {
    Page<Product> getAllByProviderJoinTypeProductId (Long providerJoinTypeProductId, Pageable pageable);
     Product createProduct(Long businessId,Long providerId, Long providerJoinTypeProductId,Product product);
    Product updateProduct(Long providerJoinTypeProductId,Long productId,Product productDetails);
    /*ResponseEntity<?> deleteProduct(Long providerJoinTypeProductId,Long productId);*/
    List<Product> getAllProductsByProviderJoinProductTypeId(Long providerJoinProductTypeId);

    List<Product> getAllProductsByProviderIdAndProductTypeId(Long providerId, Long productTypeId);

}
