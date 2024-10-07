package ar.com.mercadolibre.covid.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Person {
    private int id;
    private String name;
    private String lastName;
    private int age;
    private List<Symptom> symptoms;

    public boolean isRiskyPerson(){
        return age > 60 && !symptoms.isEmpty();
    }
}
