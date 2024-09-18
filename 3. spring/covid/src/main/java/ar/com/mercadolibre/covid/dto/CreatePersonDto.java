package ar.com.mercadolibre.covid.dto;

import java.util.List;

public record CreatePersonDto(
        String firstName,
        String lastName,
        Integer age,
        List<String> symptomNames
) { }
