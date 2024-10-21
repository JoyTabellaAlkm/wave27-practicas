package ar.com.mercadolibre.clavescompuestas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDTO {
    private Long id;
    private String nombre;
    private Integer cantidad;
    private Double precio;
}
