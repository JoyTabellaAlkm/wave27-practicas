package org.example.starwars_ejercicio.services;

import org.example.starwars_ejercicio.dtos.PersonajeDTO;
import org.example.starwars_ejercicio.entities.Personaje;
import org.example.starwars_ejercicio.repositories.IStarWarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StarWarsService implements IStarWarsService {
    @Autowired
    private IStarWarsRepository repository;

    @Override
    public List<PersonajeDTO> findByName(String name) {
        List<Personaje> personajes = repository.findByName(name);
        List<PersonajeDTO> dto = new ArrayList<>();
        for (Personaje personaje : personajes) {
            PersonajeDTO dtoPersonaje = new PersonajeDTO();
            dtoPersonaje.setName(personaje.getName());

            try{
                dtoPersonaje.setHeight(Integer.parseInt(personaje.getHeight()));
            }
            catch (NumberFormatException e){
                dtoPersonaje.setHeight(0);
            }

            try{
                dtoPersonaje.setMass(Integer.parseInt(personaje.getMass()));
            }
            catch (NumberFormatException e){
                dtoPersonaje.setMass(0);
            }

            dtoPersonaje.setGender(personaje.getGender());
            dtoPersonaje.setHomeworld(personaje.getHomeworld());
            dtoPersonaje.setSpecies(personaje.getSpecies());
            dto.add(dtoPersonaje);
        }
        return dto;
    }
}
