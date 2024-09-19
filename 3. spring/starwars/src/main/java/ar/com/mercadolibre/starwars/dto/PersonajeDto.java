package ar.com.mercadolibre.starwars.dto;

public record PersonajeDto(
        String name,
        Integer height,
        Integer mass,
        String hairColor,
        String skinColor,
        String eyeColor,
        String birthYear,
        String gender,
        String homeworld,
        String species
) { }
