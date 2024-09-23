package ar.com.mercadolibre.ejercicioStarWars.repository;

import ar.com.mercadolibre.ejercicioStarWars.entity.dto.PersonajeDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class StarWarsRepository{
    private String jsonData;

    public StarWarsRepository() {
        loadJSON();
    }

    private void loadJSON() {
        try {
            ClassPathResource resource = new ClassPathResource("starWarsData.json");
            byte[] jsonDataBytes = Files.readAllBytes(Paths.get(resource.getURI()));
            jsonData = new String(jsonDataBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getJSONData() {
        return jsonData;
    }
}
