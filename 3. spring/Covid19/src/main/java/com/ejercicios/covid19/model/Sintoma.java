package com.ejercicios.covid19.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Sintoma {
    private Long codigo;
            private String nombre;
   private String nivelDeGravedad;


}
