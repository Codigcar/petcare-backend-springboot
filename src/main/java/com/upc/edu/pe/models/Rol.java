package com.upc.edu.pe.models;

import lombok.*;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Objects;

@Data
@Entity
@NoArgsConstructor
@Builder
@Table(name = "roles")
public class Rol {

    @Id
    private Long id;


    @NotEmpty(message = "the name can't be empty")
    @Column(name = "name",nullable = false)
    private String name;

    public Rol(Long id,String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Rol other = (Rol) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }
    @Override
    public String toString() {

        var builder = new StringBuilder();
        builder.append("rol{id=").append(id).append(", name=")
                .append(name);

        return builder.toString();
    }


}
