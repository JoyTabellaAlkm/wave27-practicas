package ar.com.mercadolibre.dto.covid.model;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Person {
    private Integer id;
    private String name;
    private String lastname;
    private Integer age;
}
