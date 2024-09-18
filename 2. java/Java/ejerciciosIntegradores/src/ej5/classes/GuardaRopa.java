package ej5.classes;

import java.util.HashMap;
import java.util.List;

public class GuardaRopa {
    private HashMap<Integer, List<Prenda>> diccionario;
    private int contador;

    public GuardaRopa() {
        this.diccionario = new HashMap<>();
        this.contador = contador;
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda) {
        Integer clave = contador;
        diccionario.put(clave, listaDePrenda);
        contador++;
        return clave;
    }

    public void mostrarPrendas() {
        diccionario.forEach((clave, listadoDePrendas) -> {
            System.out.println(
                    "Id: " + clave);
            listadoDePrendas.forEach(System.out::println);
        });

    }

    public List<Prenda> devolverPrendas(Integer numero) {
        List<Prenda> listadoDePrendas = diccionario.get(numero);
        if (listadoDePrendas == null) {
            // diccionario.containsKey(numero); puede ser esto en vez de este if
            System.out.println("No hay prendas para devolver");
        }
        diccionario.remove(numero);
        return listadoDePrendas;
    }


}
