package co.com.mercadolibre.calcularcalorias.repository.impl;

import co.com.mercadolibre.calcularcalorias.entity.Ingrediente;
import co.com.mercadolibre.calcularcalorias.exception.UnableToLoadFileException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
@Repository @Getter
public class IngredienteRepositoryImpl {
    private  List<Ingrediente> listaIngredientes = new ArrayList<>();
    private final ObjectMapper objectMapper = new ObjectMapper();
    private Long id = 1L;
    public IngredienteRepositoryImpl() {
        listaIngredientes = loadFile();
    }

    public List<Ingrediente> loadFile(){
        try{
            List<Ingrediente> listaIngredientesCargados = objectMapper.readValue(
                    new File("src/main/resources/1. c. food.json"),
                    new TypeReference<List<Ingrediente>>() {
                    });

            for(Ingrediente ingrediente : listaIngredientesCargados){
                ingrediente.setId(id++);
            }
                    return listaIngredientesCargados;
        }catch (Exception e){
            throw new UnableToLoadFileException("No se pudo leer los datos del JSON.");
        }
    }

}
