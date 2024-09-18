package model;

import java.util.List;

public class Localizador {
    private Cliente cliente;
private List<Reserva> listaReservas;


    public Localizador() {
    }

    public Localizador(String nombreCliente, List<Reserva> listaReservas) {
        this.nombreCliente = nombreCliente;
        this.listaReservas = listaReservas;
        calcularTotal();
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public List<Reserva> getListaReservas() {
        return listaReservas;
    }

    public void setListaReservas(List<Reserva> listaReservas) {
        this.listaReservas = listaReservas;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getTotalConDescuento() {
        return totalConDescuento;
    }

    public void setTotalConDescuento(double totalConDescuento) {
        this.totalConDescuento = totalConDescuento;
    }
    private void calcularTotal(){
        total = listaReservas.stream().mapToDouble(Reserva::getPrecio).sum();
    }
    public void aplicarDescuento(double porcentaje)
    {
        total -= total * porcentaje/100;
    }
}
