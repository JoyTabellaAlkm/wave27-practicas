package org.mercadolibre.calculadora_calorias.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Data
public class PlatoResponseDTO {
    private String name;
    private Double caloriesTotal;
    private Double weight;
    private List<IngredienteDTO> ingredienteList;
    private IngredienteDTO ingredienteMasCalorias;
}
