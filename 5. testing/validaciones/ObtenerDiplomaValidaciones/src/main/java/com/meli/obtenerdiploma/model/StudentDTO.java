package com.meli.obtenerdiploma.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter @Setter
public class StudentDTO {
    @JsonProperty("student_name")
    @NotNull(message = "El nombre del estudiante no puede ser nulo")
    @NotEmpty(message = "El nombre del estudiante no puede estar vacío")
    String studentName;
    @NotNull(message = "El mensaje no puede ser nulo")
    @NotEmpty(message = "El mensaje no puede estar vacío")
    String message;
    @JsonProperty("average_score")
    @Min(value = 0,message = "El promedio no puede ser menor a 0.0")
    @NotNull(message = "El promedio no puede ser nulo")
    Double averageScore;
    @NotEmpty(message = "La lista de materias no puede estar vacía")
    List<SubjectDTO> subjects;
}
