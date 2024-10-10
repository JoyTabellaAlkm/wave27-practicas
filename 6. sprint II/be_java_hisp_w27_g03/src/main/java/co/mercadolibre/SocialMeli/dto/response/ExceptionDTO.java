package co.mercadolibre.SocialMeli.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class ExceptionDTO {
    private String message;
    private HttpStatus status;
}