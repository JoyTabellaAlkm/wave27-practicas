package ar.com.mercadolibre.obras.service;

import ar.com.mercadolibre.obras.model.Obra;

import java.util.List;

public interface IObraService {

    Obra save(Obra obra);
    List<Obra> getAllObras();
    List<Obra> getObrasByName(String name);
    List<Obra> getObraByAutor(String autor);
    List<Obra> getObrasByNameFuzzy(String name);
    List<Obra> getTopByPaginas();
    List<Obra> getObrasByAnio(Integer year);
    List<Obra> getByEditorial(String editorial);
}
