package ar.com.mercadolibre.ejercicioCalorias.service;

import ar.com.mercadolibre.ejercicioCalorias.dto.getCaloriesDTO;
import ar.com.mercadolibre.ejercicioCalorias.entity.Ingrediente;
import ar.com.mercadolibre.ejercicioCalorias.entity.Plato;

import java.util.List;

public interface IPlatoService {
    double getCaloriasPlato(getCaloriesDTO dto);
    List<Ingrediente> getListaIngredientesPlato(String namePlato);
    Ingrediente getIngredienteMasCaloria();
    List<Plato> getAllPlatos();
}
