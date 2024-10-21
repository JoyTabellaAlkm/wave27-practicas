package com.bootcamp.joyeria.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CreatedJewelDto(
        @JsonProperty("nro_identificatorio")
        Long id
) { }
