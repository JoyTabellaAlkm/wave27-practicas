package ar.com.mercadolibre.covid.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Person {
    @Getter @Setter
    private UUID id;
    @Getter
    private String firstName;
    @Getter
    private String lastName;
    private int age;
    @Setter
    private List<Symptom> symptoms;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.symptoms = new ArrayList<>();
    }

    public boolean isRiskPerson() {
        return age > 60 && !symptoms.isEmpty();
    }
}
