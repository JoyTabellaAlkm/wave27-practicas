package ar.com.mercadolibre.showroomelastic.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PrendaDTO {

    private Long codigo;

    private String nombre;

    private String tipo;

    private String marca;

    private String color;

    private String talle;

    private Integer cantidad;

    @JsonIgnoreProperties("precio_venta")
    private Double precioVenta;

    @JsonIgnoreProperties("venta_id")
    private Long ventaId;
}
