package com.upc.edu.pe.services;


import org.springframework.http.ResponseEntity;

import com.upc.edu.pe.models.PersonProfile;

import java.util.List;

public interface PersonProfileService {
    List<PersonProfile> getAllPersons();
    PersonProfile getPersonById(Long personId);
    PersonProfile createPerson(PersonProfile personProfile);
    PersonProfile updatePerson(Long personId, PersonProfile personProfileRequest);
    ResponseEntity<?> deletePerson(Long personId);
    //List<PersonProfile> getPersonProfileByPersonId (Long personId, Pageable pageable);

}
