package com.ejercicios.deportes.repository.impl;

import com.ejercicios.deportes.dto.PersonaDTO;
import com.ejercicios.deportes.model.Persona;
import com.ejercicios.deportes.repository.IPersonaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonaRepositoryImpl implements IPersonaRepository {
    List<PersonaDTO> listaPersonasDeportistas = new ArrayList<>();
    DeporteRepositoryImpl deporteRepository = new DeporteRepositoryImpl();

    public PersonaRepositoryImpl() {
        Persona persona1 = new Persona(1L, "Cristiano", "Ronaldo", 37, deporteRepository.listaDeportes.get(0));
        Persona persona2 = new Persona(2L, "Lebron", "James", 34, deporteRepository.listaDeportes.get(1));
        Persona persona3 = new Persona(3L, "Luis", "Rodriguez", 53, deporteRepository.listaDeportes.get(2));


        PersonaDTO personaDTO1 = new PersonaDTO(persona1.getNombre() + " " + persona1.getApellido(), persona1.getDeporte().getNombre());
        PersonaDTO personaDTO2 = new PersonaDTO(persona2.getNombre() + " " + persona2.getApellido(), persona2.getDeporte().getNombre());
        PersonaDTO personaDTO3 = new PersonaDTO(persona3.getNombre() + " " + persona3.getApellido(), persona3.getDeporte().getNombre());
        listaPersonasDeportistas.add(personaDTO1);
        listaPersonasDeportistas.add(personaDTO2);
        listaPersonasDeportistas.add(personaDTO3);

    }

    @Override
    public List<PersonaDTO> verPersonasDeportistas() {
        return listaPersonasDeportistas;
    }
}
