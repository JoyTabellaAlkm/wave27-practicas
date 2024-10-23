package org.mercadolibre.ejercicio2joyeria.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionDTO {
    private String menssage;
    private HttpStatus status;
}
