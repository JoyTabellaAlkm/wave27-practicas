package ar.com.mercadolibre.link.model.dto.response;

import io.swagger.v3.oas.models.security.SecurityScheme;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LinkResponseDTO {
    private String url;
    private Integer metrics;
    private Boolean valid;
}
