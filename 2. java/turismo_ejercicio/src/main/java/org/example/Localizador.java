package org.example;

import java.util.List;

public class Localizador {
    private List<Reserva> reservas;
    private Cliente cliente;

    public Localizador(List<Reserva> reservas, Cliente cliente) {
        this.reservas = reservas;
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public Double getTotal(){
        //no contempla descuentos
        return this.reservas.stream().mapToDouble(Reserva::getPrecio).sum();
    }
}
