package com.example.calcularedad.exception;

public class UnbornPersonException extends RuntimeException {
    private String msg;

    public UnbornPersonException(String msg) {
        super(msg);
        this.msg = msg;
    }
}
