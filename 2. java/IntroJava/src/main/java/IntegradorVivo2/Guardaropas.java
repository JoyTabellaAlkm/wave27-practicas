package IntegradorVivo2;

import com.sun.jdi.request.ExceptionRequest;

import java.util.*;

public class Guardaropas {

    private static Map<Integer, List<Prenda>> prendas = new HashMap<Integer, List<Prenda>>();

    private static List<Integer> keysPrendas = new ArrayList<>();

    private static final Random rand = new Random();

    public static int guardarPrendas(List<Prenda> prendasNuevas) {

        int key = generadorKey();

        keysPrendas.add(key);

        prendas.put(key, prendasNuevas);

        return key;
    }

    private static int generadorKey(){
        int randomNumber;

        do{
            randomNumber = (int) (Math.random() * 100000 + 1);
        }while(prendas.containsKey(randomNumber));

        return randomNumber;
    }

    public static void mostrarPrendas(){
        keysPrendas.forEach(key -> System.out.println(prendas.get(key)));
    }

    public static List<Prenda> devolverPrendas(int key){

        if(prendas.containsKey(key)){
            return prendas.get(key);
        }else{
            throw new RuntimeException("No existe ninguna prenda guardada con esa key");
        }

    }

}
