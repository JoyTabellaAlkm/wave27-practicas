import entity.Cliente;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        //Crear 3 clientes y guardarlos en una collection.
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente(123, "Cisternas", "Celeste"));
        clientes.add(new Cliente(1234, "Alvarez", "Patricio"));
        clientes.add(new Cliente(12345, "Rodriguez", "Samantha"));

        //Recorrer la collection de clientes y mostrar por pantalla los datos de cada uno de ellos.
        System.out.println("Lista clientes: ");
        clientes.stream().forEach(System.out::println);

        //Eliminar uno de los clientes de la lista y volver a consultar e imprimir todos los clientes restantes.
        try {
            clientes.remove(1);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage() + " ---- " + Arrays.toString(e.getStackTrace()));
        } finally {
            System.out.println("Lista clientes sin un cliente: ");
            clientes.stream().forEach(System.out::println);
        }

        //Solicitar por teclado un número de dni de un cliente para buscarlo. En caso de que el cliente se encuentre en la lista,
        // mostrar sus datos, caso contrario, mostrar un mensaje que informe dicha situación.
        Scanner scanner = new Scanner(System.in);
        try {

            System.out.println("Ingrese el numero de dni a buscar: ");
            int dni = scanner.nextInt();

            Optional<Cliente> c = clientes.stream().filter(cliente -> cliente.getDni() == dni).findFirst();
            if(c.isPresent())
            {
                System.out.println(c.get());
            }else{
                System.out.println("No existe cliente con ese dni: " + dni);
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage() + " ---- " + Arrays.toString(e.getStackTrace()));
        } finally {
            scanner.close();
        }

    }
}