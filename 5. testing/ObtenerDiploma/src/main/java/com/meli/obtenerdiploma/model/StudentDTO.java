package com.meli.obtenerdiploma.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter @Setter
public class StudentDTO {
    @NotNull(message = "El nombre no puede estar vacío!")
    String studentName;
    String message;
    Double averageScore;
    List<SubjectDTO> subjects;
}
