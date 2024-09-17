package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FacturaRepository implements IRepositorio<Factura>{
    List<Factura> listaFacturas = new ArrayList<>();
    Map<String, Cliente> listaCliente = new HashMap<>();

    @Override
    public void save(Factura factura) {
        Cliente cliente = factura.getCliente();

        if (!listaCliente.containsKey(cliente.getApellido())) {
            listaCliente.put(cliente.getDni(), cliente);
        }

        listaFacturas.add(factura);
    }

    @Override
    public void delete(Factura factura) {
        listaFacturas.remove(factura);
    }

    @Override
    public List<Factura> getAll() {
        return new ArrayList<>(listaFacturas);
    }

    public void getFacturasCliente(Cliente cliente){
        this.listaFacturas.stream()
                .filter(factura -> factura.getCliente().equals(cliente))
                .collect(Collectors.toSet())
                .forEach(System.out::println);
    }
}
