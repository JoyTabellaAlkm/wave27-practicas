package com.meli.obtenerdiploma.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

@Getter
@Setter
public class StudentDTO {
    @Size(min = 3, max = 10, message = "La longitud del nombre del estudiante debe estar entre 3 y 10 caracteres")
    @NotEmpty(message = "Debe agregar el nombre")
    @JsonProperty("student_name")
    String studentName;

    @Size(min = 8, max = 20, message = "La longitud del mensaje debe estar entre 8 y 20 caracteres")
    @NotEmpty(message = "Debe agregar un mensaje")
    String message;

    @DecimalMin(value = "1.0", message = "El promedio no puede ser menor a 1.0")
    @DecimalMax(value = "10.0", message = "El promedio no puede ser mayor a 10.0")
    @NotNull(message = "Debe agregar un promedio")
    @JsonProperty("average_score")
    Double averageScore;

    @NotEmpty(message = "La lista de asignaciones no puede estar vacía")
    List<@Valid SubjectDTO> subjects;
}
