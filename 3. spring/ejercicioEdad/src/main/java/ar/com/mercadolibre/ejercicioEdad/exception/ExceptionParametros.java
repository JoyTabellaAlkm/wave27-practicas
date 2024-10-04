package ar.com.mercadolibre.ejercicioEdad.exception;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.BAD_REQUEST, reason="Fecha invalida")
public class ExceptionParametros extends RuntimeException {

  public ExceptionParametros(String message) {
    super(message);
  }


}
