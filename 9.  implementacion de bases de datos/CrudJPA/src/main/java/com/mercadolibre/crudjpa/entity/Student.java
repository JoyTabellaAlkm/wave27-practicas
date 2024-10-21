package com.mercadolibre.crudjpa.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Student {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 15, nullable = false)
    private String dni;
    @Column(length = 20, nullable = false)
    private String name;
    @JsonProperty("last_name")
    @Column(name = "last_name", length = 20, nullable = false)
    private String lastname;
}
