package com.upc.edu.pe.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.upc.edu.pe.models.PersonProfile;


@Repository
public interface PersonProfileRepository extends JpaRepository<PersonProfile,Long> {
    //List<PersonProfile> findByProviderId (Long providerId, Pageable pageable);
}
