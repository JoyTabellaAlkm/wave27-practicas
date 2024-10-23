package co.mercadolibre.seguros_autos.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RespuestaSimpleDTO {
    private String message;
    private HttpStatus status;
}
