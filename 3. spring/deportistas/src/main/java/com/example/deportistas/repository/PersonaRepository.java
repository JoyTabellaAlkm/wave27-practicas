package com.example.deportistas.repository;

import com.example.deportistas.entity.Persona;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonaRepository {

    private List<Persona> personas;

    public PersonaRepository() {
        personas = new ArrayList<>();
        addPersonas();
    }

    public List<Persona> findAll() {
        addPersonas();

        return personas;
    }

    private void addPersonas() {
        Persona juan = new Persona(1, "Juan", "Perez", 25, 1);
        Persona maria = new Persona(2, "Maria", "Gomez", 30, 2);
        Persona pedro = new Persona(3, "Pedro", "Gonzalez", 35, 3);
        Persona ana = new Persona(4, "Ana", "Rodriguez", 40, 4);

        personas.add(juan);
        personas.add(maria);
        personas.add(pedro);
        personas.add(ana);
    }
}
