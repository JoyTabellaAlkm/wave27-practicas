package co.mercadolibre.calorias.repository;

import co.mercadolibre.calorias.entity.Food;
import co.mercadolibre.calorias.entity.Preparation;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class FoodRepository {
    List<Food> foodList;
    List<Preparation> preparationList;

    public FoodRepository() {
        foodList = new ArrayList<>();
        foodList = fillFood();

        Food huevos = foodList.stream().filter(f->f.getName().equals("Huevo entero")).findFirst().orElse(null);
        Food cebolla = foodList.stream().filter(f->f.getName().equals("Cebolla")).findFirst().orElse(null);
        Food tomate = foodList.stream().filter(f->f.getName().equals("Tomates")).findFirst().orElse(null);

        preparationList = new ArrayList<>();
        Preparation huevosPericos = new Preparation("Huevos pericos", Arrays.asList(huevos, cebolla, tomate));
        preparationList.add(huevosPericos);
        System.out.println(huevosPericos);
    }

    public List<Preparation> getPreparations(){
        return preparationList;
    }

    public List<Food> fillFood(){

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            return objectMapper.readValue(
                    new File("src/main/resources/food.json"),
                    new TypeReference<List<Food>>() {
                    }
            );
        }catch (Exception e){
            System.out.println("Error en la carga");
            System.out.println(e.getMessage());
            return null;
        }
    }

}
