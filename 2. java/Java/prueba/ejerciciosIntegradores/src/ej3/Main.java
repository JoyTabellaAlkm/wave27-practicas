package ej3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente(12345678, "Carola", "Diaz");
        Cliente cliente2 = new Cliente(12345679, "Roberto", "Muñoz");
        Cliente cliente3 = new Cliente(12345670, "Tamara", "Martinez");

        List<Cliente> clienteList = new ArrayList<>(Arrays.asList(cliente1, cliente2, cliente3));

        Cliente.getAllClients(clienteList);
        Cliente.deleteClient(clienteList, "Tamara");
        Cliente.getAllClients(clienteList);
        Cliente.findByDni(clienteList, 12345685);

    }
}
