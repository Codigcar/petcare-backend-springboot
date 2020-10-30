package com.upc.edu.pe.controller;


import com.upc.edu.pe.models.Provider;
import com.upc.edu.pe.resource.ProviderResource;
import com.upc.edu.pe.resource.save.SaveProviderResource;
import com.upc.edu.pe.services.ProviderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/providers")
public class ProvidersController {
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private ProviderService providerService;

    @GetMapping
    public ResponseEntity<List<ProviderResource>> getAllProviders(){
        List<Provider> providers = providerService.getAllProviders();
        List<ProviderResource> providerResources = providers.stream().map(this::convertToResource).collect(Collectors.toList());
        return ResponseEntity.ok(providerResources);
    }

    private Provider convertToEntity(SaveProviderResource resource) {

        return mapper.map(resource, Provider.class);
    }

    private ProviderResource convertToResource(Provider entity) {

        return mapper.map(entity, ProviderResource.class);
    }

}
