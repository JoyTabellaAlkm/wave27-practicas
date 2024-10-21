package com.mercadoLibre.QATesters.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;

@Data
public class TestCaseResponseDTO {
    private Long idCase;
    private String description;
    private Boolean tested;
    private Boolean passed;
    @JsonProperty(value = "number_of_tries")
    private int numberOfTries;
    @JsonProperty(value = "last_update")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate lastUpdate;
}
