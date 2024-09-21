package co.com.mercadolibre.calcularcalorias.dto.response;

public record ExceptionDTO(
        String mensaje,
        Integer statusCode
) {
}
