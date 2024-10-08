package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter @Setter
public class SubjectDTO {
    @NotNull(message = "El nombre de la materia no puede ser nulo")
    String name;
    @NotNull(message = "El nombre de la materia no puede ser nulo")
    Double score;
}
