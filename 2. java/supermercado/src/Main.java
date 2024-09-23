import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Administrador administrador = new Administrador();

        Cliente cliente1 = new Cliente(1,"Pepe","Paez");
        Cliente cliente2 = new Cliente(2,"Nico","Aguilar");
        Cliente cliente3 = new Cliente(3,"Jose","Cuervo");

        administrador.addCliente(cliente1);
        administrador.addCliente(cliente2);
        administrador.addCliente(cliente3);
        administrador.showCliente();

        administrador.deleteCliente(cliente1);
        administrador.showCliente();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el dni del usuario a buscar: ");
        int dni = scanner.nextInt();
        administrador.showClienteEspecifico(dni);




    }
}