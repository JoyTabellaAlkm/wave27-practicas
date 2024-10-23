package com.mercadolibre.joyeria.dtos.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestJoyaDTO {

    private String nombre;
    private String material ;
    private Double peso;
    private String particularidad;
    @JsonProperty("posee_piedra")
    private boolean poseePiedra;
    @JsonProperty("venta_o_no")
    private boolean ventaONo;
}
