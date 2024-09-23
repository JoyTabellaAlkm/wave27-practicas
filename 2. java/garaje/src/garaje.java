import java.util.List;

public class garaje {
    private int id;
    private List<Vehiculo> listaVehiculos;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }

    public void setListaVehiculos(List<Vehiculo> listaVehiculos) {
        this.listaVehiculos = listaVehiculos;
    }

    public garaje(int id, List<Vehiculo> listaVehiculos) {
        this.id = id;
        this.listaVehiculos = listaVehiculos;
    }

    @Override
    public String toString() {
        return "garaje{" +
                "id=" + id +
                ", listaVehiculos=" + listaVehiculos +
                '}';
    }
}
