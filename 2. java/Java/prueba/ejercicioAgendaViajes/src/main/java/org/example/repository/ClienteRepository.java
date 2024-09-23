package org.example.repository;

import org.example.domain.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteRepository {

    private static List<Cliente> clientes = new ArrayList<>();

    public static void addClient(Cliente cliente){
        clientes.add(cliente);
    }

    public static void removeClient(Cliente cliente) {
        if(clientes.remove(cliente)) {
            System.out.println("Se pudo eliminar el cliente");
        } else {
            System.out.println("No se pudo eliminar el cliente");
        }
    }

    public static List<Cliente> getClientes() {
        return clientes;
    }
}
