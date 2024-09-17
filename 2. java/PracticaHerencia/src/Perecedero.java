public class Perecedero extends Producto{

    private Integer diasPorCaducar;

    public Integer getDiasPorCaducar() {
        return diasPorCaducar;
    }

    @Override
    public Double calcular(Integer cantidadDeProductos) {
        if (this.diasPorCaducar == 1){return (cantidadDeProductos * this.getPrecio()) / 4;}
        if (this.diasPorCaducar == 2){return (cantidadDeProductos * this.getPrecio()) / 3;}
        if (this.diasPorCaducar == 3){return (cantidadDeProductos * this.getPrecio()) / 2;}
        return this.getPrecio() * cantidadDeProductos;
    }

    @Override
    public String toString() {
        return super.toString() +
                " - DiasPorCaducar: " + diasPorCaducar;
    }

    public void setDiasPorCaducar(Integer diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    public Perecedero(String nombre, Double precio, Integer diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }
}
