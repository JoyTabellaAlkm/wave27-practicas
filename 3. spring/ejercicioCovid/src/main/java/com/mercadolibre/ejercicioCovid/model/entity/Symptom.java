package com.mercadolibre.ejercicioCovid.model.entity;

import lombok.Data;


@Data
public class Symptom {

    private long codigo;
    private String name;
    private GravityLevel gravityLevel;
}
