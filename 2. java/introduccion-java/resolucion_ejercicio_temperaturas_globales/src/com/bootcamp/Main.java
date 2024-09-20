package com.bootcamp;

import java.util.Scanner;

public class Main {

    String[] ciudades = {
            "Londres",
            "Madrid",
            "Nueva York",
            "Buenos Aires",
            "Asunción",
            "Sao Paulo",
            "Lima",
            "Santiago de Chile",
            "Lisboa",
            "Tokio"
    };

    int[][] temperaturas = new int[10][2]; //[][0] minimo
    //[][1] maximo
    temperaturas[0][0] = -2;
    temperaturas[0][1] = 33;

    temperaturas[1][0] = -3;
    temperaturas[1][1] = 32;

    temperaturas[2][0] = -8;
    temperaturas[2][1] = 27;

    temperaturas[3][0] = 4;
    temperaturas[3][1] = 37;

    temperaturas[4][0] = 6;
    temperaturas[4][1] = 42;

    temperaturas[5][0] = 5;
    temperaturas[5][1] = 43;

    temperaturas[6][0] = 0;
    temperaturas[6][1] = 39;

    temperaturas[7][0] = -7;
    temperaturas[7][1] = 27;

    temperaturas[8][0] = -1;
    temperaturas[8][1] = 31;

    temperaturas[9][0] = -10;
    temperaturas[9][1] = 35;

    String ciudadMayor = "";
    String ciudadMenor = "";
    int maximo = Integer.MIN_VALUE;
    int minimo = Integer.MAX_VALUE;

        for (int i = 0; i < ciudades.length; i++) {
        String ciudad = ciudades[i];
        if(temperaturas[i][0] < minimo) {
            ciudadMenor = ciudad;
            minimo = temperaturas[i][0];
        }

        if(temperaturas[i][1] > maximo) {
            ciudadMayor = ciudad;
            maximo = temperaturas[i][1];
        }
    }

        System.out.println("La ciudad con mayor temperatura registrada es: " + ciudadMayor + ". Su temperatura es: " + maximo);
        System.out.println("La ciudad con menor temperatura registrada es: " + ciudadMenor + ". Su temperatura es: " + minimo);
        System.out.println();
}
