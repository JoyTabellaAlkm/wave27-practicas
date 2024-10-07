package ar.com.mercadolibre.calorias.repository.impl;

import ar.com.mercadolibre.calorias.entity.Ingredient;
import ar.com.mercadolibre.calorias.repository.IngredientRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class IngredientRepositoryImpl implements IngredientRepository {
    private List<Ingredient> ingredients;

    public IngredientRepositoryImpl() {
        try {
            this.ingredients = readJsonFile();
        } catch (Exception ex) {
            throw new RuntimeException("Error al leer y parsear el archivo JSON.\n" + ex.getMessage());
        }
    }

    private List<Ingredient> readJsonFile() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        String json = new String(Files.readAllBytes(Paths.get("./src/main/resources/static/food.json")));
        List<Map<String, Object>> parsedJson = objectMapper.readValue(json, List.class);
        return parsedJson.stream().map(pje -> new Ingredient(
                pje.get("name") == null ? null : pje.get("name").toString(),
                pje.get("calories") == null ? null : parseInteger(pje.get("calories").toString())
        )).toList();
    }

    private Integer parseInteger(String obj) {
        try {
            return Integer.valueOf(obj);
        } catch (Exception ex) {
            return null;
        }
    }

    public Optional<Ingredient> getByName(String name) {
        return ingredients.stream()
                .filter(ing -> ing.getName().equals(name))
                .findFirst();
    }
}
