package com.mercadolibre.joyeria.dtos.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseJoyaDTO {
    @JsonProperty("id_joya")
    private Integer idJoya;
    private String mensaje;
}
