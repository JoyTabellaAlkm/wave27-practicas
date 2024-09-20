package ar.com.mercadolibre.ejercicioLink.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateLinkResponseDto {
    private Integer id;
    private String url;
    private String password;
}
