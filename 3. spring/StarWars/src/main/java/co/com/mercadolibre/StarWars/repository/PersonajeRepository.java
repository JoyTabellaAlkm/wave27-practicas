package co.com.mercadolibre.StarWars.repository;

import co.com.mercadolibre.StarWars.entity.Personaje;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonajeRepository {
    List<Personaje> listaPersonas;
    ObjectMapper objectMapper = new ObjectMapper();

    public PersonajeRepository() {
        this.listaPersonas = new ArrayList<>();
        fillPersonaje();
    }

    public List<Personaje> fillPersonaje() {

        String path = getClass().getClassLoader().getResource("starwars.json").getPath();
        File file = new File(path);

        try {
            return objectMapper.readValue(file, new TypeReference<List<Personaje>>(){ });

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Personaje getPersonaje(String name){
        return null;
    }
}
