package com.example.joyeriajpa.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Jewel {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="nro_identificatorio")
    private int id;
    @Column(name="nombre")
    private String name;
    private String material;
    @Column(name="peso")
    private double weight;
    @Column(name="particularidad")
    private String description;
    @Column(name="posee_piedra")
    private boolean hasStone;
    @Column(name="VentaONo")
    private boolean saleOrNot;

    @Override
    public String toString() {
        return "Jewel Details:\n" +
                "ID: " + id + "\n" +
                "Nombre: " + name + "\n" +
                "Material: " + material + "\n" +
                "Peso: " + weight + " grams\n" +
                "Particularidad: " + description + "\n" +
                "Posse Piedra: " + (hasStone ? "Yes" : "No") + "\n" +
                "Disponible para la venta: " + (saleOrNot ? "Yes" : "No") + "\n";
    }

}
