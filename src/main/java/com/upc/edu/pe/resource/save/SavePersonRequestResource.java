package com.upc.edu.pe.resource.save;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class SavePersonRequestResource {

    private Date dateReservation;

    private String startTime;

    private String endTime;

    private String veterinaryName;

    private String productTypeName;

    private String productName;

    private String petName;

    private int status;

    private String PersonName;
}
