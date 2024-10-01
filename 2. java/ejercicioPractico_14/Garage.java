import java.util.ArrayList;
import java.util.Comparator;

/*
 * Inicia creando una clase Vehículo con los atributos modelo,
 * marca y costo. Luego crea una clase garaje con los atributos
 * id o identificador único y una lista de vehículos. Crea además los
 * constructores de las clases y los métodos Setter y Getter.
 * */
public class Garage {
    private Integer id;
    private ArrayList<Vehiculo> vehiculos;

    public Garage(Integer id, ArrayList<Vehiculo> vehiculos) {
        this.id = id;
        this.vehiculos = vehiculos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    @Override
    public String toString() {
        return "Garage{" +
                "id=" + id +
                ", vehiculos=" + vehiculos +
                '}';
    }

    public void mostrarSegunMenorAMayorPrecio() {
        System.out.println("\n");
        this.getVehiculos().stream()
                .sorted(Comparator.comparing(Vehiculo::getCosto))
                .forEach(System.out::println);
    }

    public void mostrarSegunMarcaYPrecio() {
        System.out.println("\n");
        this.getVehiculos().stream()
                .sorted(Comparator.comparing(Vehiculo::getMarca))
                .sorted(Comparator.comparing(Vehiculo::getCosto))
                .forEach(System.out::println);
    }

    public void mostrarMenorAMil() {
        System.out.println("\n");
        this.getVehiculos().stream()
                .filter(vehiculo -> vehiculo.getCosto() < 1000)
                .forEach(System.out::println);
    }

    public void mostrarMayorOIgualAAMil() {
        System.out.println("\n");
        this.getVehiculos().stream()
                .filter(vehiculo -> vehiculo.getCosto() >= 1000)
                .forEach(System.out::println);
    }
}
