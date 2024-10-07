package ar.com.mercadolibre.covid.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PersonDto {
    private String name;
    private String lastName;
}
