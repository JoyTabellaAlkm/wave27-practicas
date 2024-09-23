package ar.com.mercadolibre.ejercicioCalorias.repository;

import ar.com.mercadolibre.ejercicioCalorias.entity.Ingrediente;
import ar.com.mercadolibre.ejercicioCalorias.entity.Plato;

import java.util.List;

public interface IRepository {
    double sumarCalorias(List<Ingrediente> ingredientes);
}
