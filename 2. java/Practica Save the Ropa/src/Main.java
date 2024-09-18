import java.util.List;

public class Main {
    public static void main(String[] args) {
        GuardaRopa guardaRopa = new GuardaRopa();

        int codigo1 = guardaRopa.guardarPrendas(List.of(new Prenda("marca", "modelo"), new Prenda("otra marca", "otro modelo")));
        int codigo2 = guardaRopa.guardarPrendas(List.of(new Prenda("marca no pirata", "modelo original")));

        System.out.println("Mostrando todas las prendas:");
        System.out.println(guardaRopa.mostrarPrendas());
        System.out.println();

        System.out.printf("Las prendas del primer código son:\n%s%n", guardaRopa.devolverPrendas(codigo1));
        System.out.println();
        System.out.printf("Las prendas del segundo código son:\n%s%n", guardaRopa.devolverPrendas(codigo2));
        System.out.println();

        System.out.println("Mostrando todas las prendas después de devolverlas:");
        System.out.println(guardaRopa.mostrarPrendas());
    }
}