package ar.com.mercadolibre.calorias.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Ingredient {
    private String name;
    private Integer calories; // por cada 100g
}
