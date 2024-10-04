package co.com.mercadolibre.deportistas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DeporteRenameDTO {
    private String nombre;
    private String nivel;
}
