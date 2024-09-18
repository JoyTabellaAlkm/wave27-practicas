package ej3;

import java.util.List;

public class ClienteRepository {
    protected static List<Cliente> clientes;

    public static void agregarCliente(Cliente cliente){
        clientes.add(cliente);
    }

}
