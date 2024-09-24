package com.example.starwars.repository.impl;

import com.example.starwars.entity.Personaje;
import com.example.starwars.repository.IPersonajeRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

@Repository
public class PersonajeRepository  implements IPersonajeRepository {
   private final List<Personaje> personajes;

    public PersonajeRepository() {
        try {
            this.personajes = readJson();

        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public List<Personaje> getPersonajes() {
        return personajes;
    }
    private List<Personaje> readJson() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String json = new String(Files.readAllBytes(Paths.get("./src/main/resources/static/personajes.json")));
        List<Map<String,Object>> personajes = mapper.readValue(json, new TypeReference<>() {});
        return personajes.stream().map(p-> new Personaje(
                p.get("name") == null ? null : p.get("name").toString(),
                p.get("height") == null ? null : parseInteger(p.get("height").toString()),
                p.get("mass") == null ? null : parseInteger(p.get("mass").toString()),
                p.get("hair_color") == null ? null : p.get("hair_color").toString(),
                p.get("skin_color") == null ? null : p.get("skin_color").toString(),
                p.get("eye_color") == null ? null : p.get("eye_color").toString(),
                p.get("birth_year") == null ? null : p.get("birth_year").toString(),
                p.get("gender") == null ? null : p.get("gender").toString(),
                p.get("homeworld") == null ? null : p.get("homeworld").toString(),
                p.get("species") == null ? null : p.get("species").toString()
        )).toList();
    }
    private Integer parseInteger(String obj) {
        try {
            return Integer.valueOf(obj);
        } catch (Exception ex) {
            return null;
        }
    }
}

