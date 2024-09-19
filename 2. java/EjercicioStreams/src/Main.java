import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class Main {
    public static void main(String[] args) {
        List<Vehiculo> vehiculos = new ArrayList<>();
        anadirVehiculos(vehiculos);

        Garaje garajeCentral = new Garaje(0, vehiculos);

        //ORDENANDO LA LISTA DE VEHICULOS POR COSTO
        System.out.println("ORDENADO POR COSTE");
        vehiculos.stream().sorted(Comparator.comparingDouble(Vehiculo::getCosto)).forEach(System.out::println);

        //ORDENANDO LA LISTA DE VEHICULOS POR MARCA Y PRECIO
        System.out.println("\nORDENADO POR MARCA Y PRECIO");
        vehiculos.stream().sorted(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto)).forEach(System.out::println);

        //Se desea extraer una lista de vehículos con precio no mayor a 1000, luego otra con precios mayor o igual 1000 y por último, obtén el promedio total de precios de toda la lista de vehículos.
        System.out.println("\nVEHICULOS NO MAYORES A 1000");
        vehiculos.stream().filter(vehiculo -> vehiculo.getCosto() < 1000).forEach(System.out::println);
        System.out.println("\nVEHICULOS MAYORES O IGUALES A 1000");
        vehiculos.stream().filter(vehiculo -> vehiculo.getCosto() >= 1000).forEach(System.out::println);

        System.out.println("\nPROMEDIO DE PRECIOS DE TODA LA LISTA");
        double avg = vehiculos.stream().mapToDouble(Vehiculo::getCosto).average().orElse(0);
        System.out.println(avg);
    }

    public static void anadirVehiculos(List<Vehiculo> v){
        v.add(new Vehiculo("Fiesta","Ford",1000));
        v.add(new Vehiculo("Focus","Ford",1200));
        v.add(new Vehiculo("Explorer","Ford",2500));
        v.add(new Vehiculo("Uno","Fiat",500));
        v.add(new Vehiculo("Cronos","Fiat",1000));
        v.add(new Vehiculo("Torino","Fiat",1250));
        v.add(new Vehiculo("Aveo","Chevrolet",1250));
        v.add(new Vehiculo("Spin","Chevrolet",2500));
        v.add(new Vehiculo("Corola","Toyota",1200));
        v.add(new Vehiculo("Fortuner","Toyota",3000));
        v.add(new Vehiculo("Logan","Renault",950));
    }
}