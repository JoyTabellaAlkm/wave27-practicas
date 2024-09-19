package Garage;

import comparators.ComparatorByPrecioMarca;
import vehiculo.Vehiculo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Garage {
    private int id;
    private List<Vehiculo> vehiculos;

    public Garage(int id) {
        this.id = id;
        this.vehiculos = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void agregarVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos.addAll(vehiculos);
    }

    private void obtenerVehiculosOrdenadosPorMarcaYPrecio() {
        this.vehiculos.sort((v1, v2) -> new ComparatorByPrecioMarca().compare(v1,v2));
    }

    public void imprimirListaVehiculosPorMarcaYPreccio() {
        obtenerVehiculosOrdenadosPorMarcaYPrecio();
        vehiculos.stream().forEach(System.out::println);
    }

    private Stream<Vehiculo> obtenerVehiculosMenoresA1000() {
        return this.vehiculos.stream().filter(v -> v.getCosto() <= 1000);
    }

    private Stream<Vehiculo> obtenerVehiculosMayoresA1000() {
        return this.vehiculos.stream().filter(v -> v.getCosto() >= 1000);
    }

    public void imprimirVehiculosConCostoMenorA1000() {
        obtenerVehiculosMenoresA1000().forEach(System.out::println);
    }

    public void imprimirVehiculosConCostoMayorA1000() {
        obtenerVehiculosMayoresA1000().forEach(System.out::println);
    }

    public void imprimirPromedioTotal() {
        System.out.println(vehiculos.stream().mapToDouble(v -> v.getCosto()).average());
    }
}
