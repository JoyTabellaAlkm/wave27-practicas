package POO2.Ejercicio2;

public class Perecederos extends Producto{

    private int diasPorCaducar;

    public Perecederos(String nombre, double precio, int diasPorCaducar) {
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
        return "Perecederos{" +
                "diasPorCaducar=" + diasPorCaducar +
                '}';
    }

    @Override
    public double calcular(int cantProductos){
        double total = super.calcular(cantProductos);

        switch(diasPorCaducar){
            case 1:
                total = total / 4;
                break;
            case 2:
                total = total / 3;
                break;
            case 3:
                total = total / 2;
                break;
            default:
                total = total;
                break;
        }

        return total;
    }
}
