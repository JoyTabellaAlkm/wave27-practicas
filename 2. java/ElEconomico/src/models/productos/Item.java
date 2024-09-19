package models.productos;

public class Item extends Producto {
    private int cantComprada;

    public Item(long codigo, String nombre, double costoUnitario, int cantComprada) {
        super(codigo, nombre, costoUnitario);
        this.cantComprada = cantComprada;
    }

    public int getCantComprada() {
        return cantComprada;
    }

    public void setCantComprada(int cantComprada) {
        this.cantComprada = cantComprada;
    }

    public double getPrecio() {
        return super.getCostoUnitario() * cantComprada;
    }
}
