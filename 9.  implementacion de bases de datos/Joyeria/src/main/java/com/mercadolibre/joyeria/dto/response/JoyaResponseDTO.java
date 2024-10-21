package com.mercadolibre.joyeria.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class JoyaResponseDTO {
    Long nroIdentificatorio;
    String nombre;
    String material;
    Integer peso;
    String particularidad;
    @JsonProperty("posee_piedra")
    Boolean poseePiedra;
    @JsonProperty("venta_o_no")
    Boolean ventaONo;
}
