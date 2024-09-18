package model;

public class Item {
    private Long codigo;
    private String nombre;
    private int cantidadComprada;
    private double precioUnitario;

    public Item() {
    }

    public Item(Long codigo, String nombre, int cantidadComprada, double precioUnitario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidadComprada = cantidadComprada;
        this.precioUnitario = precioUnitario;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadComprada() {
        return cantidadComprada;
    }

    public void setCantidadComprada(int cantidadComprada) {
        this.cantidadComprada = cantidadComprada;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    @Override
    public String toString() {
        return "Item:" +
                " | codigo=" + codigo +
                " | nombre='" + nombre + '\'' +
                " | cantidadComprada=" + cantidadComprada +
                " | precioUnitario=" + precioUnitario + "\n";
    }
}
