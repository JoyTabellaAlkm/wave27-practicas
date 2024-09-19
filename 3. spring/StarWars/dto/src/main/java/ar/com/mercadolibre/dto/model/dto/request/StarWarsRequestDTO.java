package ar.com.mercadolibre.dto.model.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
@Data
public class StarWarsRequestDTO {
    private String name;
    private String height;
    private String mass;
    @JsonProperty("eye-color")
    private String eyeColor;
}
