package org.mercadolibre.ejercicio2joyeria.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mercadolibre.ejercicio2joyeria.entity.Jewel;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JewelUpdateDTO {
    private String menssage;
    private HttpStatus status;
    private Jewel jewel;
}
