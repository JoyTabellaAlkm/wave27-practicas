package ar.com.mercadolibre.ejercicioCovid.entitys.dto;

import ar.com.mercadolibre.ejercicioCovid.entitys.Sintoma;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaDto {
    private String nombre;
    private String apellido;
    private int edad;
    private List<Sintoma> sintomaList;
}
