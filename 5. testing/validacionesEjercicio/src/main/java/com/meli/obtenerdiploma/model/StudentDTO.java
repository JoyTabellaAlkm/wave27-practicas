package com.meli.obtenerdiploma.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;

@Getter @Setter
public class StudentDTO {
    @NotEmpty(message = "El nombre del estudiante no puede estar vacio")
    String studentName;
    String message;
    @PositiveOrZero(message = "El promedio debe ser mayor o igual a 0.0")
    Double averageScore;
    List<@Valid SubjectDTO> subjects;
}
