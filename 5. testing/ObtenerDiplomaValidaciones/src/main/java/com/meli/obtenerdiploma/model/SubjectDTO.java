package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter @Setter
public class SubjectDTO {
    @NotBlank(message = "El nombre de la materia no puede estar vacío.")
    @Size(min = 2, max = 50, message = "El nombre de la materia debe tener entre 2 y 50 caracteres.")
    @Pattern(regexp = "^[A-Za-z0-9áéíóúÁÉÍÓÚÑñ' -]+$", message = "El nombre de la materia solo puede contener letras, números, espacios, guiones y apóstrofes.")
    String name;

    @NotNull(message = "El promedio de notas no puede estar vacío.")
    @DecimalMin(value = "0.0", message = "El promedio no puede ser un numero negativo.")
    @DecimalMax(value = "10.0", message = "El promedio no puede ser mayor a 10.0")
    Double score;
}
