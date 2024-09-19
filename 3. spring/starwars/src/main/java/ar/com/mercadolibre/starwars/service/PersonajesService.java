package ar.com.mercadolibre.starwars.service;

import ar.com.mercadolibre.starwars.dto.PersonajeDto;

import java.util.List;

public interface PersonajesService {
    List<PersonajeDto> getFiltered(String nombre);
}
