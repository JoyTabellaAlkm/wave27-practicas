package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Getter @Setter
public class SubjectDTO {
    @NotNull(message = "Name cannot be null")
    @NotBlank(message = "Name cannot be empty")
    String name;
    @NotNull(message = "Score cannot be null")
    @PositiveOrZero(message = "Score cannot be negative")
    Double score;
}
