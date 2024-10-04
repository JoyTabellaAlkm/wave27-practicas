package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter @Setter
public class SubjectDTO {
    @NotEmpty(message = "Debe agregar el nombre de la asignatura")
    String name;

    @DecimalMin(value = "1.0", message = "La nota no puede ser menor a 1.0")
    @DecimalMax(value = "10.0", message = "La nota no puede ser mayor a 10.0")
    @NotNull(message = "Debe agregar una nota")
    Double score;
}
