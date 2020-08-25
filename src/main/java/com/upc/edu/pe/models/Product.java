package com.upc.edu.pe.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "products")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "The name can't be empty")
    @Column(nullable = false)
    private String name;

    @NotEmpty(message = "The description can't be empty")
    @Column(nullable = false)
    private String description;

    //RelationShips
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "product_type_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private ProviderJoinProductType providerJoinProductType;

}
