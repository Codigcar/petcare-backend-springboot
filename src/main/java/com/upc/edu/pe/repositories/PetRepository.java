package com.upc.edu.pe.repositories;

import com.upc.edu.pe.models.Pet;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PetRepository extends JpaRepository<Pet,Long> {
    List<Pet> findByPersonProfileId(Long personId, Pageable pageable);
    Optional<Pet> findByIdAndPersonProfileId(Long petId, Long personId);
}