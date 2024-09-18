package com.mercadolibre.deportista.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Deportista {

    Deporte deporte;
    Persona persona;

}
