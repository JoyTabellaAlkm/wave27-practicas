package ar.com.mercadolibre.starwars.repository;

import ar.com.mercadolibre.starwars.entity.Personaje;

import java.util.List;

public interface PersonajesRepository {
    List<Personaje> findAll();
}
