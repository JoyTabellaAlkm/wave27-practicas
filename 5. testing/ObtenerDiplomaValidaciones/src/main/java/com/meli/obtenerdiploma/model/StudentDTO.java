package com.meli.obtenerdiploma.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

@Getter
@Setter
@JsonPropertyOrder({"student_name", "message", "average_score", "subjects"})
public class StudentDTO {
    @NotBlank(message = "El nombre no puede estar vacío.")
    @Size(min = 2, max = 15, message = "El nombre debe tener entre 2 y 15 caracteres")
    @Pattern(regexp = "^[A-Za-záéíóúÁÉÍÓÚÑñ ]+$", message = "El nombre solo puede contener letras y espacios.")
    @JsonProperty("student_name")
    String studentName;

    String message;

    @JsonProperty("average_score")
    Double averageScore;

    @NotNull(message = "La lista de materias no puede esta vacía..")
    List<@Valid SubjectDTO> subjects;
}
