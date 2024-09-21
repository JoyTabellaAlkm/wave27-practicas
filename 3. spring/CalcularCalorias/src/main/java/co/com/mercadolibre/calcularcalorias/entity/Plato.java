package co.com.mercadolibre.calcularcalorias.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data @AllArgsConstructor @NoArgsConstructor
public class Plato {
    private Long id;
    private String nombre;
    private Integer peso;
    private List<Ingrediente> ingredientes;
}
