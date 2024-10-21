package com.mercadoLibre.QATesters.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class ResponseDTO {
    private HttpStatus status;
    private String message;
}
