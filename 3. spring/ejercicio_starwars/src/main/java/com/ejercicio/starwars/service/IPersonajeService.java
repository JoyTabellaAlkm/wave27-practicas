package com.ejercicio.starwars.service;

import com.ejercicio.starwars.dto.PersonajeDTO;

import java.io.IOException;
import java.util.List;

public interface IPersonajeService {

    List<PersonajeDTO> getAll() throws IOException;

    List<PersonajeDTO> listByName(String name);
}
