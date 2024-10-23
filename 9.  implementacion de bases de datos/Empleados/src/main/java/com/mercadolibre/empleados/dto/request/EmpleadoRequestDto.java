package com.mercadolibre.empleados.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class EmpleadoRequestDto {
    private String nombre;
    private String apellido;
    private Integer edad;
    private String ciudad;
    private String departamento;
}
