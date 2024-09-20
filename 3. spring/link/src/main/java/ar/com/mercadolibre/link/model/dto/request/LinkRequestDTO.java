package ar.com.mercadolibre.link.model.dto.request;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LinkRequestDTO {
    private String url;
    private String password;
}
