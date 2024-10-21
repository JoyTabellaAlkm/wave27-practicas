package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "models")
@Data
public class Model {
    @Id
    private Long id;

    private String name;
    private Double rating;

    @Column(name = "amount_of_awards")
    private Integer awards;
}
