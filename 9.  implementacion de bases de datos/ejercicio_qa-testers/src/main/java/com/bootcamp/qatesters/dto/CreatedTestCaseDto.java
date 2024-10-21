package com.bootcamp.qatesters.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreatedTestCaseDto {
    @JsonProperty("id_case")
    private Long id;
}
