package com.ar.mercadolibre.ageCalculator.exception;

import lombok.AllArgsConstructor;


public class UnbornPersonException extends RuntimeException {
    private String msg;

    public UnbornPersonException(String msg) {
        super(msg);
        this.msg = msg;
    }
}
