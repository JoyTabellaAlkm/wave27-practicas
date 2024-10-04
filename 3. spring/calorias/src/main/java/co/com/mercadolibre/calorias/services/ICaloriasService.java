package co.com.mercadolibre.calorias.services;


import co.com.mercadolibre.calorias.entity.Ingrediente;
import co.com.mercadolibre.calorias.entity.Plato;

import java.util.List;

public interface ICaloriasService {
    List<Ingrediente> listaIngredientes(String name);
    double calcularCalorias(String name);
}
