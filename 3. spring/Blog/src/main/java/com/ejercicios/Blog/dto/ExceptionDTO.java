package com.ejercicios.Blog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExceptionDTO {
    private String message;
    private int code;
}
