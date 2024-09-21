package co.com.mercadolibre.concesionariaautos.dto.response;

public record ExceptionDTO(
        String message,
        Integer statusCode
) {
}
