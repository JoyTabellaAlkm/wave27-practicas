package com.ejercicios.covid19.service;

import com.ejercicios.covid19.dto.PersonaRiesgoDTO;

import java.util.List;

public interface IPersonaService {

    public List<PersonaRiesgoDTO> verPersonasConRiesgo();
}
