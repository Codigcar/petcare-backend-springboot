package com.upc.edu.pe.controller;


import com.upc.edu.pe.models.ProductType;
import com.upc.edu.pe.resource.ProductTypeResource;
import com.upc.edu.pe.resource.save.SaveProductTypeResource;
import com.upc.edu.pe.services.ProductTypeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/admin/product-types")
public class ProductTypeController {
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private ProductTypeService productTypeService;

    @GetMapping
    public ResponseEntity<List<ProductTypeResource>> getAllProductType()
    {
        List<ProductType> productTypes = productTypeService.getAllProductsTypes();
        List<ProductTypeResource> productTypeResources = productTypes.stream().map(this::convertToResource).collect(Collectors.toList());
        return ResponseEntity.ok(productTypeResources);

    }
    @GetMapping("/{name}")
    public ResponseEntity<Long> getIdByProductTypeName(@PathVariable(name = "name") String name){
        return ResponseEntity.ok(productTypeService.getIdByProductTypeName(name));
    }


    @GetMapping("/{id}")
    public ProductTypeResource getProductTypeById(@PathVariable(name = "id")Long serviceTypeId){
        return convertToResource(productTypeService.getServiceTypeById(serviceTypeId));
    }

    @PostMapping
    public ProductTypeResource createProductType (@Valid @RequestBody SaveProductTypeResource resource){
        return convertToResource(productTypeService.createServiceType(convertToEntity(resource)));
    }

    @PutMapping("/{id}")
    public ProductTypeResource updateProductType (@PathVariable(name = "id")Long serviceTypeId,
                                                  @Valid @RequestBody SaveProductTypeResource resource){
        return convertToResource(productTypeService.updateServiceType(serviceTypeId,convertToEntity(resource)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProductType (@PathVariable(name = "id") Long serviceTypeId){
        return productTypeService.deleteServiceType(serviceTypeId);
    }


    private ProductType convertToEntity(SaveProductTypeResource resource) {
        return mapper.map(resource, ProductType.class);
    }

    private ProductTypeResource convertToResource(ProductType entity) {
        return mapper.map(entity, ProductTypeResource.class);
    }

}
