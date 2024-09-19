package models.productos;

public class Producto {
    private long codigo;
    private String nombre;
    private double costoUnitario;

    public Producto(long codigo, String nombre, double costoUnitario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.costoUnitario = costoUnitario;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getCostoUnitario() {
        return costoUnitario;
    }

    public void setCostoUnitario(double costoUnitario) {
        this.costoUnitario = costoUnitario;
    }

    public boolean tieneMismoId(long id) {
        return this.codigo == id;
    }
}
