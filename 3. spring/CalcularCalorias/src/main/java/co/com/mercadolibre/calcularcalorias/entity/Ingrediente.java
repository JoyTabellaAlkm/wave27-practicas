package co.com.mercadolibre.calcularcalorias.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class Ingrediente {
    private Long id;
    private String name;
    private Integer calories;
}
