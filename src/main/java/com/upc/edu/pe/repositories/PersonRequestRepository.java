package com.upc.edu.pe.repositories;

import com.upc.edu.pe.models.PersonRequest;
import com.upc.edu.pe.models.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRequestRepository extends JpaRepository<PersonRequest,Long> {

    @Query("SELECT p from PersonRequest p where p.pet.personProfile.id  = ?1")
    List<PersonRequest> getAllRequestByPersonId(Long personId);

    @Query("SELECT p from PersonRequest p where p.product.providerJoinProductType.provider.id = ?1")
    List<PersonRequest> getRequestsByProviderId(Long providerId);
}
