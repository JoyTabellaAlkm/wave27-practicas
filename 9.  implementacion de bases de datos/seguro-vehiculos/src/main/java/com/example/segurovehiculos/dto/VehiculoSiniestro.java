package com.example.segurovehiculos.dto;

import com.example.segurovehiculos.entity.Vehiculo;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class VehiculoSiniestro {
    private Vehiculo vehiculo;
    private Integer sumaPerdida;
}
