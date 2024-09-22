package org.mercadolibre.calculadora_calorias.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mercadolibre.calculadora_calorias.entity.Ingrediente;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class IngredienteDTO extends Ingrediente {
    private String name;
    private Integer calories;

}
