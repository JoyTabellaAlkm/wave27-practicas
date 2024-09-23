package ar.com.mercadolibre.ejercicioCovid.entitys;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sintoma {
    private int codigo;
    private String nombre;
    private String nivel_de_gravedad;
}
