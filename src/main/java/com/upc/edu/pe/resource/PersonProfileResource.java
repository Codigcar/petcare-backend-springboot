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
    private Long document;
    private String email;
    private Long phone;
    private Integer age;
    private String photo;
}
