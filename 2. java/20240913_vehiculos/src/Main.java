import java.util.*;

public class Main {
    public static void main(String[] args) {
        Garage garage = new Garage();

        Vehiculo vehiculo1 = new Vehiculo("Ford", "Fiesta", 1000.0);
        Vehiculo vehiculo2 = new Vehiculo("Ford", "Focus", 1200.0);
        Vehiculo vehiculo3 = new Vehiculo("Ford", "Explores", 2500.0);
        Vehiculo vehiculo4 = new Vehiculo("Fiat", "Uno", 500.0);
        Vehiculo vehiculo5 = new Vehiculo("Fiat", "Cronos", 1000.0);
        Vehiculo vehiculo6 = new Vehiculo("Fiat", "Torino", 1250.0);
        Vehiculo vehiculo7 = new Vehiculo("Chevrolet", "Aveo", 1250.0);
        Vehiculo vehiculo8 = new Vehiculo("Chevrolet", "Spin", 2500.0);
        Vehiculo vehiculo9 = new Vehiculo("Toyota", "Corola", 1200.0);
        Vehiculo vehiculo10 = new Vehiculo("Toyota", "Fortuner", 3000.0);
        Vehiculo vehiculo11 = new Vehiculo("Renault", "Logan", 950.0);

        List<Vehiculo> vehiculos = new ArrayList<>(Arrays.asList(vehiculo1,vehiculo2,vehiculo3,vehiculo4,vehiculo5,
                vehiculo6,vehiculo7,vehiculo8,vehiculo9,vehiculo10,vehiculo11));

        garage.setVehiculos(vehiculos);
        //POR COSTO
        //menor a mayor
        vehiculos.stream().sorted(Comparator.comparingDouble(Vehiculo::getCosto)).forEach(System.out::println);
        //para dar vuelta el array mayor a menor
        vehiculos.stream().sorted(Comparator.comparingDouble(Vehiculo::getCosto).reversed()).forEach(System.out::println);

        //POR MARCA Y COSTO
        //menor a mayor
        vehiculos.stream().sorted(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto)).forEach(System.out::println);
        //mayor a menor
        vehiculos.stream().sorted(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto).reversed()).forEach(System.out::println);

        vehiculos.stream().filter(vehiculo -> vehiculo.getCosto()<1000).forEach(System.out::println);
        vehiculos.stream().filter(vehiculo -> vehiculo.getCosto()>=1000).forEach(System.out::println);


        //Promedio
        OptionalDouble result = vehiculos.stream().mapToDouble(Vehiculo::getCosto).average();
        if(result.isPresent()) {
            System.out.println("Promedio: " + result.getAsDouble());
        }



    }
}