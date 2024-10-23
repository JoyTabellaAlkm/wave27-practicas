package co.mercadolibre.seguros_autos.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PerdidasTotalesDTO {
    private String patente;
    private String marca;
    private String modelo;
    @JsonProperty("perdida_total")
    private Double perdidaTotal;
}
