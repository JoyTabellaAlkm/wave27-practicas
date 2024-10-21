package com.mercadolibre.qatester.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class ResponseDTO {
    private String message;
    private HttpStatus status;
}
