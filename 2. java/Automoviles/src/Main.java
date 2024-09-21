import clases.Garaje;
import clases.Vehiculo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Vehiculo> listaDeVehiculos = new ArrayList<>();

        // Agregar vehículos a la lista
        listaDeVehiculos.add(new Vehiculo("Ford", "Fiesta", 1000));
        listaDeVehiculos.add(new Vehiculo("Ford", "Focus", 1200));
        listaDeVehiculos.add(new Vehiculo("Ford", "Explorer", 2500));
        listaDeVehiculos.add(new Vehiculo("Fiat", "Uno", 500));
        listaDeVehiculos.add(new Vehiculo("Fiat", "Cronos", 1000));
        listaDeVehiculos.add(new Vehiculo("Fiat", "Torino", 1250));
        listaDeVehiculos.add(new Vehiculo("Chevrolet", "Aveo", 1250));
        listaDeVehiculos.add(new Vehiculo("Chevrolet", "Spin", 2500));
        listaDeVehiculos.add(new Vehiculo("Toyota", "Corola", 1200));
        listaDeVehiculos.add(new Vehiculo("Toyota", "Fortuner", 3000));
        listaDeVehiculos.add(new Vehiculo("Renault", "Logan", 950));

        //Instanciar garaje
        Garaje garaje = new Garaje(1, listaDeVehiculos);

        //Ordenar por costo
        System.out.println("--- VEHICULOS ORDENADOS POR COSTO ---");
        garaje.getListaVehiculos().stream()
                .sorted(Comparator.comparing(Vehiculo::getCosto)).forEach(System.out::println);
        System.out.println("\n\n");

        //Ordenar por marca y costo
        System.out.println("--- VEHICULOS ORDENADOS POR MARCA Y COSTO ---");

        garaje.getListaVehiculos().stream()
                .sorted(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto))
                .forEach(System.out::println);
        System.out.println("\n\n");

        //Filtrar los que tengan un costo menor a 1000
        System.out.println("--- VEHICULOS CON COSTO MENOR A 1000 ---");

        garaje.getListaVehiculos().stream()
                .filter(v -> v.getCosto() < 1000)
                .forEach(System.out::println);

        System.out.println("\n\n");

        //Filtrar los que tengan un costo mayor a 1000
        System.out.println("--- VEHICULOS CON COSTO MAYOR A 1000 ---");

        garaje.getListaVehiculos().stream()
                .filter(v -> v.getCosto() >= 1000)
                .forEach(System.out::println);


        System.out.println("\n\n");

        //Promedio de los costos
        System.out.println("--- PROMEDIO DE LOS COSTOS ---");
        double promedio = garaje.getListaVehiculos().stream()
                .mapToDouble(Vehiculo::getCosto).average().orElse(0);

        System.out.println(promedio);
    }
}