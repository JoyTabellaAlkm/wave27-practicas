package ar.org.mercadolibre.miniseries.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="mini_serie")
public class MiniSerie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="nombre", length=25, nullable = false) //campo siempre requerido
    private String name;

    @Column(name="rating")
    private Double rating;

    @Column(name= "amount_of_awards")
    private int amountOfAwards;

}
