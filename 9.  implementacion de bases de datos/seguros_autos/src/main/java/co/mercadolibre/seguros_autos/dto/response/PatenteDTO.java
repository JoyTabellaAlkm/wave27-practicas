package co.mercadolibre.seguros_autos.dto.response;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PatenteDTO {
    private List<String> patentes;
}
