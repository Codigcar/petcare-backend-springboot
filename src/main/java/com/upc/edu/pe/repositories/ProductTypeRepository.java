package com.upc.edu.pe.repositories;

import com.upc.edu.pe.models.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductTypeRepository extends JpaRepository<ProductType,Long> {

    @Query("select p.id from ProductType p where p.name = ?1")
    Long getIdByProductTypeName(String name);

}
