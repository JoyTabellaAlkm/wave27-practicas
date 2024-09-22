package org.mercadolibre.calculadora_calorias.service;

import org.mercadolibre.calculadora_calorias.dto.IngredienteDTO;
import org.mercadolibre.calculadora_calorias.dto.PlatoRequestDTO;
import org.mercadolibre.calculadora_calorias.dto.PlatoResponseDTO;

import java.util.List;
import java.util.Optional;

public interface IPlatoService {

    List<PlatoResponseDTO> getAll();
    double calcularCalorias(List<IngredienteDTO> ingredienteDTOS, Optional<Double> weight);
    IngredienteDTO ingredienteMasCalorias(List<IngredienteDTO> ingredienteDTOS);
    PlatoResponseDTO getByName(PlatoRequestDTO platoRequestDTO);
}
