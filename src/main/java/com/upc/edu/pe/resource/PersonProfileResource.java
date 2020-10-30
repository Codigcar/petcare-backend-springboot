package com.upc.edu.pe.resource;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("unused")
@Getter
@Setter
public class PersonProfileResource {
    private Long id;
    private String name;
    private String password;
    private String lastName;
    private String document;
    private String email;
    private String phone;
    private String age;
    private String photo;
}
