package ar.com.autosusados.autosusados.exceptions;

public class NoSeEncontroELAutoIdException extends RuntimeException{
    public NoSeEncontroELAutoIdException() {
        super("El auto id no puede ser encontrado");
    }
}
