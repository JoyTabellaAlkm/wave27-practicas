package org.mercadolibre.practica2qatesters.dto;

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
