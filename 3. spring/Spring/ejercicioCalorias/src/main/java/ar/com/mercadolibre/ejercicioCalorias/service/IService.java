package ar.com.mercadolibre.ejercicioCalorias.service;

import ar.com.mercadolibre.ejercicioCalorias.entity.Ingrediente;
import ar.com.mercadolibre.ejercicioCalorias.entity.Plato;

import java.util.List;

public interface IService {
    double getCaloriasPlato(String namePlato);
    List<Ingrediente> getListaIngredientesPlato(String namePlato);
    Ingrediente getIngredienteMasCaloria(String name);
    List<Plato> getAllPlatos();
}
