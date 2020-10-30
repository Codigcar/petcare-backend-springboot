package com.upc.edu.pe.controller;


import com.upc.edu.pe.models.Provider;
import com.upc.edu.pe.resource.ProviderResource;
import com.upc.edu.pe.resource.save.SaveProviderResource;
import com.upc.edu.pe.services.ProviderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/business/{businessId}/providers")
public class BusinessProvidersController {
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private ProviderService providerService;

    @GetMapping("/{providerId}")
    public ProviderResource getProviderById(@PathVariable(name = "providerId")Long providerId){
        return convertToResource(providerService.getProviderById(providerId));
    }

    @PostMapping
    public ProviderResource createProvider(@PathVariable("businessId") Long businessId,
            @Valid @RequestBody SaveProviderResource resource){
        Provider provider=convertToEntity(resource);
        return convertToResource(providerService.createProvider(businessId, provider));
    }

    @PutMapping("/{providerId}")
    public ProviderResource updateProvider( @PathVariable("businessId") Long businessId,
                                            @PathVariable(name = "providerId")Long providerId,
                                            @Valid @RequestBody SaveProviderResource resource){
        Provider provider=convertToEntity(resource);
        return convertToResource(providerService.updateProvider(businessId, providerId,provider));
    }

    @DeleteMapping("/{providerId}")
    public ResponseEntity<?> deleteProvider(@PathVariable(name ="providerId")Long providerId){
        return providerService.deleteProvider(providerId);
    }

    private Provider convertToEntity(SaveProviderResource resource) {

        return mapper.map(resource, Provider.class);
    }

    private ProviderResource convertToResource(Provider entity) {

        return mapper.map(entity, ProviderResource.class);
    }

}
