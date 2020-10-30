package com.upc.edu.pe.services;


import com.upc.edu.pe.models.PersonRequest;
import com.upc.edu.pe.models.Provider;

import java.util.List;

public interface PersonRequestService {
    PersonRequest create (Long personId, Long petId, Long providerId, Long productTypeId, Long productId, PersonRequest personRequest);
    List<PersonRequest> getAllByPersonId(Long personId);
    List<PersonRequest>  getRequestsByProviderId(Long providerId);

}
