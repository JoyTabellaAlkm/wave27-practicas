package com.mercadolibre.deportista.dto;

import com.mercadolibre.deportista.model.Deporte;
import com.mercadolibre.deportista.model.Persona;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@AllArgsConstructor
@Data
public class DeportistaDTO implements Serializable {
    private String nombre;
    private String apellido;
    private String nombreDeporte;

    public DeportistaDTO(Deporte deporte, Persona persona) {
    }
}
