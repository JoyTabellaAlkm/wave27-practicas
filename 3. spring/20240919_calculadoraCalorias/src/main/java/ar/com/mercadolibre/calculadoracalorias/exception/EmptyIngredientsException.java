package ar.com.mercadolibre.calculadoracalorias.exception;

public class EmptyIngredientsException extends RuntimeException {
    public EmptyIngredientsException(String msg) { super(msg); }
}
