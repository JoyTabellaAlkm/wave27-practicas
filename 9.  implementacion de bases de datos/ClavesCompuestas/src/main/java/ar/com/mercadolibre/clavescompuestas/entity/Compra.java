package ar.com.mercadolibre.clavescompuestas.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@IdClass(value = CompraKey.class)
public class Compra {

    @Id
    private Long id;
    @Id
    private LocalDate fecha;

    private String descripcion;

    private Double total;

    @OneToMany(mappedBy = "compra", cascade = CascadeType.ALL)
    private Set<Item> items;
}
