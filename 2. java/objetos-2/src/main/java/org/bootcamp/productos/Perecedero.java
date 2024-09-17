package org.bootcamp.productos;

public class Perecedero extends Producto {
    private int diasPorCaducar;
    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public String toString() {
        return super.toString().concat("\nDías por caducar: " + diasPorCaducar);
    }

    @Override
    public double calcular(int cantidaDeProductos) {
        double total = super.calcular(cantidaDeProductos);

        return switch (diasPorCaducar) {
            case 1 -> total / 4;
            case 2 -> total / 3;
            case 3 -> total / 2;
            default -> total;
        };
    }
}
