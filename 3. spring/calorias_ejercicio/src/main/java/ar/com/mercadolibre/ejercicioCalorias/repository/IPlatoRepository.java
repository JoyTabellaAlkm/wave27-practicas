package ar.com.mercadolibre.ejercicioCalorias.repository;

import ar.com.mercadolibre.ejercicioCalorias.entity.Ingrediente;
import ar.com.mercadolibre.ejercicioCalorias.entity.Plato;

import java.util.List;
import java.util.Optional;

public interface IPlatoRepository {
    double sumarCalorias(List<Ingrediente> ingredientes);
    Ingrediente getIngredienteMayor();
    List<Plato> getAllPlatos();
    Optional<Plato> getFindByName(String platoAConsultar);
    List<Plato> getFindByName(List<String> platos);
}
