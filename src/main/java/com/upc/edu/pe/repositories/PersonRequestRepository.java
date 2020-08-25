package com.upc.edu.pe.repositories;

import com.upc.edu.pe.models.PersonRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRequestRepository extends JpaRepository<PersonRequest,Long> {

    @Query("SELECT p from PersonRequest p where p.product.id = ?1")
    List<PersonRequest> getAllByProductId(Long productId);
}
