package ar.com.mercadolibre.showroomelastic.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "ventas")
public class Venta {

    @Id
    private Long id;

    private LocalDate fecha;

    private Double total;

    private String medioPago;

    private List<Prenda> prendas;

}
