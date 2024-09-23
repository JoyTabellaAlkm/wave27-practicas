package co.mercadolibre.calorias.service.impl;

import co.mercadolibre.calorias.dto.ConsultDTO;
import co.mercadolibre.calorias.entity.Food;
import co.mercadolibre.calorias.entity.Preparation;
import co.mercadolibre.calorias.repository.FoodRepository;
import co.mercadolibre.calorias.service.IFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;

@Service
public class FoodService implements IFoodService {

    @Autowired
    FoodRepository foodRepository;

    @Override
    public ConsultDTO getCaloriesByPreparation(String name) {

        Preparation preparation = foodRepository.getPreparations().stream().filter(p->p.getName().equals(name)).findFirst().orElse(null);
        Food foodSuperCaloric = preparation.getFoodList().stream().max(Comparator.comparing(Food::getCalories)).orElse(null);

        return new ConsultDTO(
                preparation.getName(),
                preparation.getTotalCalories(),
                preparation.getFoodList(),
                foodSuperCaloric
        );
    }
}
