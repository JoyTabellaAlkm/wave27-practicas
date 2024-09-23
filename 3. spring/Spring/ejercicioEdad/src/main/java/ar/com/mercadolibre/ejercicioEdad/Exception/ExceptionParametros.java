package ar.com.mercadolibre.ejercicioEdad.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ResponseStatus(value= HttpStatus.BAD_REQUEST, reason="Error en datos de entrada")
public class ExceptionParametros extends RuntimeException {

  public ExceptionParametros(String message) {
    super(message);
  }

  @ExceptionHandler(IllegalArgumentException.class)
  public ResponseEntity<Map<String, Object>> handleIllegalArgumentException(IllegalArgumentException ex) {
    Map<String, Object> response = new HashMap<>();
    response.put("timestamp", LocalDateTime.now());
    response.put("status", HttpStatus.BAD_REQUEST.value());
    response.put("error", "Validación fallida");
    response.put("message", ex.getMessage());
    response.put("path", "/validar/{numero}");  // Puedes personalizar según la ruta que quieras
    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
  }

}
