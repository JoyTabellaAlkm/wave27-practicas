import java.util.Comparator;
import java.util.List;

public class    Garage {
    String id;
    List<Vehiculo> vehiculos;

    public Garage(String id, List<Vehiculo> vehiculos) {
        this.id = id;
        this.vehiculos = vehiculos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public List<Vehiculo> vehiculosPorPrecioMenor() {
        return this.vehiculos.stream()
                .sorted(Comparator.comparing(Vehiculo::getCosto))
                .toList();
    }

    public List<Vehiculo> vehiculosPorPrecioMarca() {
        return this.vehiculos.stream()
                .sorted(Comparator.comparing(Vehiculo::getMarca))
                .sorted(Comparator.comparing(Vehiculo::getCosto))
                .toList();
    }

    public List<Vehiculo> costoMenorA(Double costoParam){
        return this.vehiculos.stream()
                .filter(vehiculo -> vehiculo.costo<costoParam)
                .toList();
    }

    public List<Vehiculo> costoMayorOIgualA(Double costoParam){
        return this.vehiculos.stream()
                .filter(vehiculo -> vehiculo.costo >= costoParam)
                .toList();
    }

    public Double promedioCosto(){
        return this.vehiculos.stream()
                .mapToDouble(Vehiculo::getCosto)
                .average()
                .orElse(0.0);
    }
}
