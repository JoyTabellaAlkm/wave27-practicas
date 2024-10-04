package co.com.mercadolibre.deportistas.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Deporte {
    private long id;
    private String nombre;
    private String nivel;

}
