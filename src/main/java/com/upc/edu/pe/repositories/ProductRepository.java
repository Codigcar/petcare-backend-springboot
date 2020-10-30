package com.upc.edu.pe.repositories;


import com.upc.edu.pe.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    Page<Product> findAllByProviderJoinProductTypeId(Long providerProductId, Pageable pageable);
    // Optional<Product> findByIdAndProviderJoinProductTypeId(Long providerId,Long providerProductId);
    @Query("select a from Product a where a.providerJoinProductType.provider.id = ?1 and a.providerJoinProductType.productType.id = ?2")
    List<Product> getAllProductsByProviderIdAndProductTypeId(Long providerId, Long productTypeId);

    List<Product> findAllByProviderJoinProductTypeId(Long providerJoinProductType);

}
