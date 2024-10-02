package com.meli.clase16calorias.dto;

import com.meli.clase16calorias.model.Ingrediente;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PlatoEstandarDTO {

    private String nombre;
    private List<Ingrediente> ingredientes;
}
