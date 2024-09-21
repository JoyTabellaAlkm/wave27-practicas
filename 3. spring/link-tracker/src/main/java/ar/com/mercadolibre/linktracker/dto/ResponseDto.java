package ar.com.mercadolibre.linktracker.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ResponseDto<T> {
    private T response;
    private Integer statusCode;
}
