package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Cliente cliente1 = new Cliente("Mati", "Gregorat", "123");
        Cliente cliente2 = new Cliente("Nico", "Gregorat", "321");

        Item item1 = new Item("001", "Laptop", 1, 100.0);
        Item item2 = new Item("002","Mouse", 4, 20.0);

        List<Item> itemsFactura1 = new ArrayList<>(List.of(item1, item2));
        Factura factura1 = new Factura(cliente1, itemsFactura1);


        FacturaRepository facturaRepository = new FacturaRepository();
        facturaRepository.save(factura1);

        facturaRepository.getAll().forEach(System.out::println);


    }

}