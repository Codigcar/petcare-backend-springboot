package com.upc.edu.pe.services;


import com.upc.edu.pe.models.PersonRequest;

import java.util.List;

public interface PersonRequestService {
    PersonRequest create (Long personId, Long petId, Long providerId, Long productTypeId, Long productId, PersonRequest personRequest);
    List<PersonRequest> getAllByProductId(Long productId);
}
