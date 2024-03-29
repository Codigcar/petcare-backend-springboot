package com.upc.edu.pe.services;


import com.upc.edu.pe.models.Pet;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PetService {

    List<Pet> getAllPetsByPersonProfileId(Long personId, Pageable pageable);
    Pet getPetByPeopleId(Long personId,Long petId);
    Object createPet(Long personId, Pet pet);
    Pet updatePet(Long personId,Long petId,Pet petRequest);
    ResponseEntity<?> deletePet(Long personId,Long petId);
}
