package co.mercadolibre.seguros_autos.dto.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PatenteMarcaModeloDTO {
    private String patente;
    private String marca;
    private String modelo;
}
