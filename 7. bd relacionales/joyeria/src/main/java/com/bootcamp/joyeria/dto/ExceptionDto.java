package com.bootcamp.joyeria.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ExceptionDto {
    @JsonProperty("status_code")
    int statusCode;
    String message;
}
