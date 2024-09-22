import java.util.ArrayList;
import java.util.List;

public class Garage {
    private long id;
    private List<Vehiculo> vehiculos;

    public Garage() {
        vehiculos = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
}
