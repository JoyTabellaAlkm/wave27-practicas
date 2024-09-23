package co.arg.mercadolibre.starwars.service;

import co.arg.mercadolibre.starwars.dto.PersonajeDTO;

import java.util.List;

public interface IPersonajeService {
    public List<PersonajeDTO> getPersonaje(String name);
}
