package org.bootcamp.model;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
public class Localizador {
    @Getter
    private Cliente cliente;
    @Getter
    private List<Reserva> reservas;
    private List<Descuento> descuentos;

    public Localizador(Cliente cliente, List<Reserva> reservas) {
        this.cliente = cliente;
        this.reservas = reservas;
        this.descuentos = new ArrayList<>();
    }

    public double getPrecio() {
        double precio = reservas.stream().mapToDouble(Reserva::getPrecio).sum();

        for (Descuento descuento : descuentos) {
            precio = descuento.aplicar(precio);
        }

        return precio;
    }

    public boolean tienePaqueteCompleto() {
        return reservas.stream().map(Reserva::getTipo).distinct().count() == TipoDeReserva.values().length;
    }

    public void agregarDescuento(Descuento descuento) {
        descuentos.add(descuento);
    }
}
