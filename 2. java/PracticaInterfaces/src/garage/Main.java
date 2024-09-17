package garage;

import practicas.Empleado;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
    // Crear la lista de vehículos
    List<Vehiculo> listaVehiculos = new ArrayList<>();

    // Agregar vehículos a la lista
    listaVehiculos.add(new Vehiculo("Fiesta", "Ford", 1000.0));
    listaVehiculos.add(new Vehiculo("Focus", "Ford", 1200.0));
    listaVehiculos.add(new Vehiculo("Explorer", "Ford", 2500.0));
    listaVehiculos.add(new Vehiculo("Uno", "Fiat", 500.0));
    listaVehiculos.add(new Vehiculo("Cronos", "Fiat", 1000.0));
    listaVehiculos.add(new Vehiculo("Torino", "Fiat", 1250.0));
    listaVehiculos.add(new Vehiculo("Aveo", "Chevrolet", 1250.0));
    listaVehiculos.add(new Vehiculo("Spin", "Chevrolet", 2500.0));
    listaVehiculos.add(new Vehiculo("Corolla", "Toyota", 1200.0));
    listaVehiculos.add(new Vehiculo("Fortuner", "Toyota", 3000.0));
    listaVehiculos.add(new Vehiculo("Logan", "Renault", 950.0));


    Garage garage = new Garage(1, listaVehiculos);

    System.out.println("Garage ID: " + garage.getId());
    //garage.getListaVehiculos().forEach(System.out::println);

//    System.out.println("Ahora ORDENADOS POR PRECIO");
//    garage.getListaVehiculos().stream().sorted(Comparator.comparing(Vehiculo::getCosto)).forEach(System.out::println);
//    System.out.println("Ahora ORDENADOS POR Marca");
//    garage.getListaVehiculos().stream().sorted(Comparator.comparing(Vehiculo::getMarca)).forEach(System.out::println);
//    System.out.println("Vehiculos con precio no mayor a 1000");
//    garage.getListaVehiculos().stream().filter(vehiculo -> vehiculo.getCosto() <= 1000).forEach(System.out::println);
//    System.out.println("Vehiculos con precio mayor a 1000");
//    garage.getListaVehiculos().stream().filter(vehiculo -> vehiculo.getCosto() >= 1000).forEach(System.out::println);

//    Double costoTotal = garage.getListaVehiculos().stream()
//            .mapToDouble(Vehiculo::getCosto)
//            .average()
//            .orElse(0.0);
//
//        System.out.println("Precio promedio de los autos: " + costoTotal);;
//    List<Double> listaModelos = garage.getListaVehiculos().stream().map(Vehiculo::getCosto).toList();
//    listaModelos.forEach(System.out::println);


    }
}
