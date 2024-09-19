package ar.com.mercadolibre.starwars.dto;

public record PersonajeDto(
        String name,
        Integer height,
        Integer mass,
        String gender,
        String homeworld,
        String species
) { }
