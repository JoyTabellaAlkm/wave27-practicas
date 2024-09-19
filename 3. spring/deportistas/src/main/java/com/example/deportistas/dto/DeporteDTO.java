package com.example.deportistas.dto;

import com.example.deportistas.entity.Nivel;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DeporteDTO {
    private String nombre;
    private Nivel nivel;
}
