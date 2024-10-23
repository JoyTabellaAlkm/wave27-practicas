package com.example.qatesters.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "test_case")
public class TestCase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_case")
    Long idCase;
    String description;
    Boolean tested;
    Boolean passed;
    @Column(name = "number_of_tries")
    int numberOfTries;
    @Column(name = "last_update")
    LocalDate lastUpdate;
}
