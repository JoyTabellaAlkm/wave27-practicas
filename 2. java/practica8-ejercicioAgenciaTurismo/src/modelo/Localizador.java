package modelo;

import java.util.List;

public class Localizador {
    private Cliente cliente;
    private List<Reserva> listaReserva;
    private double total;

    public Localizador(Cliente cliente, List<Reserva> listaReserva) {
        this.cliente = cliente;
        this.listaReserva = listaReserva;
        calcularTotal();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Reserva> getListaReserva() {
        return listaReserva;
    }

    public void setListaReserva(List<Reserva> listaReserva) {
        this.listaReserva = listaReserva;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void calcularTotal(){
        this.total = this.listaReserva.stream()
                .mapToDouble(Reserva::getPrecioReserva)
                .reduce(0, (a, b) -> a + b);
    }

    @Override
    public String toString() {
        return "Localizador{" +
                "cliente=" + cliente +
                ", listaReserva=" + listaReserva +
                ", total=" + total +
                '}';
    }
}
