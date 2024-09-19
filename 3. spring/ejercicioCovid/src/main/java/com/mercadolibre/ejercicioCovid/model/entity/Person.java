package com.mercadolibre.ejercicioCovid.model.entity;

import lombok.Data;

import java.util.List;

@Data
public class Person {
    private static final int RISK_AGE = 60;

    private long id;
    private String name;
    private String lastname;
    private int age;
    private List<Symptom> symptoms;

    public boolean inRisk() {
        return !symptoms.isEmpty() && age > RISK_AGE;
    }
}
