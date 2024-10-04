package co.com.mercadolibre.StarWars.service;

import co.com.mercadolibre.StarWars.dto.PersonajeDTO;

public interface IPersonajeService {
    public PersonajeDTO getPersonaje(String name);
}
