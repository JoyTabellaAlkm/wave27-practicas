package ar.com.mercadolibre.ejercicioLink.entitys;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Link {

    private String url;
    private String password;
    private Boolean valido;
    private Integer vecesAccedido;

    public Link(String url, String password){
        this.url = url;
        this.password = password;
        this.valido = true;
        this.vecesAccedido = 0;
    }

}
