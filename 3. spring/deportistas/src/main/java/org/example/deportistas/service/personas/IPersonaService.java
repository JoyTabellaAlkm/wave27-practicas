package org.example.deportistas.service.personas;

import org.example.deportistas.dto.SportsPersonsDto;

import java.util.List;

public interface IPersonaService {
    List<SportsPersonsDto> findSportsPersons();
}
