package ar.org.mercadolibre.showroom.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "clothing")
public class Clothing {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long code;

    private String name;
    private String type;
    private String brand;
    private String coulor;
    private String size;
    private int count;
    private double price;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name= "sale_clothes",
        joinColumns = @JoinColumn(name="clothing_code"),
        inverseJoinColumns = @JoinColumn(name= "sale_id")
    )//tabla intermedia
    private Set<Sale> sales;

}
