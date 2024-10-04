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

    @Override
    public String toString() {
        return "Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                "} " + super.toString();
    }

    @Override
    public double calcular(int cantidadProducto){
        double precio = super.calcular(cantidadProducto);
        if(diasPorCaducar == 1){
            return precio / 4;
        } else if(diasPorCaducar == 2){
            return precio / 3;
        } else if(diasPorCaducar == 3){
            return precio / 2;
        } else {
            return precio;
        }
    }
}
