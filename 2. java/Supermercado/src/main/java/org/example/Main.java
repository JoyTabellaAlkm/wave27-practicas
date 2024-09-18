package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Crear clientes
        Client cliente1 = new ClientImpl("12345", "Juan", "Pérez");
        Client cliente2 = new ClientImpl("67890", "Ana", "Gómez");


        // Crear una factura
        Item item1 = new ItemImpl("001", "Leche", 1.50, 2);
        Item item2 = new ItemImpl("002", "Pan", 0.90, 1);
        Bill factura = new BillImpl(cliente1);
        factura.addItem(item1);
        factura.addItem(item2);

        // Imprimir el total de la factura
        System.out.println("Total de la factura: " + factura.calculateTotal());

    }
}