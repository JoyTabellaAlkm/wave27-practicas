package comparators;

import vehiculo.Vehiculo;

import java.util.Comparator;

public class ComparatorByPrecioMarca implements Comparator<Vehiculo> {
    @Override
    public int compare(Vehiculo v1, Vehiculo v2) {
        int sonMismaMarca = v1.getMarca().compareTo(v2.getMarca());

        return sonMismaMarca != 0
                ? sonMismaMarca
                : Double.compare(v1.getCosto(), v2.getCosto());
    }
}
