package ar.com.mercadolibre.showroomelastic.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "prendas")
public class Prenda {

    @Id
    private Long codigo;

    private String nombre;

    private String tipo;

    private String marca;

    private String color;

    private String talle;

    private Integer cantidad;

    private Double precioVenta;

    @JsonIgnore
    private Venta venta;

}
