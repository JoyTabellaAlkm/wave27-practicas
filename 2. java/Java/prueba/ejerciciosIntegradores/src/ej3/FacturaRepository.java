package ej3;

import java.util.ArrayList;
import java.util.List;

import static ej3.ClienteRepository.clientes;

public class FacturaRepository {
    protected static List<Factura> facturas;
    protected static List<Item> items;

    Item item1 = new Item(1, "Gaseosa", 2,2000);
    Item item2 = new Item(2, "Leche", 1,1500);

    public void agregarFactura(Cliente cliente){
        items.add(item1);
        items.add(item2);
        int dni = cliente.getDni();
        boolean bandera = false;
        double total = items.stream().mapToDouble(Item::getCosto).sum();
        for(Cliente clienteRepository: clientes){
            if (clienteRepository.getDni() == dni){
                bandera = true;
                Factura factura1 = new Factura(cliente, items, total);
                facturas.add(factura1);
            }

        }

        if (!bandera){
            ClienteRepository.agregarCliente(cliente);
            Factura factura1 = new Factura(cliente, items, total);
            facturas.add(factura1);
        }


    }

}
