package co.com.mercadolibre.starwars.dto.response;

public record ExceptionDTO(
        String message,
        Integer statusCode
)
{}