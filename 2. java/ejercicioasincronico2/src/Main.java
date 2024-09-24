import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Cliente> clientes=  new ArrayList<>();
        Cliente cliente1 = new Cliente("1234","leidy","rodas");
        Cliente cliente2 = new Cliente("12345","leidy","rodas");
        Cliente cliente3 = new Cliente("12234","leidy","rodas");
        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3);

        System.out.println("lista de clientes");
        imprimirClientes(clientes);

        clientes.remove(cliente1);
        System.out.println("despues de eliminado");
        imprimirClientes(clientes);

        System.out.println("Que numero dni deseas buscar");
        String dni = scanner.nextLine();
         clientes.stream().filter(x-> Objects.equals(x.getDni(), dni))
                 .findFirst()
                 .ifPresentOrElse((texto -> System.out.println(texto)),
                         ()-> System.out.println("no hay datos de ese cliente"));


        Cliente cliente4 = new Cliente("122343","leidyr","rodriguez");

         List<Item> items = new ArrayList<>();

           items.add(new Item("1001","zapatos",23,15000));
           items.add(new Item("1001","zapatos",23,15000));
           items.add(new Item("1001","zapatos",23,15000));
           items.add(new Item("1001","zapatos",23,15000));

           Factura factura= new Factura(cliente4, items, 60000);

           List<Factura> facturas = new ArrayList<>();
           facturas.add()

    }

    private static void imprimirClientes(List<Cliente> clientes) {
        for(Cliente clientesList : clientes){
            System.out.println("la lista de clientes son"+ clientesList);
        }
    }
}