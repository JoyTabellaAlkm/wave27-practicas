public class Perecedero extends Producto{
    private int diasPorCaducar;

    public Perecedero(int diasPorCaducar, String nombre, double precio) {
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
        return super.toString() + " Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                '}';
    }
     @Override
    public double calcular(int cantidadProductos)
    {
        double precioActual = this.getPrecio()*cantidadProductos;

        if(this.diasPorCaducar == 1)
        {
            precioActual = precioActual/4;
        }
        else if(this.diasPorCaducar == 2)
        {
            precioActual = precioActual/3;
        }
        else if(this.diasPorCaducar == 3)
        {
            precioActual = precioActual/2;
        }

        return precioActual;
    }
}
