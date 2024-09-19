package ar.com.covid.covid19.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PersonaDTO {
    private String nombre;
    private String apellido;
    private String sintoma;
}
