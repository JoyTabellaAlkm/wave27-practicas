package ar.com.mercadolibre.calculadoracalorias.service.impl;

import ar.com.mercadolibre.calculadoracalorias.dto.PlateDTO;
import ar.com.mercadolibre.calculadoracalorias.entity.Ingredient;
import ar.com.mercadolibre.calculadoracalorias.entity.Plate;
import ar.com.mercadolibre.calculadoracalorias.exception.EmptyIngredientsException;
import ar.com.mercadolibre.calculadoracalorias.exception.PlateNotFoundException;
import ar.com.mercadolibre.calculadoracalorias.repository.IngredientsRepository;
import ar.com.mercadolibre.calculadoracalorias.repository.MenuRepository;
import ar.com.mercadolibre.calculadoracalorias.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class MenuServiceImpl implements IMenuService {
    @Autowired
    MenuRepository menuRepository;

    @Autowired
    IngredientsRepository ingredientsRepository;

    @Override
    public List<Plate> findMenu() {
        menuRepository.createPlates();

        return menuRepository.findAll();
    }

    @Override
    public PlateDTO findPlate(String name, Integer weigth) {
        menuRepository.initializeMenu();

        if (!menuRepository.plateExist(name)) {
            throw new PlateNotFoundException("No hay un plato con este nombre");
        }

        Plate plate = menuRepository.findByName(name);
        List<Ingredient> ingredients = plate.getIngredients();

        if (ingredients == null) {
            throw new EmptyIngredientsException("El plato no tiene ingredientes");
        }

        Ingredient biggestIngr = ingredients.stream()
                .max(Comparator.comparing(Ingredient::getCalories))
                .orElse(null);

        return new PlateDTO(calculateCalories(weigth, plate), ingredients, biggestIngr);
    }

    private Integer calculateCalories(Integer userWeigth, Plate plate) {
        return (Integer) plate.getCalories() * userWeigth / plate.getWeight();
    }
}
