package ar.com.mercadolibre.joyas.model.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import lombok.Data;

@Data
public class UpdateJewelryDTO {

    private String name;

    private String material;

    private Integer weight;

    private String particularity;

    @JsonProperty("has_stone")
    private Boolean hasStone;

}
