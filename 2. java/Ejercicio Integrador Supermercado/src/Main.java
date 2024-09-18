import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Cliente> clientes = new ArrayList<>();
        Cliente cliente1 = new Cliente(1, "Pepe", "Garcia");
        Cliente cliente2 = new Cliente(2, "Carolina", "Perez");
        Cliente cliente3 = new Cliente(3, "Ana", "Lopez");

        List<Item> items = new ArrayList<>();

        List<Factura> facturas = new ArrayList<>();
        Factura factura1 = new Factura(cliente1, items, 500.0);
        Factura factura3 = new Factura(cliente3, items, 500.0);

        clientes.add(cliente1);
        clientes.add(cliente2);

        System.out.println("Clientes registrados: ");
        clientes.forEach(System.out::println);

        System.out.println("\nIngrese dni de cliente a eliminar: ");
        int dniElim = scanner.nextInt();
        clientes.remove(dniElim-1);
        System.out.println("\nCliente eliminado. Clientes actuales: ");
        clientes.forEach(System.out::println);

        System.out.println("\nIngrese el dni del cliente: ");
        int dni = scanner.nextInt();
        List<Cliente> filtrado = clientes.stream().filter(cliente -> dni == cliente.getDni()).toList();
        if(filtrado.isEmpty()) {
            System.out.println("El cliente no existe");
        } else {
            filtrado.forEach(System.out::println);
        }

        CargadorFacturas cargadorFacturas = new CargadorFacturas();

        facturas = cargadorFacturas.agregarFactura(factura1, clientes);
        System.out.println("\nFactura con cliente existente: ");
        for(Factura f : facturas) {
            System.out.println(f.toString());
        }
        for(Cliente c : clientes) {
            System.out.println(c.toString());
        }

        System.out.println("\nSin cliente existente");
        facturas = cargadorFacturas.agregarFactura(factura3, clientes);
        for(Factura f : facturas) {
            System.out.println(f.toString());
        }
        for(Cliente c : clientes) {
            System.out.println(c.toString());
        }
    }
}