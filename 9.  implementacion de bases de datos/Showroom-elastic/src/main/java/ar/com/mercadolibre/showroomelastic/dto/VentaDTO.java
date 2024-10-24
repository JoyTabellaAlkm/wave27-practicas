package ar.com.mercadolibre.showroomelastic.dto;

import ar.com.mercadolibre.showroom.entity.Prenda;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VentaDTO {

    private Long id;

    private LocalDate fecha;

    private Double total;

    @JsonIgnoreProperties("medio_de_pago")
    private String medioPago;

    private List<Prenda> prendas;
}
