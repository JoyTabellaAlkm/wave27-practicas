package com.meli.obtenerdiploma.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;

@Getter
@Setter
public class StudentDTO {
    @NotNull(message = "Name cannot be null")
    @NotBlank(message = "Name cannot be empty")
    @JsonProperty("student_name")
    String studentName;

    @NotNull(message = "Name cannot be null")
    @NotBlank(message = "Name cannot be empty")
    String message;

    @NotNull(message = "Average score cannot be null")
    @PositiveOrZero(message = "Average score cannot be negative")
    Double averageScore;

    @Valid
    List<SubjectDTO> subjects;
}
