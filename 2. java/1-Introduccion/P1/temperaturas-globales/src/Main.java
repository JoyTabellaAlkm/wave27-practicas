import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Scanner tecladoTemperaturas = new Scanner(System.in);

        String[] ciudades = new String[10];
        int[][] temperaturas = new int[10][2];

        for (int t = 0; t<= ciudades.length-1; t++){
            System.out.println("Cargar la ciudad" + t);
            ciudades[t]= teclado.nextLine();

            System.out.println("Ingrese temperatura mínima para la ciudad" + ciudades[t]);
            temperaturas[t][0] = tecladoTemperaturas.nextInt();

            System.out.println("Ingrese temperatura máxima para la ciudad" + ciudades[t]);
            temperaturas[t][1] =tecladoTemperaturas.nextInt();
        }

        int minTemp = temperaturas[0][0];
        int maxTemp = temperaturas[0][1];
        String minCiudad = ciudades[0];
        String maxCiudad = ciudades[0];

        for (int i = 1; i < ciudades.length; i++){
            if (temperaturas[i][0]<minTemp){
                minTemp = temperaturas [i][0];
                minCiudad = ciudades[i];
            }
            if (temperaturas[i][0]>maxTemp){
                maxTemp = temperaturas[i][0];
                minCiudad = ciudades[i];
            }
        }

        System.out.println("La menor temperatura es " + minTemp + " y es de la ciudad "+ minCiudad);
        System.out.println("La mayor temperatura es " + maxTemp + " y es de la ciudad "+ maxCiudad);


    }
}