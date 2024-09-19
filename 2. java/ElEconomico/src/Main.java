import models.Cliente;
import models.Factura;
import models.productos.Item;
import repository.ClienteRepository;
import repository.FacturaRepository;
import repository.ProductoRepository;
import supermercado.Supermercado;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        Supermercado elChino = new Supermercado();

        // crearClientes
        ClienteRepository clientRepo = new ClienteRepository();
        Cliente cliente1 = new Cliente(12345678L, "Juan", "Perez");
        Cliente cliente2 = new Cliente(23456789L, "Maria", "Gomez");
        Cliente cliente3 = new Cliente(34567890L, "Carlos", "Rodriguez");
        clientRepo.save(cliente1);
        clientRepo.save(cliente2);
        clientRepo.save(cliente3);

        // Lista de facturas
        FacturaRepository  facturaRepo = new FacturaRepository();


        // Lista de items
        ProductoRepository productRepo = new ProductoRepository();

        // Crear listas de items para cada factura
        List<Item> items1 = new ArrayList<>();
        items1.add(new Item(1, "Leche", 100.0, 10));
        items1.add(new Item(2, "Pan", 50.0, 20));
        items1.add(new Item(3, "Mantequilla", 70.0, 15));

        List<Item> items2 = new ArrayList<>();
        items2.add(new Item(4, "Arroz", 200.0, 30));
        items2.add(new Item(5, "Pollo", 150.0, 25));
        items2.add(new Item(6, "Verduras", 80.0, 40));

        List<Item> items3 = new ArrayList<>();
        items3.add(new Item(7, "Frutas", 90.0, 35));
        items3.add(new Item(8, "Cereal", 120.0, 15));
        items3.add(new Item(9, "Yogurt", 60.0, 20));

// Crear facturas
Factura factura1 = new Factura(1123123L, cliente1, items1);
Factura factura2 = new Factura(2234234L, cliente2, items2);
Factura factura3 = new Factura(3345345L, cliente3, items3);

// Guardar facturas en el repositorio
facturaRepo.save(factura1);
facturaRepo.save(factura2);
facturaRepo.save(factura3);



        String dniBuscado = solicitarDni();
        Cliente clienteBuscado = elChino.buscarCliente(dniBuscado);
        String mensajeConsola = clienteBuscado != null ? clienteBuscado.toString() : "No existe el cliente";
        System.out.println(mensajeConsola);


        List<Item> items = new ArrayList<>();
        items.add(new Item(1, "Item1", 100.0, 10));
        items.add(new Item(2, "Item2", 200.0, 20));
        items.add(new Item(3, "Item3", 300.0, 30));

        validarCliente(clienteBuscado, elChino, dniBuscado);
        Factura fc1 = new Factura(1123123L, clienteBuscado, items);
    }

    private static void validarCliente(Cliente cliente, Supermercado supermercado, String dni) {
        if (cliente == null) {
            System.out.println("No existe el cliente, vamos a crearlo. Por favor, ingrese el nombre.");
            String nombre = sc.nextLine();
            System.out.println("Ahora el apellido.");
            String apellido = sc.nextLine();

            supermercado.crearCliente(dni, nombre, apellido);
        }
    }

    private static String solicitarDni() {
        String dni = "";

        do {
            System.out.println("Por favor ingresar el dni del cliente");
            dni = sc.nextLine();
        } while (dni.isEmpty());

        return dni;
    }
}