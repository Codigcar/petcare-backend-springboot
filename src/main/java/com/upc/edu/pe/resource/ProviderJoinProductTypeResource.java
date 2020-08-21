package com.upc.edu.pe.resource;


import com.upc.edu.pe.models.ProductType;
import com.upc.edu.pe.models.Provider;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ProviderJoinProductTypeResource {

    private Long id;

    private Provider provider;


    private ProductType productType;
}
