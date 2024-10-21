package com.mercadolibre.qatester.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionDTO {
    private String message;
    private HttpStatus status;
}
