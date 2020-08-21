package com.upc.edu.pe.resource.save;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@SuppressWarnings("unused")
@Getter
@Setter
public class SavePersonProfileResource {

    private String name;
    private String password;
    private String lastName;
    private Long document;
    private String email;
    private Long phone;
    private Integer age;
    private String photo;
}
