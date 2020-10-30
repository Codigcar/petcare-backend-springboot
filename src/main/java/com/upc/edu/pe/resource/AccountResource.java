package com.upc.edu.pe.resource;

import com.upc.edu.pe.models.Rol;
import com.upc.edu.pe.models.SubscriptionPlan;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountResource {
    private Long id;
    private String user;
    private String password;
    private Rol rol;

}
