import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;

public class Garaje {
    private  int id;
    private List<Vehiculo> vehiculos;

    public Garaje(int id, List<Vehiculo> vehículos) {
        this.id = id;
        this.vehiculos = vehículos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Vehiculo> getVehículos() {
        return vehiculos;
    }

    public void setVehículos(List<Vehiculo> vehículos) {
        this.vehiculos = vehículos;
    }

    public  void imprimirVehiculosOrdenadosPrecio(){

        vehiculos.stream().sorted(Comparator.comparingDouble(Vehiculo::getCosto))
                .forEach(System.out::println);
    }

    public  void  imprimirVehiculosOrdernadoPrecioMarca(){
        ComparadorPrecioMarca comparadorPrecioMarca = new ComparadorPrecioMarca();
        vehiculos.stream().sorted(comparadorPrecioMarca)
                .forEach(System.out::println);
    }

    public  void preciosNoMayor(){
        vehiculos.stream().filter(vehiculo -> vehiculo.getCosto()<=1000)
                .forEach(System.out::println);

    }
    public  void preciosMayor(){
        vehiculos.stream().filter(vehiculo -> vehiculo.getCosto()>=1000)
                .forEach(System.out::println);

    }
    public  void promedioPrecio(){
         double promedi0;
          OptionalDouble promedioresult =       vehiculos.stream().mapToDouble(vehiculo-> vehiculo.getCosto())
                .average();
        promedi0 =promedioresult.getAsDouble();
        System.out.println("el promedio es: " + promedi0);
    }




}
