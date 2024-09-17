package org.bootcamp;

import java.util.Comparator;

public class ComparadorPorMarcaYPrecio implements Comparator<Vehiculo> {
    @Override
    public int compare(Vehiculo o1, Vehiculo o2) {
        int comparacionPorMarca = o1.getMarca().compareTo(o2.getMarca());

        return comparacionPorMarca != 0
                ? comparacionPorMarca
                : Double.compare(o1.getCosto(), o2.getCosto());
    }
}
