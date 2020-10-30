package com.upc.edu.pe.controller;

import com.upc.edu.pe.models.PersonRequest;
import com.upc.edu.pe.models.ProductType;
import com.upc.edu.pe.resource.PersonRequestResource;
import com.upc.edu.pe.resource.save.SavePersonRequestResource;
import com.upc.edu.pe.services.PersonRequestService;
import com.upc.edu.pe.services.ProviderJoinProductTypeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/people/{personId}/pets/{petId}/providers/{providerId}/productType/{productTypeId}/products/{productId}/requests")
public class PersonRequestController {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private PersonRequestService personRequestService;

    @PostMapping
    public PersonRequestResource create(@PathVariable("personId") Long personId,
                                        @PathVariable("petId") Long petId,
                                        @PathVariable("providerId") Long providerId,
                                        @PathVariable("productTypeId") Long productTypeId,
                                        @PathVariable("productId") Long productId,
                                        @RequestBody SavePersonRequestResource resource){
        return convertToResource(
                personRequestService.create(personId,petId,providerId,productTypeId,productId,convertToEntity(resource)));
    }

    private PersonRequest convertToEntity(SavePersonRequestResource resource) {
        return mapper.map(resource, PersonRequest.class);
    }

    private PersonRequestResource convertToResource(PersonRequest entity) {
        return mapper.map(entity, PersonRequestResource.class);
    }

}

@RequestMapping("/api/people/{personId}/request")
@RestController
class PersonRequestGetController {

    @Autowired
    private PersonRequestService personRequestService;

    @GetMapping
    public ResponseEntity<List<PersonRequest>> getRequest(@PathVariable(name = "personId")Long personId){
        return ResponseEntity.ok(personRequestService.getAllByPersonId(personId));
    }
}
