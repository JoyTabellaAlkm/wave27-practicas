package org.codmorse.exceptions;

public class CaracterInvalidoException extends Exception {
    public CaracterInvalidoException(String caracterInvalido) {
        super("Este caracter es invalido: " + caracterInvalido);
    }
}
