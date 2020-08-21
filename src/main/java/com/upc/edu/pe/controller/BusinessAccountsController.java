package com.upc.edu.pe.controller;


import com.upc.edu.pe.models.BusinessProfile;
import com.upc.edu.pe.resource.BusinessProfileResource;
import com.upc.edu.pe.resource.save.SaveBusinessProfileResource;
import com.upc.edu.pe.services.BusinessProfileService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/business")
public class BusinessAccountsController {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private BusinessProfileService businessProfileService;

    @GetMapping("/{id}")
    public BusinessProfileResource getBusinessById(@PathVariable(name = "id")Long businessId){
        return convertToResource(businessProfileService.getBusinessById(businessId));
    }

    @PostMapping
    public BusinessProfileResource registerBusiness( @RequestBody SaveBusinessProfileResource resource){
        return convertToResource(businessProfileService.create(convertToEntity(resource)));
    }
    @GetMapping
    public ResponseEntity<List<BusinessProfileResource>> getAllBusiness(){
        List<BusinessProfile> businessProfiles = businessProfileService.getAllBusiness();
        List<BusinessProfileResource> businessProfilesResources = businessProfiles.stream().map(this::convertToResource).collect(Collectors.toList());
        return ResponseEntity.ok(businessProfilesResources);
    }

    private BusinessProfile convertToEntity(SaveBusinessProfileResource resource) {
        return mapper.map(resource, BusinessProfile.class);
    }

    private BusinessProfileResource convertToResource(BusinessProfile entity) {
        return mapper.map(entity, BusinessProfileResource.class);
    }

}
