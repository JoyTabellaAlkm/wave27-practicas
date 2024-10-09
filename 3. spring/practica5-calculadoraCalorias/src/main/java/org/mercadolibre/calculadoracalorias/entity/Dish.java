package org.mercadolibre.calculadoracalorias.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Dish implements Serializable {
    private static final Long serialVersionUID = 1L;
    private String name;
    private double weight;
    private List<Ingredients> ingredients;
}
