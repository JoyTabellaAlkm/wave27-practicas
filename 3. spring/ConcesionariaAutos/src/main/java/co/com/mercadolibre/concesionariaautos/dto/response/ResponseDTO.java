package co.com.mercadolibre.concesionariaautos.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
public class ResponseDTO <T>{

    T response;
    Integer statusCode;
}
