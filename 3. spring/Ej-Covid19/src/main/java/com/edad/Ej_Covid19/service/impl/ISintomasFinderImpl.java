package com.edad.Ej_Covid19.service.impl;

import com.edad.Ej_Covid19.dto.PersonaDTO;
import com.edad.Ej_Covid19.modelo.Persona;
import com.edad.Ej_Covid19.modelo.Sintoma;
import com.edad.Ej_Covid19.service.ISintomasFinder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ISintomasFinderImpl implements ISintomasFinder {
    List<Sintoma> sintomas = List.of(new Sintoma("1", "tos", "leve"),
            new Sintoma("2", "dolorDeCabeza", "medio"),
            new Sintoma("3", "malaOxigenacion", "alto"));
    List<Persona> personas = List.of(
            new Persona(
                    "1",
                    "Maria",
                    "Marquez",
                    65,
                    List.of(new Sintoma("1", "tos", "leve"),
                            new Sintoma("2", "dolorDeCabeza", "medio"))
            ),
            new Persona(
                    "2",
                    "Jose",
                    "Lopez",
                    35,
                    List.of(new Sintoma("1", "tos", "leve"))
            ),
            new Persona(
                    "3",
                    "Pedro",
                    "Perez",
                    69,
                    List.of(new Sintoma("1", "tos", "leve"),
                            new Sintoma("2", "dolorDeCabeza", "medio"),
                            new Sintoma("3", "malaOxigenacion", "alto"))
            )
    );

    @Override
    public List<Sintoma> showAllSymptoms() {
        return sintomas;
    }

    @Override
    public String checkSymptom(String name) {
        Sintoma busquedaSintoma = sintomas.stream()
                .filter(sintoma ->sintoma.getNombre().equals(name)).findFirst().get();
        return busquedaSintoma.getNivelGravedad();
    }

    @Override
    public List<PersonaDTO> getRiskPerson() {
        List<PersonaDTO> personasDTO = new ArrayList<>();
        personas.stream()
                .filter(persona -> !persona.getSintomas().isEmpty() && persona.getEdad()>60)
                .forEach(persona -> personasDTO.add(
                        new PersonaDTO(persona.getNombre(), persona.getApellido(), persona.getEdad(), persona.getSintomas())));
        return personasDTO;
    }
}
