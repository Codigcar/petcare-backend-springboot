package com.upc.edu.pe.services;



import java.util.List;

import com.upc.edu.pe.models.BusinessProfile;

public interface BusinessProfileService {
    BusinessProfile create (BusinessProfile businessProfile);
    List<BusinessProfile> getAllBusiness();
    BusinessProfile getBusinessById(Long businessId);
}
