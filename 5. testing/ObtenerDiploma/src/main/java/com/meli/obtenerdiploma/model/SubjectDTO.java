package com.meli.obtenerdiploma.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SubjectDTO {

    @Size(min = 8, max = 50, message = "Name must be between 8 and 50 characters")
    String name;

    @Min(value = 0, message = "Score must be greater than 0")
    @Max(value = 10, message = "Score must be less than 10")
    Double score;
}
