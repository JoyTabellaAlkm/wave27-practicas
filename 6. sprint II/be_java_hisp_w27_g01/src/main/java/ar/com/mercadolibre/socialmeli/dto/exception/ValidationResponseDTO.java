package ar.com.mercadolibre.socialmeli.dto.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ValidationResponseDTO {

    private String argument;
    @JsonProperty("rejected_value")
    private Object rejectedValue;
    private String message;

}
