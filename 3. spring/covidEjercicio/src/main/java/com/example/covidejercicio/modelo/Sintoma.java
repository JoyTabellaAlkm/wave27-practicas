package com.example.covidejercicio.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Sintoma {
    private  String codigo;
    private  String nombre;
    private  String nivel_de_gravedad;
}
