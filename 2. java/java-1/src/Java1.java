public class Java1 {
    public static void main(String[] args) {
        String[] ciudades = obtenerCiudades();
        int[][] temperaturas = obtenerTemperaturas();

        int ciudadMin = 0;
        int ciudadMax = 0;

        for (int i = 0; i < temperaturas.length; i++) {
            if (temperaturas[i][0] < temperaturas[ciudadMin][0])
                ciudadMin = i;
            if (temperaturas[i][1] > temperaturas[ciudadMax][1])
                ciudadMax = i;
        }

        System.out.printf(
                "La ciudad con menor temperatura mínima es %s (%d°C)%n",
                ciudades[ciudadMin],
                temperaturas[ciudadMin][0]);
        System.out.printf("La ciudad con mayor temperatura máxima es %s (%d°C)%n",
                ciudades[ciudadMax],
                temperaturas[ciudadMax][1]);
    }

    private static String[] obtenerCiudades() {
        return new String[] {
                "Londres", "Madrid",
                "Nueva York", "Buenos Aires",
                "Asunción", "Sao Paulo",
                "Lima", "Santiago de Chile",
                "Lisboa", "Tokio"
        };
    }

    private static int[][] obtenerTemperaturas() {
        return new int[][] {
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
    }
}
