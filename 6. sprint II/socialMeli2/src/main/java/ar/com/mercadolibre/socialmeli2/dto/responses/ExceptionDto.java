package ar.com.mercadolibre.socialmeli2.dto.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class ExceptionDto {
    private String message;
    @JsonProperty("status_code")
    private HttpStatus statusCode;
}
