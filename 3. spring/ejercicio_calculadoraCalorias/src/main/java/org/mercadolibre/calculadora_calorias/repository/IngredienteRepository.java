package org.mercadolibre.calculadora_calorias.repository;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.Getter;
import org.mercadolibre.calculadora_calorias.entity.Ingrediente;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Getter
@Repository
public class IngredienteRepository {

    private final List<Ingrediente> ingredientes;

    public IngredienteRepository() {
        this.ingredientes = loadFile();
    }

    public List<Ingrediente> loadFile() {
        try {
            List<Ingrediente> ingredientesAux;
            File file = new File("src/main/resources/food.json");
            ObjectMapper objectMapper = new ObjectMapper();
            ingredientesAux = objectMapper.readValue(file, new TypeReference<List<Ingrediente>>() {
            });
            return ingredientesAux;

        } catch (Exception e) {
            System.out.println("Hubo un error: " + e.getMessage());
            return new ArrayList<>();
        }
    }


}
