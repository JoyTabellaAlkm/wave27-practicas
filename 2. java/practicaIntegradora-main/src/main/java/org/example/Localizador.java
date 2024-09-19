package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
public class Localizador {
    private Cliente cliente;
    private List<Reserva> listaReserva;
    private Double total;

    public Localizador(Cliente cliente, List<Reserva> listaReserva) {
        this.cliente = cliente;
        this.listaReserva = listaReserva;
        calcularTotal();

    }

    public void calcularTotal(){
        this.total = this.listaReserva.stream()
                .mapToDouble(Reserva::getPrecioReserva)
                .sum();
    }
}
