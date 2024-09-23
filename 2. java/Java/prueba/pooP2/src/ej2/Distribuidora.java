package ej2;

import java.util.ArrayList;
import java.util.List;

public class Distribuidora {
    public static void main(String[] args) {
        List<Producto> productos = new ArrayList<Producto>();

        productos.add(new Producto("Pepe", 15.00));
        productos.add(new Perecedero("Pepe", 30.85, 3));
        productos.add(new NoPerecedero("Pepe", 45.00, "Cereales" ));
        productos.add(new Perecedero("Pepe", 16.73, 1));
        productos.add(new NoPerecedero("Pepe", 62.03, "Legumbres"));

        double total = 0.0;

        for (Producto producto : productos) {
             double precioFinal = producto.calcular(productos.size());
             total += precioFinal;
        }

        System.out.println(total);

    }
}
