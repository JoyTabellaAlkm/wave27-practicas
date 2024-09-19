package modelos;

public class Reserva {
    private String nombre;
    private TipoReserva tipoReserva;
    private double precio;

    public Reserva(String nombre, TipoReserva tipoReserva, double precio) {
        this.nombre = nombre;
        this.tipoReserva = tipoReserva;
        this.precio = precio;
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

    public void setTipoReserva(TipoReserva tipoReserva) {
        this.tipoReserva = tipoReserva;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean esPaqueteCompleto() {
        return tipoReserva.equals(TipoReserva.PAQUETE_COMPLETO);
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "nombre='" + nombre + '\'' +
                ", tipoReserva=" + tipoReserva +
                ", precio=" + precio +
                '}';
    }
}
