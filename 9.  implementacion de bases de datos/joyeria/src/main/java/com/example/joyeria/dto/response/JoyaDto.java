package com.example.joyeria.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class JoyaDto {
    @JsonProperty("nro_identificatorio")
    private Long nroIdentificatorio;
    private String nombre;
    private String material;
    private int peso;
    private String particularidad;
    @JsonProperty("posee_piedra")
    private boolean poseePiedra;
    @JsonProperty("venta_o_no")
    private boolean ventaONo;
}
