package org.mercadolibre.calculadora_calorias.service.impl;

import org.mercadolibre.calculadora_calorias.dto.IngredienteDTO;
import org.mercadolibre.calculadora_calorias.dto.PlatoRequestDTO;
import org.mercadolibre.calculadora_calorias.dto.PlatoResponseDTO;
import org.mercadolibre.calculadora_calorias.entity.Plato;
import org.mercadolibre.calculadora_calorias.repository.PlatoRepository;
import org.mercadolibre.calculadora_calorias.service.IPlatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class PlatoService implements IPlatoService {
    @Autowired
    PlatoRepository platoRepository;

    @Override
    public List<PlatoResponseDTO> getAll() {
        List<PlatoResponseDTO> platoResponseDTOS = new ArrayList<>();

        for (Plato p : platoRepository.getPlatos()) {
            PlatoResponseDTO platoResponseDTO = new PlatoResponseDTO();
            platoResponseDTO.setName(p.getName());
            platoResponseDTO.setWeight(100.0);
            platoResponseDTO.setIngredienteList(p.getIngredienteList().stream().map(i -> new IngredienteDTO(i.getName(), i.getCalories())).toList());
            platoResponseDTO.setCaloriesTotal(calcularCalorias(platoResponseDTO.getIngredienteList(), Optional.empty()));
            platoResponseDTO.setIngredienteMasCalorias(ingredienteMasCalorias(platoResponseDTO.getIngredienteList()));
            platoResponseDTOS.add(platoResponseDTO);
        }

        return platoResponseDTOS;
    }

    public double calcularCalorias(List<IngredienteDTO> ingredienteDTOS, Optional<Double> weight) {
        double weightValue = weight.orElse(100.0);

        return (ingredienteDTOS.stream().mapToDouble(IngredienteDTO::getCalories).sum() * weightValue) / 100;
    }

    public IngredienteDTO ingredienteMasCalorias(List<IngredienteDTO> ingredienteDTOS) {
        return ingredienteDTOS.stream().max(Comparator.comparing(i -> i.getCalories())).orElse(new IngredienteDTO("nada", 123));
    }

    public PlatoResponseDTO getByName(PlatoRequestDTO platoRequestDTO) {
        List<PlatoResponseDTO> platos = getAll();
        PlatoResponseDTO platoResponseDTO = platos.stream().filter(p -> p.getName().equals(platoRequestDTO.getName())).findFirst().orElseThrow(() -> new RuntimeException("No se encuentra ese plato"));

        platoResponseDTO.setWeight(platoRequestDTO.getWeight());
        double caloriesValue = (platoRequestDTO.getWeight() * platoResponseDTO.getCaloriesTotal()) / 100;
        platoResponseDTO.setCaloriesTotal(caloriesValue);
        return platoResponseDTO;
    }

}
