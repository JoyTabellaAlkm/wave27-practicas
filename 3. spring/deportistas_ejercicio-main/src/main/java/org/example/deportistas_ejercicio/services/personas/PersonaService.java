package org.example.deportistas_ejercicio.services.personas;

import org.example.deportistas_ejercicio.dto.SportsPersonsDTO;
import org.example.deportistas_ejercicio.entities.Persona;
import org.example.deportistas_ejercicio.repositories.personas.IPersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonaService implements IPersonaService {
    @Autowired
    private IPersonaRepository personaRepository;

    @Override
    public List<SportsPersonsDTO> findSportsPersons() {
        return personaRepository.getAll()
                .stream()
                .filter(p -> p.getDeporte() != null)
                .map(p-> new SportsPersonsDTO(
                        p.getNombre() + " " + p.getApellido(),
                        p.getDeporte().getNombre()))
                .toList();
    }
}
