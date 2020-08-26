package com.upc.edu.pe.repositories;
import com.upc.edu.pe.models.MedicalProfile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MedicalProfileRepository extends JpaRepository<MedicalProfile,Long> {
    Page<MedicalProfile> findByPetId(Long petId, Pageable pageable);
    Optional<MedicalProfile> findByIdAndPetId(Long profileId, Long petId);
}
