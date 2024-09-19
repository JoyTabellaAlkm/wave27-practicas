import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("PARTE I");
        System.out.println("VISUALIZACIÓN DE CLIENTES");
        List<Cliente> clienteList = new ArrayList<>();
        clienteList.add(new Cliente(1, "Pepito", "Perez"));
        clienteList.add(new Cliente(2, "Jane", "Doe"));
        clienteList.add(new Cliente(3, "Margarita", "Manrique"));
        clienteList.stream().forEach(System.out::println);
        System.out.println("ELIMINACIÓN DE CLIENTE");
        System.out.print("Ingrese el DNI: ");
        int idCliente = input.nextInt();
        input.nextLine();
        Optional<Cliente> clienteEliminar = clienteList.stream().filter(cliente -> cliente.getDni() == idCliente).findFirst();
        if(clienteEliminar.isPresent())
            clienteList.remove(clienteEliminar.get());
        else
            System.out.println("El cliente no existe");
        System.out.println("CLIENTES ACTUALIZADOS");
        clienteList.stream().forEach(System.out::println);
        System.out.println("BUSQUEDA DE CLIENTE");
        System.out.print("Ingrese el DNI: ");
        int idClienteBuscar = input.nextInt();
        Optional<Cliente> clienteBuscar = clienteList.stream().filter(cliente -> cliente.getDni() == idClienteBuscar).findFirst();
        if(clienteBuscar.isPresent())
            System.out.println(clienteBuscar);
        else
            System.out.println("El cliente no existe");
    }
}