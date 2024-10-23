package co.mercadolibre.seguros_autos.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PatenteMarcaDTO {
    private String patente;
    private String marca;
}
