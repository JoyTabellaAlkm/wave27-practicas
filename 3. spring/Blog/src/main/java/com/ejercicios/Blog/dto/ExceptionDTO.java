package com.ejercicios.Blog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class ExceptionDTO {
    private String message;
    private int code;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public ExceptionDTO(String message, int code) {
        this.message = message;
        this.code = code;
    }
}
