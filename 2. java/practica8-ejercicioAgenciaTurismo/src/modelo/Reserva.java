package modelo;

import enums.TipoReserva;

public class Reserva {
    private String nombre;
    private TipoReserva tipoReserva;
    private double precioReserva;

    public Reserva(String nombre, TipoReserva tipoReserva, double precioReserva) {
        this.nombre = nombre;
        this.tipoReserva = tipoReserva;
        this.precioReserva = precioReserva;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoReserva getTipoReserva() {
        return tipoReserva;
    }

    public void setTipo(TipoReserva tipoReserva) {
        this.tipoReserva = tipoReserva;
    }

    public double getPrecioReserva() {
        return precioReserva;
    }

    public void setPrecioReserva(double precioReserva) {
        this.precioReserva = precioReserva;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "nombre='" + nombre + '\'' +
                ", tipoReserva=" + tipoReserva +
                ", precioReserva=" + precioReserva +
                '}';
    }
}
