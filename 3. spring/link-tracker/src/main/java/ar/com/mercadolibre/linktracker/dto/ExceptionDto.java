package ar.com.mercadolibre.linktracker.dto;

public record ExceptionDto(
        String message,
        Integer statusCode
) { }
