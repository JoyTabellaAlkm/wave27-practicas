package ar.com.mercadolibre.link.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Link {

    private Integer id;
    private String link;
    private Integer metrics;
    private Boolean valid;
    private String password;

}
