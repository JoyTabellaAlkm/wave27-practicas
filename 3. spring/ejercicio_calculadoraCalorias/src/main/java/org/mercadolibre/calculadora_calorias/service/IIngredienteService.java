package org.mercadolibre.calculadora_calorias.service;

import org.mercadolibre.calculadora_calorias.dto.IngredienteDTO;

import java.util.List;

public interface IIngredienteService{

    List<IngredienteDTO> getAll();
    IngredienteDTO getByName(String name);
}
