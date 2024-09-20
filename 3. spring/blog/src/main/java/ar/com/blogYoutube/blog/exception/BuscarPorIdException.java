package ar.com.blogYoutube.blog.exception;

public class BuscarPorIdException extends RuntimeException {
    public BuscarPorIdException(String mensaje) {
        super(mensaje);
    }
}
