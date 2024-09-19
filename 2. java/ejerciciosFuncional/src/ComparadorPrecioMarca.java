import java.util.Comparator;

public class ComparadorPrecioMarca implements Comparator<Vehiculo> {

    @Override
    public int compare(Vehiculo o1, Vehiculo o2) {
        int resultado = o1.getMarca().compareTo(o2.getMarca());
        if(resultado==0){
            return Double.compare(o1.getCosto(), o2.getCosto());
        } else {
           return resultado;
        }
    }
}
