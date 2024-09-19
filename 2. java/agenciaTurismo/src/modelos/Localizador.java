package modelos;

import java.util.List;

public class Localizador {
    private List<Reserva> reservas;
    private Cliente cliente;
    private double total;

    public Localizador(Cliente cliente, List<Reserva> reservas) {
        this.reservas = reservas;
        this.cliente = cliente;
        calcularTotal();
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void calcularTotal() {
        total = reservas.stream()
                .mapToDouble(Reserva::getPrecio)
                .sum();
    }

    public boolean contienePaqueteCompleto() {
        return reservas.stream()
                .anyMatch(Reserva::esPaqueteCompleto);
    }

    public long contarReservasPorTipo(TipoReserva tipo) {
        return reservas.stream()
                .filter(r -> r.getTipoReserva() == tipo)
                .count();
    }

    @Override
    public String toString() {
        return "Localizador{" +
                "reservas=" + reservas +
                ", cliente=" + cliente +
                ", total=" + total +
                '}';
    }
}
