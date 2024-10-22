package ar.com.mercadolibre.empresaseguros.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehiculoSiniestroDTO {
    private String patente;
    private String marca;
    private String modelo;
    private Double perdidaTotal;
}
