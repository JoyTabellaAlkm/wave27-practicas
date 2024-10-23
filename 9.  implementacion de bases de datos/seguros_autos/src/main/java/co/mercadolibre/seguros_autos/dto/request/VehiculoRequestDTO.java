package co.mercadolibre.seguros_autos.dto.request;

import co.mercadolibre.seguros_autos.entity.Siniestro;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VehiculoRequestDTO {

    private String patente;
    private String marca;
    private String modelo;
    @JsonProperty("anio_fabricacion")
    private Integer anioFabricacion;
    @JsonProperty("cantidad_ruedas")
    private Integer cantidadRuedas;


}
