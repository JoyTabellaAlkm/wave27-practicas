package com.ejercicios.covid19.repository;

import com.ejercicios.covid19.dto.PersonaRiesgoDTO;

import java.util.List;

public interface IPersonaRiesgoRepository {
    List<PersonaRiesgoDTO> verPersonasRiesgo();
}
