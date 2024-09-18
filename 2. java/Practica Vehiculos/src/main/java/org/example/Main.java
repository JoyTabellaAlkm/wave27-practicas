package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Vehiculo> vehiculos = List.of(new Vehiculo("Ford", "Fiesta", 1000),
                new Vehiculo("Ford", "Focus", 1200),
                new Vehiculo("Ford", "Explorer", 2500),
                new Vehiculo("Fiat", "Uno", 500),
                new Vehiculo("Fiat", "Cronos", 1000),
                new Vehiculo("Fiat", "Torino", 1250),
                new Vehiculo("Chevrolet", "Aveo", 1250),
                new Vehiculo("Chevrolet", "Spin", 2500),
                new Vehiculo("Toyota", "Corola", 1200),
                new Vehiculo("Toyota", "Fortuner", 3000),
                new Vehiculo("Renault", "Logan", 950));

        Garage garage = new Garage(1, vehiculos);
        var x = garage.getVehiculos()
                .stream()
                .sorted((v1, v2) -> v1.getCosto().compareTo(v2.getCosto()))
                .toList();
        System.out.println("Ej 4 - Ordenados por costo de menor a mayor:");
        System.out.println(x);



        var y = garage.getVehiculos()
                .stream()
                .sorted((v1, v2) -> v1.getCosto().compareTo(v2.getCosto()))
                .sorted((v1, v2) -> v1.getMarca().compareTo(v2.getMarca()))
                .toList();

        System.out.println("Ej 5 - Ordenados por marca, y después por costo de menor a mayor:");
        System.out.println(y);

        System.out.println("Ej 5 - Ordenados por marca, y después por costo de menor a mayor con comparator:");

        Comparator<Vehiculo> comparadorMultiple= Comparator.comparing(Vehiculo::getMarca).thenComparing(Comparator.comparing(Vehiculo::getCosto));
        garage.getVehiculos().stream().sorted(comparadorMultiple).forEach(System.out::println);

        System.out.println("Ej 6:");
        System.out.println("Vehiculos con costo menor a 1000:");
        garage.getVehiculos().stream().filter(v -> v.getCosto() < 1000).forEach(System.out::println);
        System.out.println("Vehiculos con costo mayor o igual a 1000:");
        garage.getVehiculos().stream().filter(v -> v.getCosto() >= 1000).forEach(System.out::println);
        System.out.println("Promedio total de los precios:");
        System.out.println(Math.round(garage.getVehiculos().stream().mapToInt(Vehiculo::getCosto).average().getAsDouble()));

    }
}