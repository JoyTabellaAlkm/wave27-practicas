package co.com.mercadolibre.calorias.repository.impl;

import co.com.mercadolibre.calorias.entity.Ingrediente;
import co.com.mercadolibre.calorias.entity.Plato;
import co.com.mercadolibre.calorias.repository.ICaloriasRespository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Repository
public class CaloriasRepository implements ICaloriasRespository {
    private List<Plato> platos;
    private List<Ingrediente> listaIngredientes;
    private ObjectMapper objectMapper = new ObjectMapper();

    public CaloriasRepository() {
        listaIngredientes = new ArrayList<>();
        listaIngredientes = fillIngrediente();
        platos = List.of(
                new Plato("pasta", List.of(listaIngredientes.get(1),listaIngredientes.get(5)),500));
    }

    public List<Ingrediente> fillIngrediente() {
        try {
            return objectMapper.readValue(new File("src/main/resources/food.json"), new TypeReference<List<Ingrediente>>(){ });
        } catch (IOException e) {
            System.out.println("Error en la carga");
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Plato> obtenerPlatos(){
        return platos;
    }


}
