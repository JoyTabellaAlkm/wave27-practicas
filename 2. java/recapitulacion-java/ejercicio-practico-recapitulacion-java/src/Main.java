
import java.math.BigDecimal;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Vehiculo> vehiculos = getVehiculos();
        Garaje garaje56 = new Garaje(56,vehiculos);

        System.out.println("\nVehiculos organizados por precio:\n");
        vehiculos.sort(Comparator.comparing(Vehiculo::getCosto));
        vehiculos.forEach(System.out::println);

        System.out.println("\nVehiculos organizados por marca y luego precio: \n");
        vehiculos.sort(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto));
        vehiculos.forEach(System.out::println);


        System.out.println("\nVehículos con precio menor a 1000:\n");

        vehiculos.stream()
                .filter(
                        vehiculo -> vehiculo.getCosto().compareTo(new BigDecimal(1000)) < 0
                ).forEach(System.out::println);

        System.out.println("\nVehículos con precio igual o mayor a 1000:\n");
        vehiculos.stream()
                .filter(
                        vehiculo -> vehiculo.getCosto().compareTo(new BigDecimal(1000)) >= 0
                ).forEach(System.out::println);



        Double promedio = vehiculos.stream()
                .map(Vehiculo::getCosto)
                .reduce(new BigDecimal(0), BigDecimal::add)
                .doubleValue() / vehiculos.size();
        System.out.println("\nPromedio total de precios de los vehiculos: " + promedio);
    }

    private static List<Vehiculo> getVehiculos() {
        Vehiculo vehiculo1 = new Vehiculo("Fiesta","Ford",new BigDecimal(1000));
        Vehiculo vehiculo2 = new Vehiculo("Focus","Ford",new BigDecimal(1200));
        Vehiculo vehiculo3 = new Vehiculo("Explorer","Ford",new BigDecimal(2500));
        Vehiculo vehiculo4 = new Vehiculo("Uno","Fiat",new BigDecimal(500));
        Vehiculo vehiculo5 = new Vehiculo("Cronos","Fiat",new BigDecimal(1000));
        Vehiculo vehiculo6 = new Vehiculo("Torino","Fiat",new BigDecimal(1250));
        Vehiculo vehiculo7 = new Vehiculo("Aveo","Chevrolet",new BigDecimal(1250));
        Vehiculo vehiculo8 = new Vehiculo("Spin","Chevrolet",new BigDecimal(2500));
        Vehiculo vehiculo9 = new Vehiculo("Corola","Toyota",new BigDecimal(1200));
        Vehiculo vehiculo10 = new Vehiculo("Fortuner","Toyota",new BigDecimal(3000));
        Vehiculo vehiculo11 = new Vehiculo("Logan","Renault",new BigDecimal(950));
        List<Vehiculo> vehiculos = new ArrayList<>(Arrays.asList(vehiculo1,vehiculo2,vehiculo3,vehiculo4,vehiculo5,
                vehiculo6,vehiculo7,vehiculo8,vehiculo9,vehiculo10,vehiculo11));
        return vehiculos;
    }
}