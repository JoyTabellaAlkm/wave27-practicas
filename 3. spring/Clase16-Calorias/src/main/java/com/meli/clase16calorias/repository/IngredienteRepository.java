package com.meli.clase16calorias.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.clase16calorias.model.Ingrediente;
import com.meli.clase16calorias.model.Plato;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Repository
@Getter
public class IngredienteRepository {

    private List<Ingrediente> ingredientes;
    private List<Plato> menu;
    private ObjectMapper objectMapper = new ObjectMapper();

    public IngredienteRepository(List<Ingrediente> ingredientes) {

        this.ingredientes = loadFile();
        menu = generarMenu();
    }

    private List<Ingrediente> loadFile() {
        try {
            return objectMapper.readValue(new File("src/main/resources/food.json"), new TypeReference<List<Ingrediente>>() {});
        } catch (Exception e) {
            System.out.println("Error en la carga");
            System.out.println(e.getMessage());
            return null;
        }
    }
    private List<Plato> generarMenu(){
        List<Plato> menu = new ArrayList<>();

        for (int i = 0; i < ((int)ingredientes.size()/4-1); i++) {
            Plato plato = new Plato("plato"+i, ingredientes.subList(i*4, (i+1)*4) );
            menu.add(plato);
        }
        return menu;
    }
}
