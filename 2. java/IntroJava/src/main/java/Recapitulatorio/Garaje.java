package Recapitulatorio;

import java.util.Comparator;
import java.util.List;

public class Garaje {
    private long id;
    private List<Vehiculo> vehiculos;

    public Garaje(long id, List<Vehiculo> vehiculos) {
        this.id = id;
        this.vehiculos = vehiculos;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public void imprimirVehiculosOrdenadosPorCosto() {
        vehiculos.sort(Comparator.comparingDouble(Vehiculo::getCosto));
        vehiculos.forEach(System.out::println);
    }

    public void imprimirVehiculosOrdenadosPorMarcaYPrecio() {
        vehiculos.sort((v1, v2) -> new ComparadorPorMarcaYPrecio().compare(v1, v2));
        vehiculos.forEach(System.out::println);
    }

    public void imprimirVehiculosHasta1000() {
        vehiculos.stream().filter(vehiculo -> vehiculo.getCosto() <= 1000).forEach(System.out::println);
    }

    public void imprimirVehiculosMayorA1000() {
        vehiculos.stream().filter(vehiculo -> vehiculo.getCosto() <= 1000).forEach(System.out::println);
    }

    public void imprimirPromedioCostoVehiculos() {
        System.out.println(vehiculos.stream().mapToDouble(Vehiculo::getCosto).average());
    }
}
