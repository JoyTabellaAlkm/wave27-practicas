package ar.com.mercadolibre.dto.sportman.model;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class Sport implements Serializable {
    private String name;
    private String level;
}
