package ar.com.mercadolibre.starwars.repository;

import ar.com.mercadolibre.starwars.entity.Personaje;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

@Repository
public class PersonajesRepositoryImpl implements PersonajesRepository {
    private List<Personaje> personajes;

    public PersonajesRepositoryImpl() {
        try {
            this.personajes = readJsonFile();
        } catch (IOException ex) {
            throw new RuntimeException("Error al leer y parsear el archivo JSON.\n" + ex.getMessage());
        }
    }

    public List<Personaje> findAll() {
        return personajes;
    }

    public List<Personaje> findAllByNameContains(String query) { // no usages, created for testing purposes
        return personajes.stream()
                .filter(pje -> matchWith(query, pje))
                .toList();
    }

    private boolean matchWith(String query, Personaje personaje) {
        return personaje.getName().toUpperCase().contains(query.toUpperCase());
    }

    private List<Personaje> readJsonFile() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        String json = new String(Files.readAllBytes(Paths.get("./src/main/resources/static/personajes.json")));
        List<Map<String, Object>> parsedJson = objectMapper.readValue(json, List.class);
        return parsedJson.stream().map(pje -> new Personaje(
                pje.get("name") == null ? null : pje.get("name").toString(),
                pje.get("height") == null ? null : parseInteger(pje.get("height").toString()),
                pje.get("mass") == null ? null : parseInteger(pje.get("mass").toString()),
                pje.get("hair_color") == null ? null : pje.get("hair_color").toString(),
                pje.get("skin_color") == null ? null : pje.get("skin_color").toString(),
                pje.get("eye_color") == null ? null : pje.get("eye_color").toString(),
                pje.get("birth_year") == null ? null : pje.get("birth_year").toString(),
                pje.get("gender") == null ? null : pje.get("gender").toString(),
                pje.get("homeworld") == null ? null : pje.get("homeworld").toString(),
                pje.get("species") == null ? null : pje.get("species").toString()
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
