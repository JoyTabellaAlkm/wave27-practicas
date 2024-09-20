package ar.com.platos.contadorCalorias.repository;

import ar.com.platos.contadorCalorias.entity.Ingrediente;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CalculadoraDeCalRepository {
    @Autowired
    public final ObjectMapper JSON_MAPPER = new ObjectMapper();

    private ArrayList<Ingrediente> ingredientes = new ArrayList<>();

    public List<Ingrediente> leerArchivo() {
        try {
            File file = new File("src/main/resources/food.json");
            ingredientes = JSON_MAPPER.readValue(file,JSON_MAPPER.getTypeFactory().constructCollectionType(ArrayList.class, Ingrediente.class));
        }catch (Exception e) {
            e.printStackTrace();
        }
        return ingredientes;
    }
}
