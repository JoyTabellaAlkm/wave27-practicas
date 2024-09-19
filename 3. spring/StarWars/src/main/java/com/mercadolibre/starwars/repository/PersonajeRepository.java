package com.mercadolibre.starwars.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.starwars.entity.Personaje;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.List;

@Repository
@Getter
public class PersonajeRepository {
    private final List<Personaje> personajes;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public PersonajeRepository(List<Personaje> personajes){
        this.personajes = loadFile();
    }

    public List<Personaje> loadFile() {
        try{
            return objectMapper.readValue(
                    new File("src/main/resources/starwars.json"),
                    new TypeReference<List<Personaje>>() {
                    }
            );
        }catch (Exception e) {
            System.out.println("Error en la carga");
            System.out.println(e.getMessage());
            return null;
        }
    }
}
