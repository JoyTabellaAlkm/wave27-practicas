package com.meli.clase18linktracker.dto;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
public class ExceptionDTO {
    private HttpStatus status;
    private String message;
}
