package com.ejercicio.starwars.service.impl;

import com.ejercicio.starwars.dto.PersonajeDTO;
import com.ejercicio.starwars.entity.Personaje;
import com.ejercicio.starwars.repository.PersonajeRepository;
import com.ejercicio.starwars.service.IPersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PersonajeService implements IPersonajeService {

    @Autowired
    PersonajeRepository personajeRepository;

    @Override
    public List<PersonajeDTO> getAll() throws IOException {
        List<PersonajeDTO> personajeDTOS = new ArrayList<>();
        List<Personaje> personajes = personajeRepository.loadFile();

        for (Personaje personaje : personajes) {
            PersonajeDTO personajeDTO = new PersonajeDTO();
            personajeDTO.setGender(personaje.getGender());
            personajeDTO.setHeight(personaje.getHeight());
            personajeDTO.setHomeworld(personaje.getHomeworld());
            personajeDTO.setMass(personaje.getMass());
            personajeDTO.setName(personaje.getName().toLowerCase());
            personajeDTO.setSpecies(personaje.getSpecies());

            personajeDTOS.add(personajeDTO);
        }

        return personajeDTOS;
    }

    @Override
    public List<PersonajeDTO> listByName(String name) {
        try {
            List<PersonajeDTO> personajeDTOS = getAll();
            return personajeDTOS.stream().filter(p->p.getName().contains(name.toLowerCase())).toList();

        } catch (Exception e) {
            System.out.println("Hubo un error: " + e.getMessage());
        }

        return List.of();
    }

}
