package com.example.joyeria.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class JoyaCreateDto {
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
