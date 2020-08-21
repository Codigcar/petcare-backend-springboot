package com.upc.edu.pe.resource.save;


import lombok.Getter;
import lombok.Setter;


@SuppressWarnings("unused")
@Getter
@Setter
public class SaveBusinessProfileResource {

    private String name;
    private String password;
    private String lastName;
    private Long document;
    private String email;
    private Long phone;
    private Integer age;
    private boolean owner;
}
