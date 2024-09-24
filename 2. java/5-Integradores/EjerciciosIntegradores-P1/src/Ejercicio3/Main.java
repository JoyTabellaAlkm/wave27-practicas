package Ejercicio3;

import Ejercicio3.model.Cliente;
import Ejercicio3.model.Factura;
import Ejercicio3.model.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Cliente> clientes = new ArrayList<>();
    private static List<Factura> facturas = new ArrayList<>();

    public static void main(String[] args) {
        //PARTE 1 ------------------

        Cliente cliente1 = new Cliente(43494001, "Santiago", "Inwinkelried");
        Cliente cliente2 = new Cliente(43494002, "Juan", "Perez");
        Cliente cliente3 = new Cliente(43494003, "Maria", "Gomez");
        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3);

        System.out.println("Lista de clientes: ");
        clientes.stream().forEach(cliente -> System.out.println(cliente.toString()));

        clientes.remove(1);
        System.out.println("Lista de clientes con el segundo eliminado: ");
        clientes.stream().forEach(cliente -> System.out.println(cliente.toString()));

        System.out.println("Ingrese un DNI para buscar un cliente: ");
        Scanner teclado = new Scanner(System.in);

        Integer dni = teclado.nextInt();
        String cliente = clientes.stream().
                filter(c -> c.getDni().equals(dni))
                .map(c -> c.getNombre() + " " + c.getApellido() + " DNI:" + c.getDni())
                .findFirst()
                .orElse("Cliente no encontrado");

        System.out.println(cliente);

        //PARTE 2---------------
        Item item1 = new Item("01", "Termo", 12000, 1);
        Item item2 = new Item("02", "Mate", 2000, 1);
        List<Item> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);

        crearFactura("000-1", cliente1, items);
        facturas.stream()
                .map(Object::toString)
                .forEach(System.out::println);

    }

    public static void crearFactura(String codigo, Cliente cliente, List<Item> items){
        boolean clienteExiste = clientes.stream()
                .anyMatch(c -> c.getDni().equals(cliente.getDni()));
        if (!clienteExiste){
            clientes.add(cliente);
        }

        Double totalFactura=0.0;
        for (Item item : items){
            totalFactura += item.getCostoUnitario()* item.getCantidad();
        }

        Factura factura = new Factura(codigo, cliente, items, totalFactura);
        facturas.add(factura);
    }
}