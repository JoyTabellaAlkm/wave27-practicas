package com.bootcamp.qatesters.dto;

import lombok.Data;

@Data
public class CreateTestCaseDto {
    private String description;
    private Boolean tested;
    private Boolean passed;
}
