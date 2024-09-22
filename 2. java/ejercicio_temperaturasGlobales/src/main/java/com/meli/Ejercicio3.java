package com.meli;//Un portal de noticias tiene registrados datos de las diferentes temperaturas que obtuvieron algunas ciudades
// del mundo durante el año pasado; a partir de estos registros, pudieron determinar la más baja y la más alta
// para cada una de las ciudades. Por ejemplo, se determinó que para Londres,
// la mínima fue de -2º C y la máxima de 33º C. Sin embargo, actualmente necesitan armar una noticia
// en donde especifiquen cuál es la temperatura máxima que hubo entre todas las ciudades registradas
// y cuál fue la mínima. Para ello cuentan con un vector con los nombres de cada una de las ciudades
// y una matriz de dos columnas que especifican su temperatura máxima y mínima, los cuales se especifican a continuación:
//Sabiendo que cada índice de fila representa a una ciudad. Se necesita conocer la mayor y
// la menor temperatura entre todas las ciudades; al mismo tiempo se deberá especificar el nombre de la ciudad.
// Por ejemplo, la menor temperatura la tuvo Tokio, con -10 º C.

public class Ejercicio3 {
    public static void main(String[] args) {
        int[][] temperatures = {
                {-2, 33},
                {-3, 32},
                {-8, 27},
                {4, 37},
                {6, 42},
                {5, 43},
                {0, 39},
                {-7, 26},
                {-1, 31},
                {-10, 35}
        };

        String[] cities = new String[10];
//        int[][] temperatures = new int[10][2];
//        temperatures[0][0] = -2;
//        temperatures[0][1] = 33;
//        temperatures[1][0] = -3;
//        temperatures[1][1] = 32;
//        temperatures[2][0] = -8;
//        temperatures[2][1] = 27;
//        temperatures[3][0] = 4;
//        temperatures[3][1] = 37;
//        temperatures[4][0] = 6;
//        temperatures[4][1] = 42;
//        temperatures[5][0] = 5;
//        temperatures[5][1] = 43;
//        temperatures[6][0] = 0;
//        temperatures[6][1] = 39;
//        temperatures[7][0] = -7;
//        temperatures[7][1] = 26;
//        temperatures[8][0] =-1;
//        temperatures[8][1] = 31;
//        temperatures[9][0] = -10;
//        temperatures[9][1] = 35;

        cities[0] = "londres";
        cities[1] = "madrid";
        cities[2] = "nueva york";
        cities[3] = "buenos aires";
        cities[4] = "asuncion";
        cities[5] = "sao paulo";
        cities[6] = "lima";
        cities[7] = "santiago de chile";
        cities[8] = "lisboa";
        cities[9] = "tokio";

        int minTemp = temperatures[0][0];
        int maxTemp = temperatures[0][1];
        String minCity = "";
        String maxCity = "";

        for (int f = 0; f < temperatures.length; f++) {
            for (int c = 0; c < temperatures[f].length; c++) {

                if (temperatures[f][c] < minTemp) {
                    minTemp = temperatures[f][c];
                    minCity = cities[f];
                }
                if (temperatures[f][c] > maxTemp) {
                    maxTemp = temperatures[f][c];
                    maxCity = cities[f];
                }

            }
        }
        System.out.println("La ciudad con temperatura más baja es: " + minCity + " y la temperatura es de: " + minTemp);
        System.out.println("La ciudad con mayor temperatura es: " + maxCity + " y la temperatura es de: " + maxTemp);
    }
}
