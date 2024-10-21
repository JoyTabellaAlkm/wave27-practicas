package com.mercadolibre.joyeria.enitity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Joya {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nro_identificatorio")
    Long nroIdentificatorio;
    @Column(length = 30)
    String nombre;
    @Column(length = 30)
    String material;
    Integer peso;
    @Column(length = 50)
    String particularidad;
    @Column(name = "posee_piedra")
    Boolean poseePiedra;
    @Column(name = "venta_o_no")
    Boolean ventaONo;

    public Joya() {
        this.setVentaONo(true);
    }
}
