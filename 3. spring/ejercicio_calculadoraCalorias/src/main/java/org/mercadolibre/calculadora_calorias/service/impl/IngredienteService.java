package org.mercadolibre.calculadora_calorias.service.impl;

import org.mercadolibre.calculadora_calorias.dto.IngredienteDTO;
import org.mercadolibre.calculadora_calorias.entity.Ingrediente;
import org.mercadolibre.calculadora_calorias.repository.IngredienteRepository;
import org.mercadolibre.calculadora_calorias.service.IIngredienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IngredienteService implements IIngredienteService {

    @Autowired
    IngredienteRepository ingredienteRepository;

    @Override
    public List<IngredienteDTO> getAll() {
        List<IngredienteDTO> ingredienteDTOS = new ArrayList<>();

        for (Ingrediente i : ingredienteRepository.getIngredientes()) {
            IngredienteDTO ingredienteDTO = new IngredienteDTO();
            ingredienteDTO.setName(i.getName());
            ingredienteDTO.setCalories(i.getCalories());

            ingredienteDTOS.add(ingredienteDTO);
        }

        return ingredienteDTOS;
    }

    public IngredienteDTO getByName(String name)
    {
        List<IngredienteDTO> ingredienteDTOS= getAll();
        if(ingredienteDTOS == null || ingredienteDTOS.isEmpty())
        {
            throw new RuntimeException("No se encontraron ingredientes");
        }

        return ingredienteDTOS.stream().filter(i-> i.getName().equals(name)).findFirst().orElseThrow(()->new RuntimeException("No se encuentran ingredientes con ese nombre"));
    }
}
