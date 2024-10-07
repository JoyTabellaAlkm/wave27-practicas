import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.concurrent.Callable;

public class Main {
    public static void main(String[] args) {

        Cliente cliente1= new Cliente(293445955, "Juan", "Díaz");
        Cliente cliente2= new Cliente(467678688, "Maria", "Llanos");
        Cliente cliente3= new Cliente(221234344, "Luis", "Pérez");

        List<Cliente> clientes= new ArrayList<>();
        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3);

        //recorrer lista
        System.out.println("Lista de clientes: ");
        clientes.stream().forEach(System.out::println);

        //remover un cliente
        clientes.remove(cliente2);

        //recorrer lista
        System.out.println("Lista de clientes: ");
        clientes.stream().forEach(System.out::println);

        // Solicitar el DNI por teclado
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el DNI del cliente a buscar: ");
        String dniBuscado = scanner.nextLine();

        // Buscar el cliente en la lista usando Stream
        Optional<Cliente> clienteEncontrado = clientes.stream()
                .filter(cliente -> cliente.getDni()==(Integer.parseInt(dniBuscado)))
                .findFirst();

        // Mostrar el resultado de la búsqueda
        if (clienteEncontrado.isPresent()) {
            System.out.println(clienteEncontrado.get());
        } else {
            System.out.println("Cliente con DNI " + dniBuscado + " no encontrado.");
        }

        scanner.close();

    }
}