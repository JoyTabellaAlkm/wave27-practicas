package com.edad.Clase14_Deportistas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeportistaDto {
    private String nombre;
    private String apellido;
    private String nombreDeporte;
}
