import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Vehiculo> vehiculos = new ArrayList<>();
        vehiculos.add(new Vehiculo("Ford", "Fiesta", 1000.0));
        vehiculos.add(new Vehiculo("Ford", "Focus", 1200.0));
        vehiculos.add(new Vehiculo("Ford", "Explorer", 2500.0));
        vehiculos.add(new Vehiculo("Fiat", "Uno", 500.0));
        vehiculos.add(new Vehiculo("Fiat", "Cronos", 1000.0));
        vehiculos.add(new Vehiculo("Fiat", "Torino", 1250.0));
        vehiculos.add(new Vehiculo("Chevrolet", "Aveo", 1250.0));
        vehiculos.add(new Vehiculo("Chevrolet", "Spin", 2500.0));
        vehiculos.add(new Vehiculo("Toyota", "Corolla", 1200.0));
        vehiculos.add(new Vehiculo("Toyota", "Fortuner", 3000.0));
        vehiculos.add(new Vehiculo("Renault", "Logan", 950.0));

        Garage garage1 = new Garage("G1", vehiculos);

        System.out.println(garage1.vehiculosPorPrecioMenor());
        System.out.println(garage1.vehiculosPorPrecioMarca());
        System.out.println(garage1.costoMayorOIgualA(1000.0));
        System.out.println(garage1.costoMenorA(1000.0));
        System.out.println(garage1.promedioCosto());
    }
}