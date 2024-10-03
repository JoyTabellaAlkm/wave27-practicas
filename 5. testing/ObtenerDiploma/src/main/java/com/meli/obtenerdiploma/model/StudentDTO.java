package com.meli.obtenerdiploma.model;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class StudentDTO {

    @Size(min = 8, max = 50, message = "Name must be between 8 and 50 characters")
    String studentName;

    @NotBlank
    String message;

    @Min(value = 0, message = "Average score must be greater than 0")
    @Max(value = 10, message = "Average score must be less than 10")
    Double averageScore;

    @NotEmpty
    List<SubjectDTO> subjects;
}
