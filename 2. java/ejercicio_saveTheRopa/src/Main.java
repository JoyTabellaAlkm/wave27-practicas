import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Prenda remera = new Prenda("Nike", "Deportivo");
        Prenda vestido = new Prenda("Gucci", "Elegante");
        List<Prenda> prendas = new ArrayList<>();

        prendas.add(remera);
        prendas.add(vestido);

        GuardaRopa guardaRopa= new GuardaRopa();

        int numeroGuardaropas = guardaRopa.guardarPrendas(prendas);

        System.out.println("Mi numero de guardaropas es: " + numeroGuardaropas);

        String msj = guardaRopa.mostrarPrendas();
        System.out.println(msj);

        List<Prenda> prendasDevueltas = guardaRopa.devolverPrendas(3);
        System.out.println("Prendas devueltas: ");
        prendasDevueltas.forEach(System.out::println);
    }
}