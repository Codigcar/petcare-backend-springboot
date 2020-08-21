package com.upc.edu.pe.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.upc.edu.pe.models.BusinessProfile;

@Repository
public interface BusinessProfileRepository extends JpaRepository<BusinessProfile,Long> {
}
