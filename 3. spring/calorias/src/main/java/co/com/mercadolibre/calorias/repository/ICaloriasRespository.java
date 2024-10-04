package co.com.mercadolibre.calorias.repository;

import co.com.mercadolibre.calorias.entity.Plato;

import java.util.List;

public interface ICaloriasRespository {
    List<Plato> obtenerPlatos();
}
