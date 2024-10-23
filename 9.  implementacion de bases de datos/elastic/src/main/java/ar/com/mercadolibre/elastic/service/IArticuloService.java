package ar.com.mercadolibre.elastic.service;

import ar.com.mercadolibre.elastic.model.Articulo;

import java.util.Optional;

public interface IArticuloService {

    Articulo save(Articulo articulo);

    Optional<Articulo> findById(int id);

    Iterable<Articulo> findAll();

    void deleteById(int id);
}
