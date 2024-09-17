package IntegradorVivo2;

import java.util.ArrayList;
import java.util.List;

public class IntegradorMain {

    public static void main(String[] args){

        Prenda prenda1 = new Prenda("Adidas", "Aero");
        Prenda prenda2 = new Prenda("Nike", "Ground");

        List<Prenda> prendas = new ArrayList<>();
        prendas.add(prenda1);
        prendas.add(prenda2);

        int key = Guardaropas.guardarPrendas(prendas);

        System.out.println("Key:" + key);

        Guardaropas.devolverPrendas(key).forEach(System.out::println);

    }

}
