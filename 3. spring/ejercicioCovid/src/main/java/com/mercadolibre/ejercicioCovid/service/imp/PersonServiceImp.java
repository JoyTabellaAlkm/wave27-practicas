package com.mercadolibre.ejercicioCovid.service.imp;

import com.mercadolibre.ejercicioCovid.model.dto.PersonDTO;
import com.mercadolibre.ejercicioCovid.model.entity.GravityLevel;
import com.mercadolibre.ejercicioCovid.model.entity.Person;
import com.mercadolibre.ejercicioCovid.model.entity.Symptom;
import com.mercadolibre.ejercicioCovid.service.PersonService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
public class PersonServiceImp implements PersonService {
    private List<Person> people = new ArrayList<>();

    @Override
    public List<PersonDTO> findAllRiskPersons() {
        addPersons();
        System.out.println(people);
        return people.stream()
                .filter(Person::inRisk)
                .map(p -> new PersonDTO(
                        p.getName(),
                        p.getLastname()
                )).toList();
    }

    private void addPersons() {
        Random random = new Random();
        // add symptoms
        Symptom symptom = new Symptom();
        symptom.setName("Fiebre");
        symptom.setCodigo(1);
        symptom.setGravityLevel(GravityLevel.MEDIUM);


        for (int i = 0; i < 10; i++) {
            Person person = new Person();
            person.setId(i);
            person.setAge(65);
            person.setName("Nombre" + i);
            person.setLastname("Apellido " + i);
            person.setSymptoms(Arrays.asList(symptom));
            people.add(person);
        }
    }
}
