package com.example.starwars.service.impl;

import com.example.starwars.dto.PersonajeDto;
import com.example.starwars.repository.IPersonajeRepository;
import com.example.starwars.service.IPersonajeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PersonajeServices implements IPersonajeServices {
    @Autowired
    IPersonajeRepository personajeRepository;

    public List<PersonajeDto> getPersonajes(String nombre) {

        return personajeRepository.getPersonajes().stream()
                .filter(p-> p.getName().contains(nombre))
                .map(p-> new PersonajeDto(p.getName(),p.getHeight(),p.getMass(), p.getGender(),
                        p.getHomeworld(),p.getSpecies())).toList();
    }
}
