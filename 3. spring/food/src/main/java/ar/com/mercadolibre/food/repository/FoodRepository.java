package ar.com.mercadolibre.food.repository;

import ar.com.mercadolibre.food.model.Food;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Objects;

@Repository
@Getter
public class FoodRepository {

    private final List<Food> foodList;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public FoodRepository(List<Food> foodList) {
        this.foodList = loadFile();
    }

    public List<Food> loadFile(){
        try{
            return objectMapper.readValue(
                    new File("src/main/resources/food.json"),
                    new TypeReference<List<Food>>() {
                    });

        } catch (Exception e){
            System.out.println("Error en la carga");
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Food getFood(String name){
        return this.foodList.stream()
                .filter(food -> food.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}
