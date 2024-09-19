package org.example;

import org.example.models.GuardaRopa;
import org.example.models.Prenda;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GuardaRopa gr = new GuardaRopa();

        // crear prendas al azar
        System.out.println("Ingresa numero de prendas a crear");
        int prendasACrear = Integer.parseInt(sc.nextLine());
        List<Prenda> prendasCreadas = crearListaPrendas(prendasACrear);

        // Usar guardaropas
        int id1 = gr.guardarPrendas(prendasCreadas);
        gr.mostrarPrendas();
        System.out.println(gr.devolverPrendas(id1));
    }

    private static List<Prenda> crearListaPrendas(int cantPrendas) {
        List<String> marcas = List.of("Nike", "Adidas", "Puma", "Underarmor");
        List<String> modelo = List.of("Negro", "Azul", "Celeste", "Verde");
        List<Prenda> listaPrendas = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < cantPrendas; i++) {
            String marca = marcas.get(random.nextInt(marcas.size()));
            String modeloCreado = modelo.get(random.nextInt(modelo.size()));
            listaPrendas.add(new Prenda(marca, modeloCreado));
        }

        return listaPrendas;
    }
}