

public class EjercicioP1 {
    public static void main(String[] args) {


        String ciudades[] = new String[] {"Londres", "Madrid", "NY",
                "BSAS", "Asuncion", "Sao Paulo", "Lima", "Santiago",
                "Lisboa", "Tokio"};

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

        int menor = Integer.MAX_VALUE;
        int mayor = Integer.MIN_VALUE;
        int indiceMenor = -1;
        int indiceMayor = -1;

        for (int i = 0; i < ciudades.length; i++) {

            if (temperaturas[i][0] < menor) {
                menor = temperaturas[i][0];
                indiceMenor = i;
            }

            if (temperaturas[i][1] > mayor) {
                mayor = temperaturas[i][1];
                indiceMayor = i;
            }
        }


        System.out.println("La ciudad con la temperatura mas baja fue: " + ciudades[indiceMenor] +
                " Con una temperatura de: " + menor);

        System.out.println("La ciudad con la temperatura mas alta fue: " + ciudades[indiceMayor] +
                " Con una temperatura de: " + mayor);

    }
}