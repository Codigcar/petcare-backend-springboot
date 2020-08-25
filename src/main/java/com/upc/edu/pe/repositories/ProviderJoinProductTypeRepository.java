package com.upc.edu.pe.repositories;


import com.upc.edu.pe.models.Product;
import com.upc.edu.pe.models.ProductType;
import com.upc.edu.pe.models.Provider;
import com.upc.edu.pe.models.ProviderJoinProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProviderJoinProductTypeRepository extends JpaRepository<ProviderJoinProductType,Long> {

    @Query("select pjpt from ProviderJoinProductType  pjpt where pjpt.provider.id = ?1")
    List<ProductType> getAllProductTypesByProviderId(Long providerId);



}
