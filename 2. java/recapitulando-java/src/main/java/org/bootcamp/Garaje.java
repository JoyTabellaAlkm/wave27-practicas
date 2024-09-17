package org.bootcamp;

import lombok.Getter;
import lombok.Setter;

import java.util.Comparator;
import java.util.List;

@Getter
@Setter
public class Garaje {
    private long id;
    private List<Vehiculo> vehiculos;

    public Garaje(long id, List<Vehiculo> vehiculos) {
        this.id = id;
        this.vehiculos = vehiculos;
    }

    public void imprimirVehiculosOrdenadosPorCosto() {
        vehiculos.stream().sorted(Comparator.comparingDouble(Vehiculo::getCosto))
                .forEach(System.out::println);
    }

    public void imprimirVehiculosOrdenadosPorMarcaYPrecio() {
        ComparadorPorMarcaYPrecio comparator = new ComparadorPorMarcaYPrecio();
        vehiculos.stream().sorted(comparator).forEach(System.out::println);
    }

    public void imprimirVehiculosHasta1000() {
        vehiculos.stream().filter(vehiculo -> vehiculo.getCosto() <= 1000).forEach(System.out::println);
    }

    public void imprimirVehiculosMayorA1000() {
        vehiculos.stream().filter(vehiculo -> vehiculo.getCosto() >= 1000).forEach(System.out::println);
    }

    public void imprimirPromedioCostoVehiculos() {
        System.out.println(vehiculos.stream().mapToDouble(Vehiculo::getCosto).average());
    }
}
