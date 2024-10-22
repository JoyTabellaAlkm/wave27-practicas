package ar.com.mercadolibre.empresaseguros.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatenteAndMarcaAndModeloDTO {

    private String patente;
    private String marca;
    private String modelo;
}
