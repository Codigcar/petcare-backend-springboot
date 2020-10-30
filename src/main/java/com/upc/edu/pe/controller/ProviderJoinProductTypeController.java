package com.upc.edu.pe.controller;


import com.upc.edu.pe.models.ProductType;
import com.upc.edu.pe.models.ProviderJoinProductType;
import com.upc.edu.pe.resource.ProviderJoinProductTypeResource;
import com.upc.edu.pe.resource.save.SaveProviderJoinProductTypeResource;
import com.upc.edu.pe.services.ProviderJoinProductTypeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/api/business/{businessId}/provider/{providerId}/products-types")
@RestController
public class ProviderJoinProductTypeController {
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private ProviderJoinProductTypeService providerJoinProductTypeService;

    @PostMapping("/{productTypeId}")
    public ProviderJoinProductTypeResource createRelationship(@PathVariable(name = "businessId")Long businessId,
                                                              @PathVariable(name = "providerId")Long providerId,
                                                              @PathVariable(name = "productTypeId")Long productTypeId,
                                                              @Valid @RequestBody SaveProviderJoinProductTypeResource resource){
        return convertToResource(providerJoinProductTypeService.createRelationship(businessId,providerId,productTypeId,convertToEntity(resource)));
    }


    @GetMapping
    public ResponseEntity<List<ProductType>> getProductTypeByProviderId(@PathVariable(name = "providerId")Long providerId){
        return ResponseEntity.ok(providerJoinProductTypeService.getProductTypesByProviderId(providerId));
    }

    private ProviderJoinProductType convertToEntity(SaveProviderJoinProductTypeResource resource) {
        return mapper.map(resource, ProviderJoinProductType.class);
    }

    private ProviderJoinProductTypeResource convertToResource(ProviderJoinProductType entity) {
        return mapper.map(entity, ProviderJoinProductTypeResource.class);
    }

}

@RequestMapping("/api/provider/{providerId}/products-types")
@RestController
class ProviderJoinProductTypeGetController {

    @Autowired
    private ProviderJoinProductTypeService providerJoinProductTypeService;

    @GetMapping
    public ResponseEntity<List<ProductType>> getProductTypeByProviderId(@PathVariable(name = "providerId")Long providerId){
        return ResponseEntity.ok(providerJoinProductTypeService.getProductTypesByProviderId(providerId));
    }
}

