public class Main {
    public static void main(String[] args) {
        String[] cities = new String[10];
        int[][] temperatures = new int[10][2];
        int colderTemperature = 0;
        int hotterTemperature = 0;
        String colderCity = "";
        String hotterCity = "";

        cities[0] = "Londres";
        cities[1] = "Madrid";
        cities[2] = "Nueva York";
        cities[3] = "Buenos Aires";
        cities[4] = "Asunción";
        cities[5] = "Sao Paulo";
        cities[6] = "Lima";
        cities[7] = "Santiago de Chile";
        cities[8] = "Lisboa";
        cities[9] = "Tokio";

        temperatures[0][0] = -2;
        temperatures[0][1] = 33;
        temperatures[1][0] = -3;
        temperatures[1][1] = 32;
        temperatures[2][0] = -8;
        temperatures[2][1] = 27;
        temperatures[3][0] = 4;
        temperatures[3][1] = 37;
        temperatures[4][0] = 6;
        temperatures[4][1] = 42;
        temperatures[5][0] = 5;
        temperatures[5][1] = 43;
        temperatures[6][0] = 0;
        temperatures[6][1] = 39;
        temperatures[7][0] = -7;
        temperatures[7][1] = 26;
        temperatures[8][0] = -1;
        temperatures[8][1] = 31;
        temperatures[9][0] = -10;
        temperatures[9][1] = 35;


        for (int f = 0; f < cities.length; f++) {
            for (int c = 0; c < 2; c++) {
                if (temperatures[f][c] < colderTemperature) {
                    colderTemperature = temperatures[f][c];
                    colderCity = cities[f];
                }
                if (temperatures[f][c] > hotterTemperature) {
                    hotterTemperature = temperatures[f][c];
                    hotterCity = cities[f];
                }
            }
        }

        System.out.println("La ciudad más fría es: " + colderCity + " con una temperatura de " + colderTemperature + " grados Celsius.");
        System.out.println("La ciudad más caliente es: " + hotterCity + " con una temperatura de " + hotterTemperature + " grados Celsius.");

    }
}