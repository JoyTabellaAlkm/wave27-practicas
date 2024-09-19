import java.util.ArrayList;
import java.util.List;

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
        vehiculos.add(new Vehiculo("Toyota", "Corola", 1200));
        vehiculos.add(new Vehiculo("Toyota", "Fortuner", 3000));
        vehiculos.add(new Vehiculo("Renault", "Logan", 950));
        Garaje garaje = new Garaje(1, vehiculos);
        System.out.println("ordenar por precio");
        garaje.imprimirVehiculosOrdenadosPrecio();
        System.out.println("ordenar por marca y precio");
        garaje.imprimirVehiculosOrdernadoPrecioMarca();
        System.out.println("vehiculos con precio menores a 1000");
        garaje.preciosNoMayor();
        System.out.println("vehiculos mayores a 1000");
        garaje.preciosMayor();
        garaje.promedioPrecio();


    }
}