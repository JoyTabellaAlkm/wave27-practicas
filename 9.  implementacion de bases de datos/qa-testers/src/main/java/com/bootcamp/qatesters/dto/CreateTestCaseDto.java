package com.bootcamp.qatesters.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateTestCaseDto {
    private String description;
    private Boolean tested;
    private Boolean passed;
}
