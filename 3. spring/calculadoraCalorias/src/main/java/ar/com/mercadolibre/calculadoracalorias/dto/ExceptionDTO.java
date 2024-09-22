package ar.com.mercadolibre.calculadoracalorias.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
@AllArgsConstructor
@Data
public class ExceptionDTO {
    private String msg;
    private HttpStatus code;
}
