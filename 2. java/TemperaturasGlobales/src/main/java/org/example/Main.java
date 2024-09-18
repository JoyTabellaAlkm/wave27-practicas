package org.example;

public class Main {
    public static void main(String[] args) {
        String cities[] = {"Londres", "Madrid",
                "Nueva York", "Buenos Aires",
                "Asunción", "São Paulo",
                "Lima", "Santiago de Chile",
                "Lisboa", "Tokio"};
        int temperatures[][] = {
                {-2, 33}, // Londres
                {-3, 32}, // Madrid
                {-8, 27}, // Nueva York
                {4, 37},  // Buenos Aires
                {6, 42},  // Asunción
                {5, 43},  // São Paulo
                {0, 39},  // Lima
                {-7, 26}, // Santiago de Chile
                {-1, 31}, // Lisboa
                {-10, 35} // Tokio
        };

        int minTemp = temperatures[0][0];
        int maxTemp = temperatures[0][1];

        String minCity = cities[0];
        String maxCity = cities[0];

        for (int i = 1; i < cities.length; i++) {
            if (temperatures[i][0] < minTemp) {
                minTemp = temperatures[i][0];
                minCity = cities[i];
            }
            if (temperatures[i][1] > maxTemp) {
                maxTemp = temperatures[i][1];
                maxCity = cities[i];
            }
        }

        System.out.println("La menor temperatura la tuvo " + minCity + " con " + minTemp);
        System.out.println("La mayor temperatura la tuvo " + maxCity + " con " + maxTemp);
    }
}

