package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.PersonajeDTO;
import com.mercadolibre.starwars.repository.PersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonajeService implements IPersonajeService {

    @Autowired
    PersonajeRepository repository;

    @Override
    public List<PersonajeDTO> getByName(String name) {
        return repository.getPersonajes().stream()
                .filter(personaje -> personaje.getName().contains(name))
                .map(personaje -> new PersonajeDTO(personaje.getName(), personaje.getHeight(), personaje.getMass(),
                personaje.getGender(), personaje.getHomeworld(), personaje.getSpecies()))
                .toList();
    }
}
