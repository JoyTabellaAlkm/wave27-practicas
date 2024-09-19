import java.sql.Array;

public class Main {
    public static void main(String[] args) {
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
        int[][] temperaturas = {
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
        int menorTemperatura =0;
        String ciudadMenorTemperatura = "";
        int mayorTemperatura = 0;
        String ciudadMayorTemperatura = "";

        for (int i = 0; i< ciudades.length; i++){
                if(temperaturas[i][0] < menorTemperatura){
                    menorTemperatura = temperaturas[i][0];
                    ciudadMenorTemperatura = ciudades[i];
                }
            if (temperaturas[i][1] > mayorTemperatura) {
                mayorTemperatura = temperaturas[i][1];
                ciudadMayorTemperatura = ciudades[i];
            }
        }
        System.out.println("La menor temperatura la tuvo " + ciudadMenorTemperatura + " con " + menorTemperatura + "°C");
        System.out.println("La mayor temperatura la tuvo " + ciudadMayorTemperatura + " con " + mayorTemperatura + "°C");
    }
}