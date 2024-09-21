package co.com.mercadolibre.concesionariaautos.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data @AllArgsConstructor @NoArgsConstructor
public class Service {
    private Long id;
    private LocalDate date;
    private Integer kilometers;
    private String descriptions;
}
