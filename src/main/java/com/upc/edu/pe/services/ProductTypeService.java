package com.upc.edu.pe.services;


import com.upc.edu.pe.models.ProductType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductTypeService {
    List<ProductType> getAllProductsTypes();
    ProductType getServiceTypeById(Long serviceTypeId);
    ProductType createServiceType(ProductType productType);
    ProductType updateServiceType(Long serviceTypeId, ProductType productTypeRequest);
    ResponseEntity<?> deleteServiceType(Long serviceTypeId);

    Long getIdByProductTypeName(String name);


}
