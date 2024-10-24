package com.meli.obrasliterarias.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Data
public class ResponseDto {
    private String message;
    private HttpStatus status;
}
