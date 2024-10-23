package co.mercadolibre.seguros_autos.dto.request;

import co.mercadolibre.seguros_autos.entity.Vehiculo;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SiniestroRequestDTO {
    @JsonProperty("fecha_siniestro")
    private LocalDate fechaSiniestro;
    @JsonProperty("perdida_economica")
    private Double perdidaEconomica;
    @JsonProperty("vehiculo_id")
    private Long vehiculoId;
}
