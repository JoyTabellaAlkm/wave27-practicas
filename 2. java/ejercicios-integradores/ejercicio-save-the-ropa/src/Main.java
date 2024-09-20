import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("SAVE THE ROPA!");

        GuardaRopa guardaRopa = new GuardaRopa();


        List<Prenda> prendasMariany = Arrays.asList(
                new Prenda("Freshka", "M"),
                new Prenda("Channel", "S"));

        Integer numeroGuardaRopa = guardaRopa.guardarPrendas(prendasMariany);

        guardaRopa.mostrarPrendas();

        List<Prenda> prendas = guardaRopa.devolverPrendas(numeroGuardaRopa);

        System.out.println(guardaRopa.getGuardaRopa());
    }
}