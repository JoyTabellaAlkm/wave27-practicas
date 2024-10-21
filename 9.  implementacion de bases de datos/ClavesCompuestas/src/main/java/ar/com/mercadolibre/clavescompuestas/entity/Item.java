package ar.com.mercadolibre.clavescompuestas.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Item {
    @Id
    private Long id;

    private String nombre;

    private Integer cantidad;

    private Double precio;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "compra_id", referencedColumnName = "id"),
            @JoinColumn(name = "compra_fecha", referencedColumnName = "fecha")
    })
    private Compra compra;

}
