import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Vehiculo> listaVehiculos = Arrays.asList(

            new Vehiculo("Ford","Fiesta",1000),
            new Vehiculo("Ford","Focus",1200),
            new Vehiculo("Ford","Explorer",2500),

            new Vehiculo("Fiat","Uno",500),
            new Vehiculo("Fiat","Cronos",1000),
            new Vehiculo("Fiat","Torino",1250),

            new Vehiculo("Chevrolet","Aveo",1250),
            new Vehiculo("Chevrolet","Spin",2500),

            new Vehiculo("Toyota","Corola",1200),
            new Vehiculo("Toyota","Fortuner",3000),

            new Vehiculo("Renault","Logan",950)

        );

        listaVehiculos.stream().sorted(Comparator.comparingInt(Vehiculo::getPrecio)).forEach(System.out::println);

        System.out.println("\n");

        listaVehiculos.stream()
                .sorted(Comparator.comparing(Vehiculo::getMarca))
                .sorted(Comparator.comparingInt(Vehiculo::getPrecio))
                .forEach(System.out::println);

        System.out.println("\n");

        listaVehiculos.stream().filter(p -> p.getPrecio() < 1000).forEach(System.out::println);
        System.out.println("------------------------------------");
        listaVehiculos.stream().filter(p -> p.getPrecio() >= 1000).forEach(System.out::println);
        System.out.println("------------------------------------");
        double promedio = listaVehiculos.stream().mapToInt(Vehiculo::getPrecio).average().orElse(0);
        System.out.println("El promedio de los precios es de: "+promedio);
    }
}