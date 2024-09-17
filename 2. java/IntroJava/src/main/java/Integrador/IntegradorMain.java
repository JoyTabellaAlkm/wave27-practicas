package Integrador;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IntegradorMain {





    public static void main(String[] args) {

        Cliente carlos = new Cliente("96136178" , "Carlos", "Vasquez");

        Cliente pedro = new Cliente("96135122" , "Pedro", "Perez");

        Cliente matias = new Cliente("96135121" , "Matias", "Marquez");

        Scanner scan = new Scanner(System.in);

        String input;

        List<Cliente> clientes = new ArrayList<>();

        clientes.add(carlos);
        clientes.add(pedro);
        clientes.add(matias);

        clientes.forEach(System.out::println);

        clientes.remove(pedro);

        System.out.println("===========================================================");

        clientes.forEach(System.out::println);

        System.out.println("===========================================================");

        System.out.println("Ingrese el número de DNI a buscar: ");

        String inputDni = scan.nextLine();

        if( clientes.stream().anyMatch(cliente -> cliente.getDni().equals(inputDni)) ){
            Cliente clienteDni = (Cliente) clientes.stream().
                    filter(cliente -> cliente.getDni().equals(inputDni)).findFirst().get();

            System.out.println(clienteDni.toString());

        }else{
            System.out.println("No existe cliente con ese DNI");
        }

    }

}
