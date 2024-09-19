package ar.com.stardwards.stardward.service;

import ar.com.stardwards.stardward.dto.PersonajeDTO;

import java.util.List;

public interface IStarwarService {
    List<PersonajeDTO> buscarPersonajes(String name);
}
