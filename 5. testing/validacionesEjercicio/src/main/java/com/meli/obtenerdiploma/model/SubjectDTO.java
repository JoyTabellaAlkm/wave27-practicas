package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Getter @Setter
public class SubjectDTO {
    @NotNull(message = "El nombre de la asignatura obligatorio")
    @NotEmpty(message = "El nombre de la asignatura no puede estar vacio")
    String name;
    @NotNull(message = "La puntuacion es obligatoria")
    @PositiveOrZero (message = "La puntuacion debe ser igual o mayor a 0.0")
    Double score;
}
