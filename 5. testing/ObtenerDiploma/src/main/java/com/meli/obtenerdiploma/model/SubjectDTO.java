package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Getter @Setter
public class SubjectDTO {
    @NotNull(message = "El nombre de la materia no puede estar vacio")
    String name;
    @Min(value = 1, message = "La nota no puede ser menor a 1")
    @Max(value = 10,message ="La nota no puede ser mayor a 10")
    Double score;
}
