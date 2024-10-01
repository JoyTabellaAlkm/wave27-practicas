package com.sprint1.be_java_hisp_w27_g04.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExceptionDTO {
    private String message;
    private String code;
}
