package com.mercadolibre.joyeria.dtos;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
public class JoyaDTO {
    private Integer id;
    private String nombre;
    private String material ;
    private Double peso;
    private String particularidad;
    @Column(name = "posee_piedra")
    private boolean poseePiedra;
    @Column(name = "venta_o_no")
    private boolean ventaONo;
}
