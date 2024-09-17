package org.bootcamp.model;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
public class Reserva {
    @Getter
    private TipoDeReserva tipo;
    private String descripcion;
    private double precio;
    private List<Descuento> descuentos;

    public Reserva(TipoDeReserva tipo, String descripcion, double precio) {
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.descuentos = new ArrayList<>();
    }

    public double getPrecio() {
        double precio = this.precio;

        for (Descuento descuento : descuentos) {
            precio = descuento.aplicar(precio);
        }

        return precio;
    }

    public void agregarDescuento(Descuento descuento) {
        descuentos.add(descuento);
    }
}
