package ar.com.mercadolibre.clothes.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Clothes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String type;
    private String brand;
    private String color;
    private Double size;
    private Integer quantity;
    @Column(name = "selling_price")
    private Double sellingPrice;
}
