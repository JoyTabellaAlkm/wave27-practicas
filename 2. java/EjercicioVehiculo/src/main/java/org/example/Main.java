package org.example;

import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;

public class Main {
    public static void main(String[] args) {

        List<Vehicle> vehicles = List.of(
                        new Vehicle("Ford","Fiesta",1000),
                        new Vehicle("Ford","Focus",1200 ),
                        new Vehicle("Ford", "Explorer",2500),
                        new Vehicle("Fiat","Uno",500),
                        new Vehicle("Fiat","Cronos",1000),
                        new Vehicle("Fiat","Torino",1250),
                        new Vehicle("Chevrolet","Aveo",1250),
                        new Vehicle("Chevrolet","Spin",2500),
                        new Vehicle("Toyota","Corolla",1200),
                        new Vehicle("Toyota","Forturner",3000),
                        new Vehicle("Renault","Logan",950));

        Garage garage = new Garage(1,vehicles);

        System.out.println("Ej 3: Obtener una lista de vehiculos ordenando el precio de menor a mayor");
        List<Vehicle> vehiclesCheapToExpensive = vehicles.stream()
                                                .sorted((v1,v2) -> Integer.compare(v1.getPrice(),v2.getPrice()))
                                                .toList();
        System.out.println(vehiclesCheapToExpensive);

        System.out.println("Ej 4: Obtener una lista de vehiculos ordenada por marca y precio");
        Comparator<Vehicle> vehicleComparator= Comparator.comparing(Vehicle::getBrand)
                                                .thenComparing(Vehicle::getPrice);
        vehicles.stream()
                .sorted(vehicleComparator)
                .forEach(System.out::println);

        System.out.println("Ej 6:");
        System.out.println("Vehiculos con costo menor a 1000:");
        vehicles.stream()
                .filter(v -> v.getPrice() < 1000)
                .forEach(System.out::println);
        System.out.println("Vehiculos con costo mayor o igual a 1000:");
        vehicles.stream()
                .filter(v -> v.getPrice() >= 1000)
                .forEach(System.out::println);

        // Calcular el promedio
        OptionalDouble average = vehicles.stream()
                                         .mapToDouble(Vehicle::getPrice)
                                         .average();

        // Imprimir el promedio
        if (average.isPresent()) {
            System.out.println("El promedio es: " + Math.round(average.getAsDouble()));
        } else {
            System.out.println("No hay datos para calcular el promedio.");
        }
    }
}