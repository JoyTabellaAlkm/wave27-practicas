package org.mercadolibre.calculadoracalorias.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mercadolibre.calculadoracalorias.entity.Ingredients;

import java.io.Serializable;
import java.util.List;
@Data @NoArgsConstructor @AllArgsConstructor
public class DishResponseDTO implements Serializable {
    private String name;
    private List<Ingredients> ingredients;
    private Double totalCalorias;
    private Ingredients ingredienteCalorico;
}
