package com.mercadolibre.ejercicioCovid.model.dto;

import com.mercadolibre.ejercicioCovid.model.entity.GravityLevel;

public record SymptomDTO(
        String name,
        GravityLevel gravityLevel
) {}
