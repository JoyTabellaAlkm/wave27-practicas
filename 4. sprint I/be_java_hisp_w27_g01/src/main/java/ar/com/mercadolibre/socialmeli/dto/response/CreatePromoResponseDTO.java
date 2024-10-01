package ar.com.mercadolibre.socialmeli.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CreatePromoResponseDTO {
    @JsonProperty("created_id")
    private Integer createdId;
}
