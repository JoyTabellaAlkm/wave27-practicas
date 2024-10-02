package com.meli.ejconcesionariaautos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class ResponseDto {
    private String message;
    private HttpStatus status;
}
