package com.example.qatesters.dto.responseDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
public class TestCaseResponseDto {
    @JsonProperty("id_case")
    Long idCase;
    String description;
    Boolean tested;
    Boolean passed;
    @JsonProperty("number_of_tries")
    int numberOfTries;
    @JsonProperty("last_update")
    LocalDate lastUpdate;
}
