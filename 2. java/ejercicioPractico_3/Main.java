/* Un portal de noticias tiene registrados datos de las diferentes temperaturas que obtuvieron algunas ciudades del
 *  mundo durante el año pasado; a partir de estos registros, pudieron determinar la más baja y la más alta para cada
 *  una de las ciudades. Por ejemplo, se determinó que para Londres, la mínima fue de -2º C y la máxima de 33º C.
 *  Sin embargo, actualmente necesitan armar una noticia en donde especifiquen cuál es la temperatura máxima que
 * hubo entre todas las ciudades registradas y cuál fue la mínima. Para ello cuentan con un vector con los nombres de
 * cada una de las ciudades y una matriz de dos columnas que especifican su temperatura máxima y mínima, los cuales se
 * especifican a continuación:
 */
public class main {

    public static void main(String[] args) {

        String[] ciudadesDelMundo = {"Londres","Madrid","New York", "Buenos Aires", "Asuncion", "Sao Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};
        int [][] tempMaxYMin = {{-2,33}, {-3, 32}, {-8, 27}, {4, 37},{6, 42}, {5, 43}, {0, 39}, {-7, 26}, {-1, 31}, {-10, 35}};

        String ciudadConMaxTemp = "";
        String ciudadConMinTemp = "";

        int valorMax = 0;
        int valorMin = 0;

        for (int i = 0; i < ciudadesDelMundo.length; i++) {
            for (int j = 0; j < 2; j++) {
                if (tempMaxYMin[i][0] < valorMin) {
                    ciudadConMinTemp = ciudadesDelMundo[i];
                    valorMin = tempMaxYMin[i][j];
                    System.out.println("Minima temperatura " + valorMin);
                }
                if (tempMaxYMin[i][j] > valorMax) {
                    ciudadConMaxTemp = ciudadesDelMundo[i];
                    valorMax = tempMaxYMin[i][j];
                    System.out.println("Maxima temperatura " +valorMax);
                }
            }
        }
        System.out.println("Maxima temperatura:\n " + valorMax +"\nCiudad: \n"+ ciudadConMaxTemp);
        System.out.println("Minima temperatura:\n " +valorMin + "\nCiudad: \n" + ciudadConMinTemp);
    }
}
