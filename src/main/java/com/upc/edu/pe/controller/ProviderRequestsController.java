package com.upc.edu.pe.controller;

import com.upc.edu.pe.models.PersonRequest;
import com.upc.edu.pe.models.Provider;
import com.upc.edu.pe.resource.PersonRequestResource;
import com.upc.edu.pe.resource.save.SavePersonRequestResource;
import com.upc.edu.pe.services.PersonRequestService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/provider/{providerId}/requests")
public class ProviderRequestsController {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private PersonRequestService personRequestService;

    @GetMapping
    public ResponseEntity<List<PersonRequest>> getProviderByProviderId(@PathVariable(name = "providerId")Long providerId){
        return ResponseEntity.ok(personRequestService.getRequestsByProviderId(providerId));
    }

    private PersonRequest convertToEntity(SavePersonRequestResource resource) {
        return mapper.map(resource, PersonRequest.class);
    }

    private PersonRequestResource convertToResource(PersonRequest entity) {
        return mapper.map(entity, PersonRequestResource.class);
    }

}
