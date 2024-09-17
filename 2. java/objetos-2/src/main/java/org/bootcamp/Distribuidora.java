package org.bootcamp;

import org.bootcamp.productos.NoPerecedero;
import org.bootcamp.productos.Perecedero;
import org.bootcamp.productos.Producto;

public class Distribuidora {
    public static void main(String[] args) {
        Producto[] productos = new Producto[] {
            new Producto("Producto 1", 10),
            new Perecedero("Producto 2", 20, 3),
            new NoPerecedero("Producto 3", 30, "Tipo 1"),
            new Perecedero("Producto 4", 40, 5),
            new NoPerecedero("Producto 5", 50, "Tipo 2")
        };

        System.out.println("\n<--------------------------------->");
        for (Producto producto : productos) {
            System.out.println(producto);
            System.out.println("Precio total: " + producto.calcular(5));
            System.out.println("<--------------------------------->");
        }
    }
}
