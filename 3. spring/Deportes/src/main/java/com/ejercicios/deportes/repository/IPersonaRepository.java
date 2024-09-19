package com.ejercicios.deportes.repository;

import com.ejercicios.deportes.dto.PersonaDTO;

import java.util.List;

public interface IPersonaRepository {
    List<PersonaDTO> verPersonasDeportistas();
}
