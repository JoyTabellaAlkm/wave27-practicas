/** Un portal de noticias tiene registrados datos de las diferentes temperaturas que obtuvieron algunas ciudades del
 *  mundo durante el año pasado; a partir de estos registros, pudieron determinar la más baja y la más alta para cada
 *  una de las ciudades. Por ejemplo, se determinó que para Londres, la mínima fue de -2º C y la máxima de 33º C.
 *  Sin embargo, actualmente necesitan armar una noticia en donde especifiquen cuál es la temperatura máxima que
 * hubo entre todas las ciudades registradas y cuál fue la mínima. Para ello cuentan con un vector con los nombres de
 * cada una de las ciudades y una matriz de dos columnas que especifican su temperatura máxima y mínima, los cuales se
 * especifican a continuación:
 */
import java.util.Scanner;

public class EjercicioTemperaturaP1 {

    public static void main(String[] args) {

            String vectorCiudades[] = new String[10];
            double matrizTemperaturas[][] = new double[10][2];
            double tempMinima, tempMaxima;
            String ciudadMinima, ciudadMaxima;


            Scanner teclado = new Scanner(System.in);
            Scanner teclado2 = new Scanner(System.in);

            System.out.println("------------------------------------------------------");
            System.out.println("////SOFTWARE de Temperaturas Globales////");
            System.out.println("------------------------------------------------------");
            System.out.println("Cargue los datos de las ciudades y sus temperaturas mínimas y máximas");

            //Recorrido de carga de datos para el vector y la matriz

            for (int f = 0; f <= 9; f++) {
                System.out.println("------------------------------------------------------");
                System.out.println("Ingrese el nombre de la ciudad en la posicion: " + f);
                vectorCiudades[f] = teclado.nextLine();

                for (int c = 0; c <= 1; c++) {
                    if (c == 0) {
                        System.out.println("Ingrese la temperatura mínima para la ciudad de: " + vectorCiudades[f]);
                        matrizTemperaturas[f][c] = teclado2.nextInt();
                    } else {
                        System.out.println("Ingrese la temperatura máxima para la ciudad de: " + vectorCiudades[f]);
                        matrizTemperaturas[f][c] = teclado2.nextInt();
                    }
                }

            }

            //Se utiliza variables auxiliares para guardar las temperaturas y ciudades

            tempMinima = matrizTemperaturas[0][0];
            ciudadMinima = vectorCiudades[0];
            tempMaxima = matrizTemperaturas[0][0];
            ciudadMaxima = vectorCiudades[0];

            //Recorrido para encontrar la temperatura mínima y máxima

            for (int f = 0; f <= 9; f++) {
                for (int c = 0; c <= 1; c++) {

                    //Condición para encontrar la temperatura mínima y guardar la ciudad que posea la misma
                    if (matrizTemperaturas[f][c]<tempMinima){
                        tempMinima=matrizTemperaturas[f][c];
                        ciudadMinima=vectorCiudades[f];
                    }
                    //Condición para encontrar la temperatura máxima y guardar la ciudad que posea la misma
                    if (matrizTemperaturas[f][c]>tempMaxima){
                        tempMaxima=matrizTemperaturas[f][c];
                        ciudadMaxima=vectorCiudades[f];
                    }

                }
            }

            System.out.println("-------------------");
            System.out.println("---INFORME FINAL---");
            System.out.println("-------------------");
            System.out.println("La ciudad de " + ciudadMinima + " es la ciudad con la temperatura mínima de: " + tempMinima);
            System.out.println("La ciudad de " + ciudadMaxima + " es la ciudad con la temperatura máxima de: " + tempMaxima);
            System.out.println("------------------------------------------------------------------------------------------");
    }
}