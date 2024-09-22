package ar.com.mercadolibre.calculadoracalorias.repository;

import ar.com.mercadolibre.calculadoracalorias.entity.Ingredient;
import ar.com.mercadolibre.calculadoracalorias.entity.Plate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MenuRepository {

    @Autowired
    IngredientsRepository ingredientsRepository;
    private List<Plate> menu = new ArrayList<>();

    public void initializeMenu() {
        createPlates();
    }

    public void createPlates() {
        List<Ingredient> allIngredients = ingredientsRepository.findAll();

        for (int i = 1; i <= 10; i++) {
            List<Ingredient> ingredientsForPlate = allIngredients.subList(i-1, i+2);
            Plate plate = new Plate("Plate" + i, ingredientsForPlate);
            menu.add(plate);
        }
    }

    public List<Plate> findAll() {
        return menu;
    }

    public Plate findByName(String name) {
        return menu.stream()
                .filter(plate -> plate.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public boolean plateExist(String name) {
        return menu.stream()
                .anyMatch(plate -> plate.getName().equals(name));
    }
}
