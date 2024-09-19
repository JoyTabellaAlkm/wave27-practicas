package ar.com.stardwards.stardward.repository;

import ar.com.stardwards.stardward.entity.Personaje;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StarwarsRepository {

    @Autowired
    public final ObjectMapper JSON_MAPPER = new ObjectMapper();

    private ArrayList<Personaje> personajes = new ArrayList<>();

    public List<Personaje> leerArchivo() {
        try {
            File file = new File("src/main/resources/starwars.json");
             personajes = JSON_MAPPER.readValue(file,JSON_MAPPER.getTypeFactory().constructCollectionType(ArrayList.class, Personaje.class));
        }catch (Exception e) {
            e.printStackTrace();
        }
        return personajes;
    }
}