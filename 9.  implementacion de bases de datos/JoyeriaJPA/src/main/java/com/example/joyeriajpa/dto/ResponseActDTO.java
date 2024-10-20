package com.example.joyeriajpa.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResponseActDTO<T> {
    private T data;
    private String message;
    private int statusCode;
}
