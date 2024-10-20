package com.example.joyeriajpa.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ResponseDTO<T> {
    private T response;
    private Integer statusCode;

    public ResponseDTO(T response, int statusCode) {
        this.response = response;
        this.statusCode = statusCode;
    }
}
