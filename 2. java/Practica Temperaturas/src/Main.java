import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int[][] temperatures = new int[10][2];
        String[] cities = new String[10];
        int minTemperature = 999;
        int maxTemperature = 0;
        String minCity = "", maxCity = "";

        Scanner scanner = new Scanner(System.in);

        //Carga de ciudades:
        for (int i = 0; i < cities.length; i++) {
            System.out.println("Ingrese valor para la ciudad: " + i);
            cities[i] = scanner.nextLine();
        }
        //Carga de temperaturas:
        for (int i = 0; i < temperatures.length; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.println("Ingrese valor para la fila: " + i + " y columna: " + j);
                temperatures[i][j] = scanner.nextInt();
            }
        }
        //---------------------------
        for (int i = 0; i < temperatures.length; i++) {
            for (int j = 0; j < 2; j++) {
                if (temperatures[i][j] < minTemperature) {
                    minTemperature = temperatures[i][j];
                    minCity = cities[i];
                }
                if (temperatures[i][j] > maxTemperature) {
                    maxTemperature = temperatures[i][j];
                    maxCity = cities[i];
                }
            }
        }
        System.out.println("La ciudad " + minCity + " posee la menor temperatura, y es de: " + minTemperature);
        System.out.println("La ciudad " + maxCity + " posee la mayor temperatura, y es de: " + maxTemperature);
        System.out.println("Gracias!");
    }
}