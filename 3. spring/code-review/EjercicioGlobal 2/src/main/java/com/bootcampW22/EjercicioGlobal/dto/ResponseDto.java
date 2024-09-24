package com.bootcampW22.EjercicioGlobal.dto;

public class ResponseDto {
    public String message;
    public int codigo;

    public ResponseDto(){}

    public ResponseDto(String message, int codigo) {
        this.message = message;
        this.codigo = codigo;
    }
}
