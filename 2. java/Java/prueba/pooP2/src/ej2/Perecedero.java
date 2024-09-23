package ej2;

public class Perecedero extends Producto{
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
    public String toString() {
        return "Dias: " + diasPorCaducar;
    }
    @Override
    public double calcular(int cantidadDeProductos) {
        double calculo = getPrecio() * cantidadDeProductos;

        if (diasPorCaducar == 1) {
            return calculo / 4;
        }
        else if (diasPorCaducar == 2) {
            return calculo / 3;
        }
        else {
            return calculo / 2;
        }
    }
}
