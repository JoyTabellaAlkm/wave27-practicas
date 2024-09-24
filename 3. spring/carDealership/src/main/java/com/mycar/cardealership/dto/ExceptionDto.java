package com.mycar.cardealership.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public class ExceptionDto {
    private String message;
    private HttpStatus status;
}
