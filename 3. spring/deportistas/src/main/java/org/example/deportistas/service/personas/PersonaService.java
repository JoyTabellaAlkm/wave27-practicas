package org.example.deportistas.service.personas;

import org.example.deportistas.dto.SportsPersonsDto;
import org.example.deportistas.repository.personas.IPersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonaService implements IPersonaService {
    @Autowired
    private IPersonaRepository personaRepository;

    @Override
    public List<SportsPersonsDto> findSportsPersons() {
        return personaRepository.getAll()
                .stream()
                .filter(p -> p.getDeporte() != null)
                .map(p-> new SportsPersonsDto(
                        p.getNombre() + " " + p.getApellido(),
                        p.getDeporte().getNombre()))
                .toList();
    }
}
