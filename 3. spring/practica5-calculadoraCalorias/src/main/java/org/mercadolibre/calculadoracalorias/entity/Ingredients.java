package org.mercadolibre.calculadoracalorias.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ingredients {
    private String name;
    private int calories;
}
