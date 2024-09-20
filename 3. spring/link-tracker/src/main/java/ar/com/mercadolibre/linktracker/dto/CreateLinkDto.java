package ar.com.mercadolibre.linktracker.dto;

public record CreateLinkDto(
        String url,
        String password
) { }
