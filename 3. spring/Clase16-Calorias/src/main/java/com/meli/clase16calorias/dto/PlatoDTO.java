package com.meli.clase16calorias.dto;

import com.meli.clase16calorias.model.Ingrediente;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PlatoDTO {
    private String nombre;
    private int peso;
    private double totalCalorias;
    private List<Ingrediente> ingredientes;
    private Ingrediente ingredienteMasCalorias;
}
