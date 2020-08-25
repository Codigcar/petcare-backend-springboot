package com.upc.edu.pe.services;


import com.upc.edu.pe.models.PersonRequest;

import java.util.List;

public interface PersonRequestService {
    PersonRequest create (Long peopleId, Long petId, Long providerId, Long servicesId, PersonRequest personRequest);
    List<PersonRequest> getAllByProductId(Long productId);
}
