package com.edad.Clase13_Edad.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class FechaInvalidaDTO{
    private String mensajeError;
    private LocalDate fechaInvalida;
}
