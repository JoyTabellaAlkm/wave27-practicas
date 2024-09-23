package co.arg.mercadolibre.starwars.repository;

import co.arg.mercadolibre.starwars.entity.Personaje;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import java.io.File;

@Repository
public class PersonajeRepository{
    List<Personaje> listaPersonajes;

    public PersonajeRepository() {
        this.listaPersonajes = new ArrayList<>();
        this.listaPersonajes = fillPersonaje();
    }

    public List<Personaje> fillPersonaje(){

        ObjectMapper objectMapper = new ObjectMapper();
        String path = getClass().getClassLoader().getResource("starwars.json").getPath();
        File file = new File(path);

        try {
            return objectMapper.readValue(
                    new File("src/main/resources/starwars.json"),
                    new TypeReference<List<Personaje>>() {
                    }
            );
        }catch (Exception e){
            System.out.println("Error en la carga");
            System.out.println(e.getMessage());
            return null;
        }
    }

}
