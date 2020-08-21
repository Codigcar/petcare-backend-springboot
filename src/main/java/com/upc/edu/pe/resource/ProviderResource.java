package com.upc.edu.pe.resource;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProviderResource {
    private Long id;
    private String businessName;
    private String field;
    private String address;
    private String email;
    private String region;
    private String description;
    private String photo;
}
