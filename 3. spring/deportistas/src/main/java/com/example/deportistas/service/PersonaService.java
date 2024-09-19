package com.example.deportistas.service;

import com.example.deportistas.dto.PersonaDTO;

import java.util.List;

public interface PersonaService {
    List<PersonaDTO> findSportsPersons(String sportName);
}
