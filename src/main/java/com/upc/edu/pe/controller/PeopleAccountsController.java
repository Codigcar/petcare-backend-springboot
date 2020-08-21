package com.upc.edu.pe.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.upc.edu.pe.models.PersonProfile;
import com.upc.edu.pe.resource.PersonProfileResource;
import com.upc.edu.pe.resource.save.SavePersonProfileResource;
import com.upc.edu.pe.services.PersonProfileService;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/people")
public class PeopleAccountsController {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private PersonProfileService personProfileService;


    @GetMapping
    public ResponseEntity<List<PersonProfileResource>> getAllPeople(){
        List<PersonProfile> personProfiles = personProfileService.getAllPersons();
        List<PersonProfileResource>personProfileResources = personProfiles.stream().map(this::convertToResource).collect(Collectors.toList());
        return ResponseEntity.ok(personProfileResources);
    }

    @GetMapping("/{id}")
    public PersonProfileResource getPersonById(@PathVariable(name = "id")Long peopleId){
        return convertToResource(personProfileService.getPersonById(peopleId));
    }

    @PostMapping
    public PersonProfileResource createCustomer(@Valid @RequestBody SavePersonProfileResource resource){
        return convertToResource(personProfileService.createPerson(convertToEntity(resource)));
    }

    @PutMapping("/{id}")
    public PersonProfileResource updateCustomer(@PathVariable(name = "id")Long peopleId,
                                                @Valid @RequestBody SavePersonProfileResource resource){
        return convertToResource(personProfileService.updatePerson(peopleId,convertToEntity(resource)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable(name = "id") Long peopleId){
        return personProfileService.deletePerson(peopleId);
    }

    private PersonProfile convertToEntity(SavePersonProfileResource resource) {
        return mapper.map(resource, PersonProfile.class);
    }

    private PersonProfileResource convertToResource(PersonProfile entity) {
        return mapper.map(entity, PersonProfileResource.class);
    }

}
