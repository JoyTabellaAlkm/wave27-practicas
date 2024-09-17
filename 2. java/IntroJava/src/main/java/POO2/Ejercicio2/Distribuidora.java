package POO2.Ejercicio2;

import java.util.ArrayList;

public class Distribuidora {

    public static void main(String[] args) {

        ArrayList<Producto> productos = new ArrayList<>();

        double precioTotal = 0.0;

        // Creating 5 Perecederos objects
                Perecederos perecedero1 = new Perecederos("Apple", 1.0, 2);
                Perecederos perecedero2 = new Perecederos("Banana", 0.5, 1);
                Perecederos perecedero3 = new Perecederos("Cherry", 2.0, 3);
                Perecederos perecedero4 = new Perecederos("Date", 1.5, 2);
                Perecederos perecedero5 = new Perecederos("Elderberry", 3.0, 1);

        // Adding Perecederos objects to the list
                productos.add(perecedero1);
                productos.add(perecedero2);
                productos.add(perecedero3);
                productos.add(perecedero4);
                productos.add(perecedero5);

        // Creating 5 NoPerecederos objects
                NoPerecederos noPerecedero1 = new NoPerecederos("Flour", 2.0, "Grain");
                NoPerecederos noPerecedero2 = new NoPerecederos("Granola", 3.0, "Cereal");
                NoPerecederos noPerecedero3 = new NoPerecederos("Honey", 4.0, "Sweetener");
                NoPerecederos noPerecedero4 = new NoPerecederos("Iodized Salt", 1.0, "Seasoning");
                NoPerecederos noPerecedero5 = new NoPerecederos("Jasmine Rice", 5.0, "Grain");

        // Adding NoPerecederos objects to the list
                productos.add(noPerecedero1);
                productos.add(noPerecedero2);
                productos.add(noPerecedero3);
                productos.add(noPerecedero4);
                productos.add(noPerecedero5);

        for (Producto producto : productos) {
            precioTotal += producto.calcular(5);
        }

        System.out.println("Precio total de los productos " + precioTotal);

    }

}
