package ar.com.mercadolibre.ejercicioStarWars.service;

import ar.com.mercadolibre.ejercicioStarWars.entity.Personaje;

import java.util.List;
import java.util.Optional;

public interface IService {

    List<String> getPersonajeName(String name);
}
