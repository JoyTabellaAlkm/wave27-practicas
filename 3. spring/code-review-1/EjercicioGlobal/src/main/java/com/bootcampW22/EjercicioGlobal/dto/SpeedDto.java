package com.bootcampW22.EjercicioGlobal.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record SpeedDto(
        @JsonProperty("max_speed")
        String maxSpeed
) { }
