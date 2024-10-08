import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Vehiculo> vehiculos = new ArrayList<>();

        vehiculos.add(new Vehiculo("Ford", "Fiesta", 1000));
        vehiculos.add(new Vehiculo("Ford", "Focus", 1200));
        vehiculos.add(new Vehiculo("Ford", "Explorer", 2500));
        vehiculos.add(new Vehiculo("Fiat", "Uno", 500));
        vehiculos.add(new Vehiculo("Fiat", "Cronos", 1000));
        vehiculos.add(new Vehiculo("Fiat", "Torino", 1250));
        vehiculos.add(new Vehiculo("Chevrolet", "Aveo", 1250));
        vehiculos.add(new Vehiculo("Chevrolet", "Spin", 2500));
        vehiculos.add(new Vehiculo("Toyota", "Corolla", 1200));
        vehiculos.add(new Vehiculo("Toyota", "Fortuner", 3000));
        vehiculos.add(new Vehiculo("Renault", "Logan", 950));

        Garaje garajeUno = new Garaje(1, vehiculos);

        System.out.println("Lista ordenada por precio: \n");

        Collections.sort(vehiculos, Comparator.comparingDouble(Vehiculo::getCosto));
        vehiculos.forEach(System.out::println);

        System.out.println("\nLista filtrada por marca y precio: \n");
        List<Vehiculo> vehiculoFilter = vehiculos.stream()
                .filter(v -> v.getMarca().equals("Fiesta") && v.getCosto() == 1000)
                .toList();

        vehiculoFilter.forEach(System.out::println);

        List<Vehiculo> vehiculosMayorMil = vehiculos.stream()
                .filter(v -> v.getCosto() >= 1000)
                .toList();
        System.out.println("\nLista filtrada por precio mayor o igual a 1000: \n");
        vehiculosMayorMil.forEach(System.out::println);

        double promedio = vehiculos.stream().mapToDouble(Vehiculo::getCosto)
                .reduce(0, (a, b) -> a + b / vehiculos.size());
        System.out.println("\nPromedio del costo de los vehículos: " +promedio);

    }
}