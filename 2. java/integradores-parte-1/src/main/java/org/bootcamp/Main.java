package org.bootcamp;

import org.bootcamp.repository.IRepository;
import org.bootcamp.repository.Repository;
import org.bootcamp.supermercado.Cliente;
import org.bootcamp.supermercado.Factura;
import org.bootcamp.supermercado.Item;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        IRepository<Item, UUID> itemsRepository = new Repository<>();
        IRepository<Cliente, UUID> clientesRepository = new Repository<>();
        IRepository<Factura, UUID> facturasRepository = new Repository<>();

        Scanner scanner = new Scanner(System.in);

        Item leche = new Item("1", "Leche", 2, 1.5);
        Item pan = new Item("2", "Pan", 3, 0.5);
        Item huevos = new Item("3", "Huevos", 12, 0.1);
        Item queso = new Item("4", "Queso", 1, 2.0);
        Item yogur = new Item("5", "Yogur", 4, 0.2);
        itemsRepository.add(List.of(leche, pan, huevos, queso, yogur));

        // 1.2
        Cliente juan = new Cliente("1", "Juan", "Perez");
        Cliente maria = new Cliente("2", "Maria", "Gomez");
        Cliente pedro = new Cliente("3", "Pedro", "Lopez");
        clientesRepository.add(List.of(juan, maria, pedro));

        // 1.3
        clientesRepository.getAll().forEach(System.out::println);

        // 1.4
        clientesRepository.remove(juan);
        clientesRepository.getAll().forEach(System.out::println);

        //1.5
        System.out.println("Ingrese el DNI del cliente a buscar: ");
        String dni = scanner.next();
        clientesRepository.getAllWhere(cliente -> cliente.getDni().equals(dni)) // para este caso particular serviría más un IRepository<Client, String> que busque por id
                .stream()
                .findFirst()
                .ifPresentOrElse(System.out::println, () -> System.out.println("No se encontro el cliente"));

        // 2
        Factura factura = new Factura(List.of(leche, pan, huevos, queso, yogur));
        facturasRepository.add(factura);
        if (!clientesRepository.exists(juan))
            clientesRepository.add(juan);
        juan.addFactura(factura);
    }
}